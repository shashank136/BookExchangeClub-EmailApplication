package com.goodbookclub.bookclub.controllers;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodbookclub.bookclub.config.EmailConfig;
import com.goodbookclub.bookclub.service.Feedback;

@RestController
public class EmailController {

	private EmailConfig emailCfg;
	
	@Autowired
	public void setEmailCfg(EmailConfig emailCfg) {
		this.emailCfg = emailCfg;
	}

	@PostMapping("/feedback")
	public void sendFeedBack(@RequestBody Feedback feedback, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is invalid.");
		}
		
		// Create a mail sender
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost(this.emailCfg.getHost());
		mailsender.setPort(this.emailCfg.getPort());
		mailsender.setUsername(this.emailCfg.getUsername());
		mailsender.setPassword(this.emailCfg.getPassword());
		
		// create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("retail@bookclub.com");
		mailMessage.setTo(feedback.getEmail());
		mailMessage.setSubject("Order placed !!!");
		mailMessage.setText(feedback.getFeedback());
		
		// send mail
		mailsender.send(mailMessage);
	}
}
