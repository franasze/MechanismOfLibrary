package com.franasze.eclipse_project.API;

import java.util.List;
import com.franasze.eclipse_project.model.Book;

public interface IBookAPI {
	List<Book> getBooks();
	
	void addBook(Book book);
	
	void deleteBook(final int id);

	void rentBook(String title);
	
}
