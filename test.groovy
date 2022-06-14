pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: '-')
    }
    stages {
        stage('Print') {
            steps {
                sh '''
                    touch log.txt
                    echo ".txt file was created" > log.txt
                    echo $(cat log.txt)
                    echo $?
                '''
            }
        }
    }
    post {
        always {
           archiveArtifacts artifacts: "log.txt"
        }
    }
}
