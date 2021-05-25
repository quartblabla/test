pipeline {
    environment {
    registry = "andrewkachmar/adetails"
    registryCredential = "dockerhub"
  }
    agent any
    tools {
        maven 'Maven 3.8.1'
        jdk 'openJDK9'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package'
                //sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
