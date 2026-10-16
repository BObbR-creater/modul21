package Middle.Middle3.Repository;

import Middle.Middle3.Model.Page;
import Middle.Middle3.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByNameAndPage(String name, Page page);

    public List<Product> findByPage(Page page);
}
