pipeline {
	agent { docker { image 'maven : 3.6.3'}}
	stages{
		stage('Build') {
			steps{
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

