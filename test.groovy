pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: '-')
    }
    stages {
        stage('Print') {
            steps {
                sh 'echo $TEST'
		sh 'touch text.txt'
		sh 'echo $?'
            }
        }
    }
}
