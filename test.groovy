pipeline {
    agent any;
    parameters {
        string(name: 'TEST', value: 'sd')
    }
    stages {
        steps {
            sh '.test'
        }
    }
}
