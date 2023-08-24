package mylibrary.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import mylibrary.emailsender.MailService;
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
	@Autowired
	MailService emailService;

	@Override
	public String BookChekOut(int userid, int bookid) throws Exception {
		ManageBooks checkout = new ManageBooks();
		Books confirmBook = bookRepistory.findById(bookid);
		User user = userRepository.findById(userid);
		if (user == null) {
			return "User ID not found";
		}
		if (confirmBook == null) {
			throw new BadRequestException("400", "Book not found");
		} else

		if (confirmBook.getAvailabilityStatus().equalsIgnoreCase("NO")) {
			return "The Book " + confirmBook.getTitle() + " Is currently not available, check back later";
		}
		checkout.setBookDetails(confirmBook);
		checkout.setUserDetails(user);
		checkout.setReaderEmail(user.getEmail());
		LocalDate today = LocalDate.now();
		LocalDate dueDate = today.plusDays(10);
		checkout.setDueDate(dueDate);
		checkout.setDateCollected(LocalDate.now());
		confirmBook.setAvailabilityStatus("NO");
		System.out.println("........set Nooooo");
		confirmBook.setAvailabilityStatus("NO");
		System.out.println("........set Nooooo" + confirmBook.getAvailabilityStatus());
		repo.save(checkout);

		return "The Book " + confirmBook.getTitle() + " has been added to your Cart";
	}

	// @Scheduled(cron = "* /54 1 * * *")
//	@Scheduled(cron = "0 0/59 1 * * *")
	public List <ManageBooks> dueDateMailNotificationToReader() throws Exception {
		LocalDate today = LocalDate.now();

		System.out.println("TEST CRON EXPRESSION FOR 2:15AM AND LocalDate.now()");
		System.out.println("LocalDate.now() = " + today);

		List<ManageBooks> notify = repo.findByDueDate(today);
		ArrayList<?> dueBooks = new ArrayList();
		
		
//		if (notify != null) {
//
//			System.out.println("yes list of books for return");
////			for (int i = 0; i < notify.size(); i++) {
////
////				System.out.println(notify.get(i));
////				User user = userRepository.findById(notify.getUserDetails());
////				SimpleMailMessage mailMessage = new SimpleMailMessage();
////				mailMessage.setTo(notify.get(i));
////				mailMessage.setSubject("Complete Registration!");
////				mailMessage.setFrom("thomasedoka30@gmail.com");
////				mailMessage.setText("To confirm your accou" ) ;
////
////				//emailService.sendMail(mailMessage);
////				String msg = " Book due for return";
//////				System.out.println(msg);
////			}
//			
//			
//	}
		
		return notify;
	}
}
