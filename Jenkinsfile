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
                   --net=bridge \
                   -d \
                   --publish 9000:9000 app'
            }
        }
    }
}
