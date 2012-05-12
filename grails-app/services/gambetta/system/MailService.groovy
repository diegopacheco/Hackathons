package gambetta.system

import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage

class MailService {
    boolean transactional = false
    MailSender mailSender

    def sendEmails(mails) {
        def messages = []
        for (mail in mails) {
            messages << buildMessage(mail)
        }
        // Send them all together
        try {
            println "about to send message yeah"
            mailSender.send(messages as SimpleMailMessage[])
        } catch (MailException ex) {
            println "Failed to send emails"
            ex.printStackTrace()
        }
    }
   
   
    def buildMessage(mail) {
        SimpleMailMessage message = new SimpleMailMessage()
        message.from = "gambetta@gmail.com"
        message.to = mail.to
        message.text = mail.text
        message.subject = mail.subject
        return message
    }	
}
