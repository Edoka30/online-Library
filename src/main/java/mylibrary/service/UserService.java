package mylibrary.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import mylibrary.dtos.UserDTO;
import mylibrary.entities.User;

public interface UserService {
	public ResponseEntity createUser(UserDTO userDTO) throws Exception;

	public User uploadPhoto (int userId, MultipartFile  file ) throws Exception;
	public User getUserById(int id) throws Exception;

}
