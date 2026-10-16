package Middle.Middle3.Service;

import Middle.Middle3.Model.Page;
import Middle.Middle3.Model.Product;

import java.util.List;

public interface ProductService {

    public void create(Product product, String pageName);

    public List<Product> findByPage(Page page);

}
