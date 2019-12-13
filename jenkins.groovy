node {
    stage 'Clone the project'
    git 'https://github.com/arshadshah/demo.git'

    dir('spring-jenkins-pipeline') {

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Runing unit tests") {
                    bat " mvnw test"
                }
            }
            }
            stage("Staging") {
                bat ' mvnw spring-boot:run -Dserver.port=8989'
                }
        }
    }
