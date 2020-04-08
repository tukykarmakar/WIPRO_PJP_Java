class Author
{
	private String name, email;
	private char gender;

	Author(String authorName, String authorEmail, char authorGender)
	{
		this.name = authorName;
		this.email = authorEmail;
		this.gender = authorGender;
	}

	public String getName()
	{	return this.name;	}
	public String getEmail()
	{	return this.email;	}
	public char getGender()
	{	return this.gender;	}
}

class Book
{
	private Author author;
	private String name;
	private double price;
	private int qtyInStock;

	Book(Author bookAuthor, String bookName, double bookPrice, int quantity)
	{
		this.author = bookAuthor;
		this.name = bookName;
		this.price = bookPrice;
		this.qtyInStock = quantity;
	}

	public String getAuthorName()
	{	return this.author.getName();	}
	public String getAuthorEmail()
	{	return this.author.getEmail();	}
	public char getAuthorGender()
	{	return this.author.getGender();	}

	public String getName()
	{	return this.name;	}
	public double getPrice()
	{	return this.price;	}
	public int getQuantityInStock()
	{	return this.qtyInStock;	}
}

class Assignment
{
	public static void main(String args[])
	{
		Author author = new Author("Dan Brown", "danbrown@gmail.com", 'M');
		Book book = new Book(author, "Inferno", 309.00, 15000);

		System.out.println("Book Name:\t" + book.getName());
		System.out.println("Author Name:\t" + book.getAuthorName());
		System.out.println("Author Email:\t" + book.getAuthorEmail());
		System.out.println("Author Gender:\t" + book.getAuthorGender());
		System.out.println("Book Price:\t" + book.getPrice());
		System.out.println("Book Qty.:\t" + book.getQuantityInStock());
	}
}