package project.Bookstore.web;

import project.Bookstore.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Bookstore.domain.BookRepository;
@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		 
		@RequestMapping("/booklist")
		public String bookList(Model model) {
			model.addAttribute("Books", repository.findAll());
			return "booklist";
		}
		
		@RequestMapping(value = "/add")
		public String addBook (Model model) {
			model.addAttribute("book", new Book());
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

	}

