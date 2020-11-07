package com.goodbookclub.bookclub.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailContent {
	private String firstname;
	private String lastname;
	private String email;
	private String Content;
}
