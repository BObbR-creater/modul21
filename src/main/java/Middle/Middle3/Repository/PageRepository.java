package Middle.Middle3.Repository;

import Middle.Middle3.Model.Chapter;
import Middle.Middle3.Model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    public List<Page> findByNameAndChapter(String name, Chapter chapter);

    public List<Page> findByName(String name);

}
