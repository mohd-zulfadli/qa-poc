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
                        sh 'echo "=== Workspace contents after TestNG copyArtifacts ==="; ls -R'
                    }
                }
                stage('Karate') {
                    when { expression { params.RUN_KARATE } }
                    steps {
                        build job: 'qa-poc-karate', propagate: true, wait: true
                        copyArtifacts(projectName: 'qa-poc-karate', selector: lastSuccessful())
                        sh 'echo "=== Workspace contents after Karate copyArtifacts ==="; ls -R'
                    }
                }
                stage('Robot Framework') {
                    when { expression { params.RUN_ROBOT } }
                    steps {
                        build job: 'samplerobotframework', propagate: true, wait: true
                        copyArtifacts(projectName: 'samplerobotframework', selector: lastSuccessful())
                        sh 'echo "=== Workspace contents after Robot copyArtifacts ==="; ls -R'
                    }
                }
            }
        }
    }
    post {
        always {
            // Collect JUnit XMLs copied from downstream jobs
            // Option 1: flattened structure
            junit 'target/surefire-reports/*.xml'
            junit 'karate/target/surefire-reports/*.xml'

            // Option 2: preserved subfolder structure
            junit 'java-tests/target/surefire-reports/*.xml'
            junit 'karate-tests/target/surefire-reports/*.xml'

            // Publish Java TestNG report (both options)
            publishHTML([
                reportDir: 'target/surefire-reports',
                reportFiles: 'emailable-report.html',
                reportName: 'Java TestNG Report (flatten)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
            publishHTML([
                reportDir: 'java-tests/target/surefire-reports',
                reportFiles: 'emailable-report.html',
                reportName: 'Java TestNG Report (preserved)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            // Publish Karate report (both options)
            publishHTML([
                reportDir: 'target/surefire-reports',
                reportFiles: 'karate-summary.html',
                reportName: 'Karate Report (flatten)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
            publishHTML([
                reportDir: 'karate-tests/target/surefire-reports',
                reportFiles: 'karate-summary.html',
                reportName: 'Karate Report (preserved)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            // Publish Robot Framework report (both options)
            publishHTML([
                reportDir: 'results',
                reportFiles: 'report.html',
                reportName: 'Robot Framework Report (flatten)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
            publishHTML([
                reportDir: 'robot-tests/results',
                reportFiles: 'report.html',
                reportName: 'Robot Framework Report (preserved)',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            // Archive everything for download
            archiveArtifacts artifacts: '**/surefire-reports/**', fingerprint: true
        }
    }
}
