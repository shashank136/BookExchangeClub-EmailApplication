package com.goodbookclub.bookclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.goodbookclub.bookclub.config.EmailConfig;

@Service
public class SendEmailServiceImpl implements SendEmailService {

	private EmailConfig emailCfg;
	
	@Autowired
	public void setEmailCfg(EmailConfig emailCfg) {
		this.emailCfg = emailCfg;
	}
	
	@Override
	public void sendEmail(String firstname, String lastname, String toEmail, String content) {
		// Create a mail sender
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost(this.emailCfg.getHost());
		mailsender.setPort(this.emailCfg.getPort());
		mailsender.setUsername(this.emailCfg.getUsername());
		mailsender.setPassword(this.emailCfg.getPassword());
				
		// create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("retail@bookclub.com");
		mailMessage.setTo(toEmail);
		mailMessage.setSubject("Order placed !!!");
		mailMessage.setText(content);
				
		// send mail
		mailsender.send(mailMessage);		
	}

}
