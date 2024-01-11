pipeline {
	agent any
	//agent { docker { image 'maven:3.9.6'} }
	parameters {
		booleanParam(name: 'Build', defaultValue: true, description:'Runs build stage')
		booleanParam(name: 'Compile', defaultValue: false, description:'Runs Compile stage')
		booleanParam(name: 'Test', defaultValue: false, description:'Runs test stage')
		booleanParam(name: 'Integration Test', defaultValue: false, description:'Runs Integration Stage')
	}
	environment {
		dockerHome =  tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	stages{
		stage('Build') {
			steps{
				sh 'docker version'
				sh 'mvn --version'
				echo "*******Build*******"
			}
		}

		stage('Compile') {
			steps{
				sh 'mvn clean compile'
				echo "********Compile done******"		}
		}

		/*stage('Test') {
			steps{
				sh 'mvn test'
			}
		}

		stage('Integration Test') {
			steps{
				sh 'mvn failsafe:integration-test failsafe:verify'
			}
		}*/


		stage('CreatePackage') {
			steps{
				echo "********Creating package******"
				sh 'mvn package -DskipTest'
				echo "************Package Created*************"
			}
		}

		stage('Docker Build') {
			steps{
				script {
					dockerImage = docker.build("vivekurade/currency-exchange-devops:${env.BUILD_TAG}")
				}
			}
		}

		stage('Docker Deploy') {
			steps{
				script{
					dockerImage.withRegistry('', dockerhub) {
						dockerImage.push();
						dockerImage.push('latest');
					}
				}
			}
		}
	}
	
	post{
		always{
			echo 'Pipeline will always run'
		}
		success{
			echo 'Pipeline is successfull'
		}
		failure{
			echo 'pipeline is failed'
		}
	}
}

