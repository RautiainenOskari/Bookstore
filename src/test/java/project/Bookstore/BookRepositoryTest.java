package project.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.transaction.Transactional;
import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;
import project.Bookstore.domain.Category;


	@ExtendWith(SpringExtension.class)
	@SpringBootTest(classes = BookstoreApplication.class)
	@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
	public class BookRepositoryTest {
		
		@Autowired
		private BookRepository repository;
		
		@Test
		public void findByTitleShouldReturnAuthor() {
			List<Book> books = repository.findByTitle("Kalakirja");
			
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getAuthor()).isEqualTo("Joku Jokunen");
		}
		@Transactional
		@Test
		public void createNewBook() {
			Book book = new Book("Keksikirja", "Tommi Jokunen", new Category("Ruoka"),1234, 2004, 7.95);
			repository.save(book);
			assertThat(book.getId()).isNotNull();
		}
		@Transactional
		@Test
		public void deleteBook() {
			List<Book> books =repository.findByTitle("Juustot");
			Book book = books.get(0);
			repository.delete(book);
			List<Book> newBooks = repository.findByTitle("Juustot");
			assertThat(newBooks).hasSize(0);
		}
	
}
