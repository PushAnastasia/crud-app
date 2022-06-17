pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'docker build -t app .'
                sh 'docker network create mynetwork --driver bridge'
            }
        }
        stage('run') {
            steps {
                sh 'docker run -p 9000:9000 --net=mynetwork app'
            }
        }
    }
}
