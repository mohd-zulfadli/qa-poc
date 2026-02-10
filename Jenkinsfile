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
            publishHTML([ 
                reportDir: 'karate-tests/target/karate-reports', 
                reportFiles: 'karate-summary.html', 
                reportName: 'Karate Test Report' 
            ]) 
        } 
    }
}
