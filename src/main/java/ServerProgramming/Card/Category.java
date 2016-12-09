package ServerProgramming.Card;

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
 	private List<Card> Cards;
 
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
 	
 	public List<Card> getCards() {
 		return Cards;
 	}
 	
 	public void setCards(List<Card> books) {
 		this.Cards = books;
 	}
 	
 	@Override
 	public String toString() {
 		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
 	}
}