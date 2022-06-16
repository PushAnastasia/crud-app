pipeline {

    agent { docker { image 'maven:3.3.3' } }
      stages {
       stage('Initialize'){
              def dockerHome = tool 'myDocker'
              env.PATH = "${dockerHome}/bin:${env.PATH}"
          }
        stage('log version info') {
      steps {
        sh 'mvn --version'
        sh 'mvn spring-boot:run'
      }
    }
  }
}
