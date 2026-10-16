package Middle.Middle3.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalog")
    private List<Chapter> chapters;

    public Catalog(String name, List<Chapter> chapters) {
        this.name = name;
        this.chapters = chapters;
    }

    public Catalog() {
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

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
