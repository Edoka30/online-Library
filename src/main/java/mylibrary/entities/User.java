package mylibrary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="users")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String surname;
	private String firstName;
	private String email;
	private String phone;
	private String password;
	private String status;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	public User() {
	
	}
	public User(int id, String surname, String firstName, String email, String phone, String password, String status,
			String image) {
	
		this.id = id;
		this.surname = surname;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	


}
