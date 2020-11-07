package com.goodbookclub.bookclub.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {
	
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String feedback;
}
