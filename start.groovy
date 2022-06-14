pipeline {
    agent any;
    parameters {
        string (name: 'STRING', defaultValue: 'Hello', description: 'String to print')
    }
    stages {
        stage('Print') {
            steps {
                sh 'echo $STRING'
                sh 'STRING="test"'
                script {
                    build job : 'test',
                    parameters: [
                        string(name: 'TEST', value: 'test')
                    ]
                }
            }
        }
    }
    post {
        always {
            sh '''
                touch log.txt
                cat ${JENKINS_HOME}/jobs/${JOB_NAME}/builds/${BUILD_NUMBER}/log >> log.txt
            '''
        }
    }
}
