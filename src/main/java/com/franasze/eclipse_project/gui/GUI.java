package com.franasze.eclipse_project.gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.franasze.eclipse_project.API.IBookAPI;
import com.franasze.eclipse_project.model.Book;

public class GUI {

	private static final GUI instance = new GUI();
	private final static Scanner scanner = new Scanner(System.in);

	public void start() {

		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("resources/config.properties");
			prop.load(input);

			String BookImplementation = prop.getProperty("bookdb.class");
			Class<?> classChooser = Class.forName(BookImplementation);
			IBookAPI bookDB = (IBookAPI) classChooser.newInstance();

			bookDB.getBooks().forEach(System.out::println);
			System.out.println("ADD");
			bookDB.addBook(readNewBookData());
			System.out.println("DELETE");
			bookDB.deleteBook(scanner.nextInt());
			System.out.println("RENT TIME");
			bookDB.rentBook(scanner.nextLine());

			bookDB.getBooks().forEach(System.out::println);
		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
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
				int year = Integer.parseInt(scanner.nextLine());
				return new Book(title, author, year, ISBN, true);
			} catch (Exception e) {
				System.out.println("ISBN is the International Standard Book Number,\n try again with correct number");
				e.printStackTrace();
			}
		}
	}

	public static GUI getInstance() {
		return instance;
	}
}
