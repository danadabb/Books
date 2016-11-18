package com.dandab.books;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Dana
 */
public class BookTest
{
	@Test
	public void testBookGetterSetter()
	{
		int expected = 123;
		Book book = new Book();
		book.setId(expected);
		assertThat(book.getId(), is(equalTo(expected)));
	}

	@Test
	public void testBooksNotEqual()
	{
		Book bookOne = new Book(1);
		bookOne.setAuthor("author");
		bookOne.setImage("image");
		bookOne.setLink("link");
		bookOne.setPrice(0);
		bookOne.setTitle("title");
		Book bookTwo = new Book(2);
		bookTwo.setAuthor("author");
		bookTwo.setImage("image");
		bookTwo.setLink("link");
		bookTwo.setPrice(0);
		bookTwo.setTitle("title");

		assertThat(bookOne, is(not(equalTo(bookTwo))));
	}
}
