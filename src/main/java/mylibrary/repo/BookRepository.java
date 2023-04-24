package mylibrary.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mylibrary.entities.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

	public Books findById(int id);

	@Query("SELECT b FROM Books b WHERE b.title LIKE %?1% " + "OR b.isbn LIKE %?1%")
	public List<Books> searchAllBooks(String Keyword);

}
