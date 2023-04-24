package mylibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mylibrary.dtos.BookDTO;
import mylibrary.entities.Books;
import mylibrary.entities.ManageBooks;
import mylibrary.service.BookService;
import mylibrary.service.ManageBookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	ManageBookService mbService;

	@PostMapping("/addbook")
	public Books addBook(@RequestBody BookDTO bookDTO) throws Exception {

		return bookService.addBooks(bookDTO);

	}

	@PutMapping("/updateBook")
	public Books updateRecord(@RequestParam @RequestBody int id, Books updateBook) throws Exception {

		return bookService.updateRecord(id, updateBook);
	}

	@GetMapping("/viewAllbooks")
	public List<Books> getAllBooks() throws Exception {
		return bookService.getAllBooks();
		
	}
	
	@GetMapping("/search_books")
	public List<Books> searchBook(String keyword) throws Exception {
		keyword ="java";
		return bookService.searchBook(keyword);
		
	}
	
	@PostMapping("/book_checkout")
	public ManageBooks bookCheckout(@RequestParam int userid, int bookid) throws Exception {
		
	return	mbService.BookChekOut(userid, bookid);
		
	}

}
