pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
        stage('Run tests on CRUD app') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
