def call(Map config=[:]){    
    def scannerHome = tool 'Dev Sonar Scanner';
    withSonarQubeEnv('Dev SonarQube Server') {
        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=config.project \
                            -Dsonar.sources=. \
                            -Dsonar.host.url=http://10.0.0.11:9009 \
                            -Dsonar.login=1e8ef92786cab5caf31c1ecce580bc9b24e2cd4f"
    };
        
    def qg = waitForQualityGate();
        if(qg.status != "OK"){
            echo "NOT OK"
        }else
        {
            echo "OK"
        }
}
