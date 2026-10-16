package Middle.Middle3.Repository;

import Middle.Middle3.Model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    public List<Catalog> findByName(String name);

}
