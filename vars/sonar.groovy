def sonarScan(Map config=[:]){
    def scannerHome = tool 'Dev Sonar Scanner';
    
    withSonarQubeEnv('Dev SonarQube Server') { // If you have configured more than one global server connection, you can specify its name
    sh "${scannerHome}/bin/sonar-scanner \
    -Dsonar.projectKey=${config.project} \
    -Dsonar.sources=. \
    -Dsonar.host.url=http://10.0.0.11:9009 \
    -Dsonar.login=${config.key}"
    }
}
