package ServerProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ServerProgramming.Book.User;
import ServerProgramming.Book.BookRepository;
import ServerProgramming.Book.Book;
import ServerProgramming.Book.Category;
import ServerProgramming.Book.CategoryRepository;
import ServerProgramming.Book.UserRepository;


@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository){
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science"));
			
			repository.save(new Book("John", "Johnson", 1924, "111-222", 22.99, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Katy", "Kateson", 1995, "333-44", 23.99, crepository.findByName("Fantasy").get(0)));

			
			User user1 = new User("user", "$$2a$04$j.tfXAjn.f5Qj.yxvlfHy.TA6T.IJwtL8FU0982bNoUU7LF1JvzsW", "USER");
			User user2 = new User("admin", "$2a$04$c7rAW3xf2c2Qqn3YA8I9DuNmQmnI4bXMwho9f./bH3KKCvYKgSJUK", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	}

	