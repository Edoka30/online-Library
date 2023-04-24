package mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mylibrary.dtos.BookDTO;
import mylibrary.dtos.UserDTO;
import mylibrary.entities.Books;
import mylibrary.entities.User;
import mylibrary.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService   userService;
	
	@PostMapping("/addUser")
	public ResponseEntity createUser(@RequestBody UserDTO userDTO) throws Exception{
		
		return userService.createUser(userDTO);
		
	}
	@PostMapping("/uploadphoto")
	public User uploadImage (@RequestParam @RequestBody int userid, MultipartFile file) throws Exception{
	
	return  userService.uploadPhoto(userid, file);
}
	
	@GetMapping("/view-single-user")
	public User viewUSerbyId (@RequestParam int userid) throws Exception{
	
	return  userService.getUserById(userid);
}
	
}