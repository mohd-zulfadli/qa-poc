pipeline {
    agent any
    parameters {
        booleanParam(name: 'RUN_TESTNG', defaultValue: true, description: 'Run Java TestNG regression')
        booleanParam(name: 'RUN_KARATE', defaultValue: true, description: 'Run Karate regression')
        booleanParam(name: 'RUN_ROBOT', defaultValue: true, description: 'Run Robot Framework regression')
    }
    stages {
        stage('Debug Params') {
            steps {
                echo "RUN_TESTNG = ${params.RUN_TESTNG}"
                echo "RUN_KARATE = ${params.RUN_KARATE}"
                echo "RUN_ROBOT = ${params.RUN_ROBOT}"
            }
        }
        stage('Regression Suites') {
            parallel {
                stage('Java TestNG') {
                    when { expression { params.RUN_TESTNG } }
                    steps {
                        build job: 'qa-poc-java-TestNG', propagate: true, wait: true
                        copyArtifacts(projectName: 'qa-poc-java-TestNG', selector: lastSuccessful())
                    }
                }
                stage('Karate') {
                    when { expression { params.RUN_KARATE } }
                    steps {
                        build job: 'qa-poc-karate', propagate: true, wait: true
                        copyArtifacts(projectName: 'qa-poc-karate', selector: lastSuccessful())
                    }
                }
                stage('Robot Framework') {
                    when { expression { params.RUN_ROBOT } }
                    steps {
                        build job: 'samplerobotframework', propagate: true, wait: true
                        copyArtifacts(projectName: 'samplerobotframework', selector: lastSuccessful())
                    }
                }
            }
        }
    }
    post {
        always {
            // Collect all JUnit XMLs copied from downstream jobs
            junit '**/surefire-reports/*.xml'

            // Publish Java TestNG report
            publishHTML([
                reportDir: 'target/surefire-reports',
                reportFiles: 'emailable-report.html',
                reportName: 'Java TestNG Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])

            // Publish Karate report
            publishHTML([
                reportDir: 'target/surefire-reports',
                reportFiles: 'karate-summary.html',
                reportName: 'Karate Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])

            // Publish Robot Framework report
            publishHTML([
                reportDir: 'results',
                reportFiles: 'report.html',
                reportName: 'Robot Framework Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])

            // Archive everything for download
            archiveArtifacts artifacts: '**/surefire-reports/**', fingerprint: true
        }
    }
}
