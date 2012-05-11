package gambetta.system

 /**
 * Hit "http://localhost:8080/myapp/testEmails?to=me@somewhere.com&subject=hello+world&body=This+is+a+test" to send an email to yourself
 */

class MailController {
    MailService  mailService
    // Send an email
    def send  = {
        // Each "email" is a simple Map
        def email = [
            to: [ "mayer1990@gmail.com", "alexandrepoletto@gmail.com"  ],        // "to" expects a List, NOT a single email address
            subject: "teste" ,
            text: "testando"         // "text" is the email body
        ]
        // sendEmails expects a List
	    mailService.sendEmails([email])
        render("done")
    }
}
