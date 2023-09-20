package project.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import project.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
