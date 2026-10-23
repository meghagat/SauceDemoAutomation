pipeline {
    agent any

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Choose browser for test execution'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat "mvn clean test -Dbrowser=${params.BROWSER}"
            }
        }
    }

    post {
        always {

            junit 'target/surefire-reports/TEST-*.xml'

            publishHTML([
                reportDir: 'reports',
                reportFiles: 'index.html',
                reportName: 'Extent Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])

            archiveArtifacts(
                artifacts: 'reports/**',
                allowEmptyArchive: true
            )
        }
    }
}