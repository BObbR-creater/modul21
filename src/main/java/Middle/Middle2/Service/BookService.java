package Middle.Middle2.Service;

import Middle.Middle2.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> getAllBooks();

    public Optional<Book> getBookById(Long id);

    public List<Book> getBooksByGenre(String genre);

    public List<Book> getBooksByAuthor(String author);

    public List<Book> getBooksByYear(int year);

    public List<Book> getBooksByName(String name);

    public Book saveBook(Book book);

    public void deleteBook(Long id);


}
