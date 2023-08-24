package mylibrary.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import mylibrary.dtos.BookDTO;
import mylibrary.entities.Books;

public interface BookService {
	public Books addBooks(BookDTO bookDTO) throws Exception;

	public Books updateRecord(int id, Books books) throws Exception;

	public List<Books> getAllBooks() throws Exception;

	public List<Books> searchBook(String keyword) throws Exception;

	public Books addbook(MultipartFile file, String title, String revisionNumber, String publishDate, String publisher,
			String author, String genre, String isbn)  throws IOException;
}
