package Middle.Middle3.Repository;

import Middle.Middle3.Model.Catalog;
import Middle.Middle3.Model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    public List<Chapter> findByNameAndCatalog(String name, Catalog catalog);

    public List<Chapter> findByName(String name);

}
