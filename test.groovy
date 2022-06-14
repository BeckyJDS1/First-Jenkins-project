pipeline {
    agent any;
    parameters {
        string(name: 'TEST')
    }
    stages {
        steps {
            sh '.test'
        }
    }
}
