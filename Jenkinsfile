pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-org/qa-poc.git'
            }
        }
        stage('Karate Tests') {
            steps {
                dir('qa-poc/karate-tests') {
                    sh 'mvn clean test'
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'qa-poc/karate-tests/target/karate-reports/*.html', fingerprint: true
        }
    }
}
