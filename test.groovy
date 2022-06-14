switch(TEST) {
    case "-" :  TEST = "text.txt"
                break;
    case "test" :  TEST = "log.txt"
                break;
    default :  TEST = "default.txt"
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
                    touch $TEST
                    echo ".txt file was created" > $TEST
                    echo $(cat $TEST)
                    echo $?
                '''
            }
        }
    }
    post {
        always {
           archiveArtifacts artifacts: "$TEST"
        }
    }
}
