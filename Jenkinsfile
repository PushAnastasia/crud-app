pipeline {
agent { dockerfile true }
    stages {
        stage('Run Application') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}
