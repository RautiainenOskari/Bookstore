package project.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import project.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitle(String string);

}
