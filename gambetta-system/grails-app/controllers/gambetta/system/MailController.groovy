package gambetta.system

 /**
 * Hit "http://localhost:8080/myapp/testEmails?to=me@somewhere.com&subject=hello+world&body=This+is+a+test" to send an email to yourself
 */

class MailController {
    MailService  emailerService
    // Send an email
    def index = {
        // Each "email" is a simple Map
        def email = [
            to: [ params.to ],        // "to" expects a List, NOT a single email address
            subject: params.subject,
            text: params.body         // "text" is the email body
        ]
        // sendEmails expects a List
        emailerService.sendEmails([email])
        render("done")
    }
}
