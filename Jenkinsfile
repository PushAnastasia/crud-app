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
                sh 'docker run -d --network=my-bridge-network -p 9000:9000 app'
            }
        }
    }
}
