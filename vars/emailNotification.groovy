def call(checkout_status){    
    emailext attachLog: true, body: "Checkout: ${checkout_status}", subject: "${PROJECT_NAME} - BuildID # ${BUILD_NUMBER} - ${BUILD_STATUS}!", to: "kalinga.ranasinghe@gears-int.com"        
}
