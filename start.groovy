pipeline {
    agent any;
    parameters {
        string (name: 'STRING', defaultValue: 'Hello world', description: 'String to print')
    }
    stages {
        stage('Print') {
            step {
                sh 'echo $STRING'
            }
        }
    }
    post {
        always {
            sh 'STRING="post"; echo $STRING'
        }
    }
}
