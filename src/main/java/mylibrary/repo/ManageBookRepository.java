package mylibrary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mylibrary.entities.ManageBooks;

public interface ManageBookRepository extends JpaRepository<ManageBooks, Integer> {

}
