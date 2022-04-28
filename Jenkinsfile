pipeline {
     agent any
     triggers {
          pollSCM('* 0/10 * * *')
     }
     stages {
        stage('Test') {
            agent { docker { image "circleci/openjdk:8u212-jdk-stretch" } }
            steps {
                sh 'mvn clean package'
                stash includes: '**/target/*.jar', name: 'app'
            }
        }

        stage('Docker Build') {
           steps {
               echo 'Starting to build docker image'

                unstash 'app'
                script {
                    def customImage = docker.build("ip:5002/jenkins-test:${new Date().format('yyyy-MM-dd-HH-mm-ss')}")
                    customImage.push()
                }
           }
        }
     }
}