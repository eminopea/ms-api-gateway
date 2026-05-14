pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {

        stage('Info') {
            steps {
                echo "Branch actual: ${env.BRANCH_NAME}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            // colocar con junit5
            steps {
                sh 'mvn test'
            }
        }
 
        stage('SonarQube') {
            steps {
                withSonarQubeEnv('sonar-local') {
                    sh """
                    mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=ms-api-gateway \
                    -Dsonar.branch.name=${env.BRANCH_NAME} \
                    -Dsonar.login=$SONAR_TOKEN
                    """
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy DEV') {
            when {
                branch 'develop'
            }
            steps {
                echo "Deploy en DEV..."
            }
        }

        stage('Deploy QA') {
            when {
                branch 'qa'
            }
            steps {
                echo "Deploy en QA..."
            }
        }

        stage('Deploy PROD') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploy en PRODUCCIÓN 🚨"
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline exitoso"
        }
        failure {
            echo "❌ Pipeline falló"
        }
    }
}