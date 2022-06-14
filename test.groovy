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
                    echo "text.txt file was created" > text.txt
                    echo $(cat text.txt)
                    echo $?
                '''
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: "text.txt"
        }
    }
}
