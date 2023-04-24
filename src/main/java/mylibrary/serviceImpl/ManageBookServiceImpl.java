package mylibrary.serviceImpl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mylibrary.entities.Books;
import mylibrary.entities.ManageBooks;
import mylibrary.entities.User;
import mylibrary.exception.BadRequestException;
import mylibrary.repo.BookRepository;
import mylibrary.repo.ManageBookRepository;
import mylibrary.repo.UserRepository;
import mylibrary.service.ManageBookService;
import mylibrary.utils.TimeAndDate;

@Service
public class ManageBookServiceImpl implements ManageBookService {

	@Autowired
	ManageBookRepository repo;
	@Autowired
	BookRepository bookRepistory;
	@Autowired
	UserRepository userRepository;
	

	@Override
	public ManageBooks BookChekOut(int userid, int bookid) throws Exception {
		ManageBooks checkout = new ManageBooks();
		Books confirmBook = bookRepistory.findById(bookid);
		User user = userRepository.findById(userid);
		if (confirmBook == null ) {
	throw new BadRequestException("400","Book not found");
		}else
		
		
		if(confirmBook.getAvailabilityStatus().equalsIgnoreCase("NO")) {
			throw new BadRequestException("400","Book has been taken and will be due for return on " + checkout.getDueDate());
		}
		checkout.setBookDetails(confirmBook);
		checkout.setUserDetails(user);
		checkout.setReaderEmail(user.getEmail());
		LocalDate today = LocalDate.now();
		LocalDate dueDate = today.plusDays(10);
		checkout.setDueDate(dueDate);
		confirmBook.setAvailabilityStatus("NO");

		return repo.save(checkout);
	}

}
