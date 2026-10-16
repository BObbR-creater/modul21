package Middle.Middle3.Controller;

import Middle.Middle3.Model.Catalog;
import Middle.Middle3.Model.Chapter;
import Middle.Middle3.Model.Page;
import Middle.Middle3.Model.Product;
import Middle.Middle3.Repository.CatalogRepository;
import Middle.Middle3.Repository.ChapterRepository;
import Middle.Middle3.Repository.PageRepository;
import Middle.Middle3.Repository.ProductRepository;
import Middle.Middle3.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopServiceImpl shopService;

    @Autowired
    CatalogService catalogService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    PageService pageService;
    @Autowired
    ProductService productService;

    @PostMapping("/catalog")
    public String createCatalog(@RequestBody Catalog catalog) {
        catalogService.create(catalog);
        return "OK";
    }

    @PostMapping("/chapters")
    public String createChapter(@RequestBody Chapter chapter,
                                @RequestParam String catalog) {
        chapterService.create(chapter, catalog);
        return "OK";
    }

    @PostMapping("/pages")
    public String createPage(@RequestBody Page page,
                             @RequestParam String chapter) {
        pageService.create(page, chapter);
        return "OK";
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product,
                                @RequestParam String page) {
        productService.create(product, page);
        return "OK";
    }

    @GetMapping("/{catalog}/{chapter}/{page}")
    public List<Product> getProducts (@PathVariable String catalog,
                                      @PathVariable String chapter,
                                      @PathVariable String page){
        return shopService.getProductsByPath(catalog, chapter, page);
    }

}
