pipeline {
    agent {
        docker {
            image 'maven:3.8.8-eclipse-temurin-17'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
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
