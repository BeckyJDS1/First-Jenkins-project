pipeline {
    agent any;
    parameters {
        string(name: 'TEST', defaultValue: 'sd')
    }
    stages {
        steps {
            sh '.test'
        }
    }
}
