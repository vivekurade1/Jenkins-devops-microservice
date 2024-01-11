pipeline {
	agent any
	//agent { docker { image 'maven:3.9.6'} }
	parameters {
		checkbox(name: 'Stage', defaultValue: 'Build','Compile','Test','Integration Test', discription:'Choose which stages to run')
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

