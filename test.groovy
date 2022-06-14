pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: '-')
    }
    stages {
        stage('Print') {
            steps {
                sh '''
                    echo $TEST
                    touch text.txt
                    echo "text.txt file was created" >> text.txt
                    echo $?
                '''
            }
        }
    }
}
