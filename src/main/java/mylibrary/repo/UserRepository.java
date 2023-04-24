package mylibrary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mylibrary.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findById(int userid);

}
