pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'docker build app .'
            }
        }
                stage('run') {
                    steps {
                        sh 'docker run -p 9000:9000 app'
                    }
                }
    }
}
