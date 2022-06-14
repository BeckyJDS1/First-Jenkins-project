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
                        string(name: 'TEST', value: $STRING)
                    ]
                }
            }
        }
    }
    post {
        always {
            sh 'STRING="post"; echo $STRING'
        }
    }
}
