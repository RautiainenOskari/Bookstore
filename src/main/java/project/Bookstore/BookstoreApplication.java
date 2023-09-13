package project.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book s1 = new Book("Hyvä Kirja", "Elli Esimerkki", 0001, 2002, 7.99);
			Book s2 = new Book("Kalakirja", "Joku Jokunen", 0002, 2014, 9.99);
			Book s3 = new Book("Juustot", "Paavo Mäkinen", 0003, 2022, 5.99);
			
			repository.save(s1);
			repository.save(s2);
			repository.save(s3);
		};
	}
	
	
}
