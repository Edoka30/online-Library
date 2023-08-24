package mylibrary.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mylibrary.entities.ManageBooks;

public interface ManageBookRepository extends JpaRepository<ManageBooks, Integer> {

	List<ManageBooks> findByDueDate(LocalDate today);

}
