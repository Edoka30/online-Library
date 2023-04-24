package mylibrary.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ManageBooks {
	@Id
	@GeneratedValue
	private int id;
	private String readerEmail;
	private LocalDate dateCollected;
	private LocalDate dueDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookid")
	private Books bookDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User userDetails;

	public ManageBooks() {
		
	}

	public ManageBooks(int id,  String readerEmail, LocalDate dateCollected, LocalDate dueDate,
			Books bookDetails, User userDetails) {
	
		this.id = id;
		
		this.readerEmail = readerEmail;
		this.dateCollected = dateCollected;
		this.dueDate = dueDate;
		this.bookDetails = bookDetails;
		this.userDetails = userDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getReaderEmail() {
		return readerEmail;
	}

	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	public LocalDate getDateCollected() {
		return dateCollected;
	}

	public void setDateCollected(LocalDate dateCollected) {
		this.dateCollected = dateCollected;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Books getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(Books bookDetails) {
		this.bookDetails = bookDetails;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	
	

}
