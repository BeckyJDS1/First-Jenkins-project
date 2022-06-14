pipeline {
    agent any;
    parameters {
        string (name: 'STRING', defaultValue: 'Hello', description: 'String to print')
    }
    stages {
        stage('Print') {
            steps {
                sh 'echo $STRING'
                sh '$STRING=test'
                def result = build job : 'testing',
                parameters : [
                    extendedChoice(name: 'TEST', value: $STRING);
                ]
            }
        }
    }
    post {
        always {
            sh 'STRING="post"; echo $STRING'
        }
    }
}
