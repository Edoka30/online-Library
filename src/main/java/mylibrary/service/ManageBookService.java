package mylibrary.service;

import mylibrary.entities.ManageBooks;

public interface ManageBookService {

	public ManageBooks BookChekOut(int userid, int bookid) throws Exception;
	
	
	
}
