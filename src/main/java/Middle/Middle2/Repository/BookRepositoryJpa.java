package Middle.Middle2.Repository;

import Middle.Middle2.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositoryJpa extends JpaRepository<Book, Long> {

    public List<Book> findByGenre(String genre);

    public List<Book> findByName(String name);

    public List<Book> findByYearOfRelease(int yearOfRelease);

    public List<Book> findByAuthor(String author);

}
