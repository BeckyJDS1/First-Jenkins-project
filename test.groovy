pipeline {
    agent any;
    parameters {
        string(name: 'TEST' value: $STRING)
    }
    stages {
        steps {
            sh '.test'
        }
    }
}
