package Middle.Middle2.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private int yearOfRelease;

    @Column
    private String genre;

    /*public static List<Book> books = List.of(
            new Book("Если все кошки в мире исчезнут", "Гэнки Кавамура", 2012, "Драма, Фэнтези"),
            new Book("В начале было Слово — в конце будет Цифра", "Маргарита Симоньян", 2025, "Антиутопия"),
            new Book("Хороших девочек не убивают", "Холли Джексон", 2019, "Детективный триллер"),
            new Book("Скорбь Сатаны", "Мария Корелли", 1895, "Мистический роман"),
            new Book("Преступление и наказание", "Фёдор Достоевский", 1866, "Классическая проза")
    );*/

    public Book() {
    }

    public Book(String name, String author, int yearOfRelease, String genre) {
        this.name = name;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                '}';
    }
}
