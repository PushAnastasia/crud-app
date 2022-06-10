pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }

        stage('Run tests') {
                    steps {
                        sh 'mvn clean test'
                    }
                }

        stage('Shut down app') {
                    steps {
                        sh 'mvn spring-boot:stop'
                    }
                }
    }
}
