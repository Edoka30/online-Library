package mylibrary.serviceImpl;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import mylibrary.dtos.UserDTO;
import mylibrary.entities.User;
import mylibrary.repo.UserRepository;
import mylibrary.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity createUser(UserDTO userDTO) throws Exception {
		User user = new User();
		user.setSurname(userDTO.getSurname());
		user.setFirstName(userDTO.getFirstName());
		user.setEmail(userDTO.getEmail());
		user.setImage("NO image");
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User has been created! ");
	}

	public User uploadPhoto(int userId, MultipartFile file) throws Exception {

		User checkUser = userRepository.findById(userId);
		if (checkUser == null) {
			System.out.println("Userdoes not Exist");
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			checkUser.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return checkUser;
	}

	@Override
	public User getUserById(int id) throws Exception {
		User checkUser = userRepository.findById(id);
		if (checkUser == null) {
			System.out.println("Userdoes not Exist");
		}
		return checkUser;
	}
}
