pipeline {
    agent {
       dockerfile true
    }
    stages {
        stage('Run tests on CRUD app') {
            steps {
                sh 'docker build -t crud-app .'
                sh 'docker run -p 9000:9000 -t crud-app'
            }
        }
    }
}
