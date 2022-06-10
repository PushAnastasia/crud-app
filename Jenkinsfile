pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn spring-boot:run'
            }
        }

        stage('Run tests') {
                    steps {
                        bat 'mvn clean test'
                    }
                }

        stage('Shut down app') {
                    steps {
                        bat 'mvn spring-boot:stop'
                    }
                }
    }
}
