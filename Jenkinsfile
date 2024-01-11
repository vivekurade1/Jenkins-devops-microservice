pipeline {
	agent any
	//agent { docker { image 'maven:3.9.6'} }
	parameters {
		booleanParam(name: 'Build', defaultValue: true, discription:'Runs build stage')
		booleanParam(name: 'Compile', defaultValue: false, discription:'Runs Compile stage')
		booleanParam(name: 'Test', defaultValue: false, discription:'Runs test stage')
		booleanParam(name: 'Integration Test', defaultValue: false, discription:'Runs Integration Stage')
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
				echo "Build"
			}
		}

		stage('Compile') {
			steps{
				sh 'mvn clean compile'
			}
		}

		stage('Test') {
			steps{
				sh 'mvn test'
			}
		}

		stage('Integration Test') {
			steps{
				sh 'mvn failsafe:integration-test failsafe:verify'
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

