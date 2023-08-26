package mylibrary.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mylibrary.dtos.BookDTO;
import mylibrary.entities.Books;
import mylibrary.repo.BookRepository;
import mylibrary.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	@Override
	public Books addBooks(BookDTO bookDTO) throws Exception {
		Books book = new Books();

		book.setTitle(bookDTO.getTitle());
		book.setIsbn(bookDTO.getIsbn());
		book.setRevisionNumber(bookDTO.getRevisionNumber());
		book.setAuthor(bookDTO.getAuthor());
		// LocalDate date1=LocalDate.parse(bookDTO.getPublishDate());
		// book.setPublishDate(date1);
		book.setPublisher(bookDTO.getPublisher());
		book.setAvailabilityStatus("yes");
		book.setDateAdded(LocalDate.now());

//		String fileName = StringUtils.cleanPath(bookDTO.getCoverImage().getOriginalFilename());
//		if (fileName.contains("..")) {
//			System.out.println("not a a valid file");
//		}
//		try {
//			book.setCoverImage(Base64.getEncoder().encodeToString(bookDTO.getCoverImage().getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return bookRepository.save(book);

	}

	public Books updateRecord(int id, Books books) throws Exception {
		Books update = bookRepository.findById(id);
		if (update == null) {
			System.out.println("No book with such ID");
		}
		System.out.println("The Title of the book is :" + update.getTitle());
		bookRepository.save(books);
		return books;
	}

	public List<Books> getAllBooks() throws Exception {
		return bookRepository.findAll();

	}

	public List<Books> searchBook(String keyword) throws Exception {
		if (keyword != null) {

			return bookRepository.searchAllBooks(keyword);
		}
		return bookRepository.searchAllBooks(keyword);

	}

	public Books addbook(MultipartFile file, String title, String revisionNumber, String publishDate, String publisher,
			String author, String genre, String isbn) throws IOException {

		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path path = Paths.get("C:/uploads/" + fileName);
		Files.write(path, file.getBytes());
		

		Books addbook = new Books();
		// userData.setCoverImage(fileName);
		addbook.setCoverImage(path.toString());
		addbook.setTitle(title);
		addbook.setIsbn(isbn);
		addbook.setRevisionNumber(revisionNumber);
		addbook.setPublisher(publisher);
		addbook.setAuthor(author);
		addbook.setGenre(genre);
		addbook.setDateAdded(LocalDate.EPOCH.now());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate date = LocalDate.parse(publishDate, df);
		addbook.setPublishDate(date);
		addbook.setStatus("1");
		addbook.setAvailabilityStatus("YES");
		return bookRepository.save(addbook);

	}

}
