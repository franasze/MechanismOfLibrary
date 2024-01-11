package com.franasze.eclipse_project.model;

public class Book {

	private final int id;
	private final String title;
	private final String author;
	private final int publicationYear;
	private final int ISBN;
	private boolean status;

	public Book(int id, String title, String author, int publicationYear, int ISBN, boolean status) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.ISBN = ISBN;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getISBN() {
		return ISBN;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("%-35s %-35s %-13s %-9s", title, author, ISBN, status ? "AVAILABLE" : "BORROWED");
	}

}
