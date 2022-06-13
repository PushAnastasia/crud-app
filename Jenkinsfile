pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
                sh "echo JAVA_HOME=$JAVA_HOME"
                sh 'mvn clean test'
            }
        }
    }
}
