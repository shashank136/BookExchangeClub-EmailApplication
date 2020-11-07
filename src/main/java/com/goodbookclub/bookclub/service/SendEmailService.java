package com.goodbookclub.bookclub.service;

public interface SendEmailService {

	void sendEmail(String firstname, String lastname, String toEmail, String content);
}
