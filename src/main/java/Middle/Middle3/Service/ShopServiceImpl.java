package Middle.Middle3.Service;

import Middle.Middle3.Model.Catalog;
import Middle.Middle3.Model.Chapter;
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
public class ShopServiceImpl implements ShopService {

    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductsByPath(String catalogName, String chapterName, String pageName) {

        List<Catalog> catalogList = catalogRepository.findByName(catalogName);

        if (catalogList.isEmpty()) {
            throw new IllegalArgumentException("Каталог не найден: " + catalogName);
        }

        List<Chapter> chapterList = chapterRepository.findByNameAndCatalog(chapterName, catalogList.get(0));

        if (chapterList.isEmpty()) {
            throw new IllegalArgumentException("Раздел не найден: " + chapterName);
        }

        List<Page> pageList = pageRepository.findByNameAndChapter(pageName, chapterList.get(0));

        if (pageList.isEmpty()) {
            throw new IllegalArgumentException("Страница не найдена: " + pageName);
        }

        return productRepository.findByPage(pageList.get(0));
    }
}
