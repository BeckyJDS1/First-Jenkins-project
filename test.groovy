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
                sh '''
                    echo $TEST
                    touch $fileName
                    echo "fileName.txt file was created" > $fileName
                    echo $(cat $fileName)
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
