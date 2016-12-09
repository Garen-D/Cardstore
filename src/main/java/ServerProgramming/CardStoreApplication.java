package ServerProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ServerProgramming.Card.User;
import ServerProgramming.Card.CardRepository;
import ServerProgramming.Card.Card;
import ServerProgramming.Card.Category;
import ServerProgramming.Card.CategoryRepository;
import ServerProgramming.Card.UserRepository;


@SpringBootApplication
public class CardStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CardStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CardStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cardDemo(CardRepository repository, CategoryRepository crepository, UserRepository urepository){
		return (args) -> {
			log.info("save a couple of cards");
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science"));
			
			repository.save(new Card("Knife Juggler", "2", 2, "After you summon a minion, deal 1 damage to a random enemy", "2", crepository.findByName("Fantasy").get(0)));
			repository.save(new Card("River Crocolisk", "3", 2, "", "2", crepository.findByName("Fantasy").get(0)));

			
			User user1 = new User("user", "$$2a$04$j.tfXAjn.f5Qj.yxvlfHy.TA6T.IJwtL8FU0982bNoUU7LF1JvzsW", "USER");
			User user2 = new User("admin", "$2a$04$c7rAW3xf2c2Qqn3YA8I9DuNmQmnI4bXMwho9f./bH3KKCvYKgSJUK", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all cards");
			for (Card card : repository.findAll()) {
				log.info(card.toString());
			}
		};
	}

	}
