node {
    stage 'Clone the project'
    git 'https://github.com/arshadshah/demo.git'


        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Runing unit tests") {
                    bat "mvn test"
                }
            }
            }
            stage("Staging") {
                bat 'mvn spring-boot:run -Dserver.port=8989'
                }
    }
