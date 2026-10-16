package Middle.Middle3.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "page")
    private List<Product> products;

    public Page(String name, Chapter chapter, List<Product> products) {
        this.name = name;
        this.chapter = chapter;
        this.products = products;
    }

    public Page() {

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

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
