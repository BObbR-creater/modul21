package Middle.Middle3.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chapter")
    private List<Page> pages;

    public Chapter(String name, Catalog catalog, List<Page> pages) {
        this.name = name;
        this.catalog = catalog;
        this.pages = pages;
    }

    public Chapter() {

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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
