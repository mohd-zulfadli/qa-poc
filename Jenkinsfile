pipeline {
    agent any
    stages {
        stage('Karate Tests') {
            steps {
                dir('qa-poc/karate-tests') {
                    sh 'mvn clean test -Dkarate.options="--tags @SMOKE"'
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
