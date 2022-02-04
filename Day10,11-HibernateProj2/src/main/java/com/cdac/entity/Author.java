package com.cdac.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Author {

	private int id;
	private String name;
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
}
