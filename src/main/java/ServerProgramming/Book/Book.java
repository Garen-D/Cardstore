package ServerProgramming.Book;

public class Book {
	private long title;
	private long author;
	private long year;
	private long isbn;
	private long price;
	public long getTitle() {
		return title;
	}
	public void setTitle(long title) {
		this.title = title;
	}
	public long getAuthor() {
		return author;
	}
	public void setAuthor(long author) {
		this.author = author;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year
				+ ", isbn=" + isbn + ", price=" + price + "]";
	}

}
