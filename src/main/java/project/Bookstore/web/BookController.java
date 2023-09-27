package project.Bookstore.web;

import project.Bookstore.domain.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.Bookstore.domain.BookRepository;
import project.Bookstore.domain.CategoryRepository;
@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		@Autowired
		private CategoryRepository categoryRepository;
		 
		@RequestMapping("/booklist")
		public String bookList(Model model) {
			model.addAttribute("Books", repository.findAll());
			return "booklist";
		}
		
		@RequestMapping(value="/books", method = RequestMethod.GET)
		public @ResponseBody List<Book> bookListRest() {
			return (List<Book>) repository.findAll();
		}
		
		@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
			return repository.findById(bookId);
		}
		
		@RequestMapping(value = "/add")
		public String addBook (Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", categoryRepository.findAll());
			return "addBook";
		}

		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveBook (Book book) {
			repository.save(book);
			return "redirect:booklist";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook (@PathVariable("id") Long bookId, Model model) {
			repository.deleteById(bookId);
			return "redirect:../booklist";
		}
		
		  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		    public String editBook(@PathVariable("id") Long bookId, Model model) {
		    	model.addAttribute("book", repository.findById(bookId));
		    	model.addAttribute("categories", categoryRepository.findAll());
		    	return "editBook";
		    }   
		  
		  @RequestMapping(value = "/update", method = RequestMethod.POST)
		  public String updateBook(@ModelAttribute("book") Book updatedBook) {

		      Book existingBook = repository.findById(updatedBook.getId()).orElse(null);

		      if (existingBook != null) {

		          existingBook.setTitle(updatedBook.getTitle());
		          existingBook.setAuthor(updatedBook.getAuthor());
		          existingBook.setCategory(updatedBook.getCategory());
		          existingBook.setIsbn(updatedBook.getIsbn());
		          existingBook.setReleaseYear(updatedBook.getReleaseYear());
		          existingBook.setPrice(updatedBook.getPrice());


		          repository.save(existingBook);
		      }


		      return "redirect:/booklist";
		  }

	}

