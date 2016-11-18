package com.dandab.books;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;


public class CommonTest {

	protected final int id = 1;
	protected final String image = "www.image.com/myimage.png";
	protected final String title = "My Life";
	protected final String author = "Dana Dabbagh";
	protected final double price = 5.99;
	protected final String link = "/api/v1/items/42";
	protected Book book;
	protected BookDao bookDao = BookDao.getInstance();

	@Before
	public void beforeCommonTest() {
		book = new Book();
		book.setImage(image);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);
		book.setLink(link);
	}

	protected List<Book> insertBooks(int count) {
		List<Book> books = new ArrayList<>();
		for (int index = 1; index <= count; index++) {
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setImage(image);
			book.setPrice(price);
			bookDao.saveOrUpdateBook(book);
			books.add(book);
		}
		return books;
	}

}