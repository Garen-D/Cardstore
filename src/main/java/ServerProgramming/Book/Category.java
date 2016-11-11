package ServerProgramming.Book;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long categoryid;
 	private String name;
 
 	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
 	private List<Book> Books;
 
 	public Category() {}

 	public Category(String name) {
 		super();
 		this.name = name;
 	}
 	
 	public Long getCategoryid() {
 		return categoryid;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public List<Book> getBooks() {
 		return Books;
 	}
 	
 	public void setBooks(List<Book> books) {
 		this.Books = books;
 	}
 	
 	@Override
 	public String toString() {
 		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
 	}
}
