pipeline {
    agent any
    stages {
        stage('Karate Tests') {
            steps {
                dir('karate-tests') {
                    sh 'mvn clean test -Dkarate.options="--tags @SMOKE"'
                }
            }
        }
    }
    post {
        always {
            junit 'karate-tests/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'karate-tests/target/karate-reports/*.html', fingerprint: true
        }
    }
}
