package Middle.Middle2.Service;

import Middle.Middle2.Model.Book;
import Middle.Middle2.Repository.BookRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepositoryJpa bookRepositoryJpa;

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryJpa.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepositoryJpa.findById(id);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepositoryJpa.findByGenre(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepositoryJpa.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByYear(int year) {
        return bookRepositoryJpa.findByYearOfRelease(year);
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepositoryJpa.findByName(name);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepositoryJpa.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepositoryJpa.deleteById(id);
    }
}
