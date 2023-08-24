package mylibrary.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mylibrary.Response.JSONObject;
import mylibrary.dtos.BookDTO;
import mylibrary.entities.Books;
import mylibrary.entities.ManageBooks;
import mylibrary.repo.BookRepository;
import mylibrary.repo.UserRepository;
import mylibrary.service.BookService;
import mylibrary.service.ManageBookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	ManageBookService mbService;
	@Autowired
	BookRepository bookRepository;

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
		keyword = "java";
		return bookService.searchBook(keyword);

	}

	@PostMapping("/book_checkout")
	public String bookCheckout(@RequestParam int userid, int bookid) throws Exception {
		return mbService.BookChekOut(userid, bookid);

	}

	@PostMapping("/add_book")
	public Books uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("title") String title,
			@RequestParam("revisionNumber") String revisionNumber, @RequestParam("publishDate") String publishDate,
			@RequestParam("publisher") String publisher, @RequestParam("author") String author,
			@RequestParam("genre") String genre, @RequestParam("isbn") String isbn) throws IOException {

		return bookService.addbook(file, title, revisionNumber, publishDate, publisher, author, genre, isbn);
	}

	@GetMapping("/viewAlldueBooksToday")
	public List<ManageBooks> getAllBooksDueToday() throws Exception {

		return mbService.dueDateMailNotificationToReader();
	}
}
