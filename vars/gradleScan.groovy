def call(project){    


    timeout(time: 1, unit: 'HOURS') {
        def scannerHome = tool 'Dev Sonar Scanner';
        withSonarQubeEnv('Dev SonarQube Server') {
        sh """
          ./gradlew sonarqube \
          -Dsonar.projectKey=${project} \
          -Dsonar.host.url=http://10.0.0.11:9009 \
          -Dsonar.login=1e8ef92786cab5caf31c1ecce580bc9b24e2cd4f
          """
    };
        
    }
    
        
    def qg = waitForQualityGate();
        if(qg.status != "OK"){
            echo "Quality Gate Not OK"
        }else if (qg.status == "OK")
        {
            echo "Quality Gate OK"
        }
        
}
