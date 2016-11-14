package com.dandab.books;

/**
 * @author Dana Dabbagh
 */
class Book
{
	private int id;
	private String imageURL;
	private String title;
	private String author;
	private double price;
	private String link;

	Book(int id)
	{
		this.id = id;
	}

	public Book()
	{

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getImageURL()
	{
		return imageURL;
	}

	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Book book = (Book) o;

		if (id != book.id) return false;
		if (Double.compare(book.price, price) != 0) return false;
		if (imageURL != null ? !imageURL.equals(book.imageURL) : book.imageURL != null) return false;
		if (title != null ? !title.equals(book.title) : book.title != null) return false;
		if (author != null ? !author.equals(book.author) : book.author != null) return false;
		return link != null ? link.equals(book.link) : book.link == null;
	}

	@Override
	public int hashCode()
	{
		int result;
		long temp;
		result = id;
		result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (link != null ? link.hashCode() : 0);
		return result;
	}
}