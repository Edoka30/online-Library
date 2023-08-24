package mylibrary.service;

import java.util.List;

import mylibrary.entities.ManageBooks;

public interface ManageBookService {

	public String BookChekOut(int userid, int bookid) throws Exception;
	
	public List <ManageBooks> dueDateMailNotificationToReader() throws Exception;
	
}
