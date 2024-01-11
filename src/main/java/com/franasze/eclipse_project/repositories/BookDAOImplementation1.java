package com.franasze.eclipse_project.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.franasze.eclipse_project.API.IBookAPI;
import com.franasze.eclipse_project.model.Book;

public class BookDAOImplementation1 implements IBookAPI {
	

		@Override
		public List<Book> getBooks() {
			List<Book> books = new ArrayList<>();
			
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("resources/books.xml");
			NodeList booksList = doc.getElementsByTagName("book");
			for (int i = 0; i < booksList.getLength(); i++) {
				Node b = booksList.item(i);
				if (b.getNodeType() == Node.ELEMENT_NODE) {
					Element book = (Element) b;
					String id = book.getAttribute("id");
					NodeList titleList = book.getChildNodes();
					for (int j = 0; j < titleList.getLength(); j++) {
						Node t = titleList.item(j);
						if(t.getNodeType()== Node.ELEMENT_NODE) {
							Element title = (Element) t;
							System.out.println("Book"+ id + ":"+ title.getTagName()
							+ "="+ title.getTextContent());
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addBook(Book book) {

	}

	@Override
	public void deleteBook(final int id) {
		

	}

	@Override
	public void rentBook(String title) {
		// TODO Auto-generated method stub
		return false;
	}

}
