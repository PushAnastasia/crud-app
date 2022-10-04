pipeline {
    agent any
    stages {
        stage('Build application') {
            steps {
                sh 'docker build -t app .'
            }
        }
        stage('Run application') {
            steps {
                sh 'docker run --name crud-app --network jenkins --env DOCKER_HOST=tcp://docker:2376 -d --publish 9000:9000 app'
            }
        }
    }
}
