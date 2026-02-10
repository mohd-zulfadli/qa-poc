pipeline {
    agent any
    tools {
        jdk 'Zulu_17'          // configure in Manage Jenkins → Global Tool Configuration
        maven 'Maven_3.9.6'    // configure Maven here too
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
