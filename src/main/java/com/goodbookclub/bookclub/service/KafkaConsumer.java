package com.goodbookclub.bookclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.goodbookclub.bookclub.domains.EmailContent;

@Service
public class KafkaConsumer {
	
	private SendEmailService sendEmailService;
	
	@Autowired
	public void setSendEmailService(SendEmailService sendEmailService) {
		this.sendEmailService = sendEmailService;
	}

	@KafkaListener(topics = "Order_Emails", groupId ="group_json", 
			containerFactory = "emailKafkaListenerFactory")
    public void consumeJson(EmailContent email) {
        System.out.println("Consumed JSON Message: " + email);
        sendEmailService.sendEmail(email.getFirstname(), email.getLastname(), email.getEmail(), email.getContent());
    }
}
