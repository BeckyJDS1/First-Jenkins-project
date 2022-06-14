def fileName;

switch(TEST) {
    case "-" :  fileName = "text.txt"
                break;
    case "test" :  fileName = "log.txt"
                break;
    default :  fileName = "default.txt"
                break;
}

pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: '-')
    }
    stages {
        stage('Print') {
            steps {
            FILENAME=$filename
                sh '''
                    echo $TEST
                    touch $FILENAME
                    echo "FILENAME.txt file was created" > FILENAME
                    echo $(cat $FILENAME)
                    echo $?
                '''
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: "$fileName"
        }
    }
}
