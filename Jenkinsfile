pipeline {
     agent any
     triggers {
          pollSCM('* * * * *')
     }
     stages {
        stage('Test') {
            agent { docker {
                image "circleci/openjdk:8u212-jdk-stretch"
                args '-v /usr/local/docker-cache:/root/.m2'
                            }
                 }
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
                    def customImage = docker.build("172.29.145.109/:5000/on-my-jenkins:${new Date().format('yyyy-MM-dd-HH-mm-ss')}")
                    customImage.push()
                }
           }
        }
     }
}
