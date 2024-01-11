pipeline {
	agent any
	//agent { docker { image 'maven:3.9.6'} }
	environment {
		mavenHome = '$myMaven'
		dockerHome = '$myDocker'
		PATH = "$mavenHome/bin:$dockerHome/bin:$PATH"
	}

	stages{
		stage('Build') {
			steps{
				sh 'docker version'
				sh 'mvn --version'
				echo "Build"
			}
		}
		stage('Test') {
			steps{
				echo "Test"
			}
		}
		stage('Integration Test') {
			steps{
				echo "Integration Test"
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

