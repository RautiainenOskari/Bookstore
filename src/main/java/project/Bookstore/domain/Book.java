package project.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title, author;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private Integer isbn, ReleaseYear;
	private Double price;

	public Book() {}
	
	public Book(String title, String author, Category category, Integer isbn, Integer releaseYear, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.isbn = isbn;
		ReleaseYear = releaseYear;
		this.price = price;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getReleaseYear() {
		return ReleaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		ReleaseYear = releaseYear;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
