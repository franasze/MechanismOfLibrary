package com.franasze.eclipse_project;

import com.franasze.eclipse_project.repositories.BookDAOImplementation1;
import com.franasze.eclipse_project.repositories.BookDBImplementation2;

import java.util.Scanner;

import com.franasze.eclipse_project.API.IBookAPI;
import com.franasze.eclipse_project.model.Book;

public class App {
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

//		IBookAPI bookDB = new BookDAOImplementation1();
		IBookAPI bookDB = new BookDBImplementation2();

		System.out.println("Hello World!");

		bookDB.getBooks().forEach(System.out::println);
		bookDB.addBook(readNewBookData());
		bookDB.deleteBook(1);
		System.out.println("RENT TIME");
		bookDB.rentBook(scanner.nextLine());
		bookDB.getBooks().forEach(System.out::println);
	}

	public static Book readNewBookData() {
		while (true) {
			try {
				System.out.println("Title:");
				String title = scanner.nextLine();
				System.out.println("Author:");
				String author = scanner.nextLine();
				System.out.println("ISBN: ");
				int ISBN = Integer.parseInt(scanner.nextLine());
				return new Book(777, title, author, 2024, ISBN, true);
			} catch (NumberFormatException e) {
				System.out.println("ISBN is the International Standard Book Number,\n try again with correct number");
			}
		}
	}
}
