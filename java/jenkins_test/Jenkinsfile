pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/marvincudjoe/ds-and-algorithms', branch: 'main')
      }
    }
    stage('Unit & Integration Tests') {
      steps {
        script {
          try {
            sh './gradlew clean test'
            }
            finally {              
              junit '**/build/test-results/test/*.xml'
            }
          }
      }
    }
  }
}