def call(checkout_status){    
    emailext attachLog: true, body: "Checkout: ${checkout_status}", subject: "", to: "kalinga.ranasinghe@gears-int.com"        
}
