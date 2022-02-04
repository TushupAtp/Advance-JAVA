package com.cdac.entity;

import java.util.List;

import javax.persistence.OneToMany;

public class Book {

	private int id;
	private String title;
	private double cost;
	private String publication;

	@OneToMany(mappedBy = "book")
	private List<Author> authors;
}
