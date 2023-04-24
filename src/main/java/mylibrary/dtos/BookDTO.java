package mylibrary.dtos;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class BookDTO {
//private MultipartFile coverImage;
	
	private String title;
	private String isbn;
	private String revisionNumber;
	private String publishDate;
	private String publisher;
	private String author;
	private String genre;
	private LocalDate dateAdded;
	
//	public MultipartFile getCoverImage() {
//		return coverImage;
//	}
	/*
	 * public void setCoverImage(MultipartFile coverImage) { this.coverImage =
	 * coverImage; }
	 */
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
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
	
	
	

}
