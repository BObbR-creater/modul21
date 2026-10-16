package Middle.Middle2.Controller;

import Middle.Middle2.Model.Book;
import Middle.Middle2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/name/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/year/{year}")
    public List<Book> getBooksByYearOfRelease(@PathVariable int year) {
        return bookService.getBooksByYear(year);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
