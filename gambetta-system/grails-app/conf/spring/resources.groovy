// Place your Spring DSL code here
beans = {
	
	mailSender(org.springframework.mail.javamail.JavaMailSenderImpl) {
		host = 'smtp.gmail.com'
		port = 465
		username = 'alexandrepoletto@gmail.com'
		password = 'rune.e28'
		javaMailProperties = ['mail.smtp.auth': 'true',
            'mail.smtp.socketFactory.port': '465',
            'mail.smtp.socketFactory.class': 'javax.net.ssl.SSLSocketFactory',
            'mail.smtp.socketFactory.fallback': 'false']
	}
}
