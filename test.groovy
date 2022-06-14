pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: '-')
    }
    stages {
        steps {
            sh 'echo ".test"'
        }
    }
}
