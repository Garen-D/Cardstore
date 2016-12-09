package ServerProgramming.Card;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String health;
	private Integer attack;
	private String effect;
	private String cost;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Card() {};
			
	
	public Card(String name, String health, Integer attack,
			String effect, String cost, Category category) {
		super();
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.effect = effect;
		this.cost = cost;
		this.category = category;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHealth() {
		return health;
	}


	public void setHealth(String health) {
		this.health = health;
	}


	public Integer getAttack() {
		return attack;
	}


	public void setAttack(Integer attack) {
		this.attack = attack;
	}


	public String getEffect() {
		return effect;
	}


	public void setEffect(String effect) {
		this.effect = effect;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		if (this.category != null)
			return "Card [id=" + id + ", name=" + name + ", health=" + health
					+ ", attack=" + attack + ", effect=" + effect + ", cost=" + cost
					+ " category =" + this.getCategory() + "]";
		return "Card [id=" + id + ", name=" + name + ", health=" + health
				+ ", attack=" + attack + ", effect=" + effect + ", cost=" + cost
				+ "]";
	}
	
	
}