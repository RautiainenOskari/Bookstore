package project.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.Bookstore.domain.AppUser;
import project.Bookstore.domain.AppUserRepository;
import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;
import project.Bookstore.domain.Category;
import project.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Tietokirja"));
			crepository.save(new Category("Fantasia"));
			
			brepository.save(new Book("Hyvä Kirja", "Elli Esimerkki", crepository.findByName("Fantasia").get(0), 0001, 2002, 7.99));
			brepository.save(new Book("Kalakirja", "Joku Jokunen",crepository.findByName("Tietokirja").get(0), 0002, 2014, 9.99));
			brepository.save(new Book("Juustot", "Paavo Mäkinen", crepository.findByName("Tietokirja").get(0), 0003, 2022, 5.99));
			
			AppUser user1 = new AppUser("user", "$2a$10$o6twiNXVguXbnXPrzHqyOuLJE4HN8pmif19zHTovqedo0WvoHHS0.", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$8mStTRGNkNHx3CnWIUOycecwz.STUKcscmC0..FvRTi.Y9PWPKfEu", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

	};
	
	
}}
