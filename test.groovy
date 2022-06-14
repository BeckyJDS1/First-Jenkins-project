switch(TEST) {
    case "-" :  sh 'TEST="text.txt"'
                break;
    case "test" :  sh 'TEST="log.txt"'
                break;
    default :  sh 'TEST="default.txt"'
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
