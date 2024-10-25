#!/user/bin/env groovy

def call() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]){
        sh 'docker build -t gelsonmoreno/java-maven-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push gelsonmoreno/java-maven-app:jma-2.0'
    }
}