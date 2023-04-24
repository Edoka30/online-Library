package mylibrary.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name ="books")
public class Books {

	@Id
	@GeneratedValue
	private int id;
	
	
	private String title;
	private String isbn;
	private String revisionNumber;
	private LocalDate publishDate;
	private String publisher;
	private String author;
	private String genre;
	private LocalDate dateAdded;
	private String availabilityStatus;
	private String Status;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String coverImage;
	public Books() {
	
	}
	public Books(int id, String coverImage, String title, String isbn, String revisionNumber, LocalDate publishDate,
			String publisher, String author, String genre, LocalDate dateAdded, String availabilityStatus,
			String status) {
		this.id = id;
		this.coverImage = coverImage;
		this.title = title;
		this.isbn = isbn;
		this.revisionNumber = revisionNumber;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.author = author;
		this.genre = genre;
		this.dateAdded = dateAdded;
		this.availabilityStatus = availabilityStatus;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	//@JsonbDateFormat("dd/MM/yyyy");
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
	
	
	
	
}
