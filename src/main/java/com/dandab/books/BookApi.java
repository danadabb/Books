package com.dandab.books;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * @author Dana Dabbagh
 */

@Path("v1/items")
@Produces(MediaType.APPLICATION_JSON)
public class BookApi
{

	private static final String ITEMS_URL = "/api/v1/items";

	@GET
	@JSONP(queryParam = "callback")
	public String getAllBooks(@QueryParam("offset") int offset,
							  @QueryParam("count") int count,
							  @QueryParam("callback") String callback) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
		List<Book> books = BookDao.getInstance().getAllBooks(offset, count);
		for(Book book: books)
		{
			book.setLink(ITEMS_URL + "/" + book.getId());
		}

		return mapper.writeValueAsString(books);
	}

	@DELETE
	@JSONP(queryParam = "callback")
	public void deleteAllBooks()
	{
		BookDao.getInstance().deleteAllBooks();
	}

	@GET
	@Path("/{id}")
	@JSONP(queryParam = "callback")
	public String getBook(@PathParam("id") int id) throws IOException
	{

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
		Book book = BookDao.getInstance().getBook(id);
		return mapper.writeValueAsString(book);
	}

	@PUT
	@JSONP(queryParam = "callback")
	public void putBook(String bookJson) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		Book book = mapper.readValue(bookJson, Book.class);
		BookDao.getInstance().saveOrUpdateBook(book);
	}
}
