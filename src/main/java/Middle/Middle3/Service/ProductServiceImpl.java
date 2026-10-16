package Middle.Middle3.Service;

import Middle.Middle3.Model.Page;
import Middle.Middle3.Model.Product;
import Middle.Middle3.Repository.CatalogRepository;
import Middle.Middle3.Repository.ChapterRepository;
import Middle.Middle3.Repository.PageRepository;
import Middle.Middle3.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    PageRepository pageRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void create(Product product, String pageName) {
        List<Page> pageList = pageRepository.findByName(pageName);

        if (pageList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        product.setPage(pageList.get(0));

        productRepository.save(product);
    }

    @Override
    public List<Product> findByPage(Page page) {

        List<Product> productList = productRepository.findByPage(page);

        return productList;
    }
}
