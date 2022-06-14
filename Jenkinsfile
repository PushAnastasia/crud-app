pipeline {
    agent {
        docker {
            dockerfile true
            }
    }
    stages {
        stage('Run Application') {
            steps {
                sh 'docker build -t crud-app .'
                sh 'docker run -p 9000:9000 -t crud-app'
            }
        }
    }
}
