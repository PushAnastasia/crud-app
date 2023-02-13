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
                sh 'docker run \
                   --network "external-api" \
                   -d \
                   --publish 9000:9000 app'
            }
        }
    }
}
