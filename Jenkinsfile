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
                        copyArtifacts(projectName: 'qa-poc-java-TestNG', flatten: true)
                        sh 'echo "=== After TestNG copyArtifacts ==="; ls -R'
                    }
                }

                stage('Karate') {
                    when { expression { params.RUN_KARATE } }
                    steps {
                        build job: 'qa-poc-karate', propagate: true, wait: true
                        copyArtifacts(projectName: 'qa-poc-karate', flatten: true)
                        sh 'echo "=== After Karate copyArtifacts ==="; ls -R'
                    }
                }

                stage('Robot Framework') {
                    when { expression { params.RUN_ROBOT } }
                    steps {
                        build job: 'samplerobotframework', propagate: true, wait: true
                        copyArtifacts(projectName: 'samplerobotframework', flatten: true)
                        sh 'echo "=== After Robot copyArtifacts ==="; ls -R'
                    }
                }
            }
        }
    }

    post {
        always {
            //
            // 🔹 TestNG results
            //
            junit '**/TEST-*.xml'
            junit '**/testng-results.xml'

            publishHTML([
                reportDir: '.',
                reportFiles: 'emailable-report.html',
                reportName: 'Java TestNG Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            //
            // 🔹 Karate results
            //
            junit 'karate-tests/target/surefire-reports/*.xml'

            publishHTML([
                reportDir: 'karate-tests/target/karate-reports',
                reportFiles: 'karate-summary.html',
                reportName: 'Karate Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            //
            // 🔹 Robot Framework results
            //
            junit 'robot-output/**/output.xml'

            publishHTML([
                reportDir: 'robot-output/master-suite',
                reportFiles: 'report.html',
                reportName: 'Robot Framework Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])

            //
            // 🔹 Archive everything
            //
            archiveArtifacts artifacts: '**/*.xml, **/*.html', fingerprint: true
        }
    }
}
