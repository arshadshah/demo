node {
    stage 'Clone the project'
    git 'https://github.com/arshadshah/demo.git'

    dir('spring-jenkins-pipeline') {

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Runing unit tests") {
                        sh "./mvnw test"
                }
            }
            }

            stage("Staging") {
                sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid "
                + "|| kill -KILL \$pid"
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                }
            }
        }
    }
