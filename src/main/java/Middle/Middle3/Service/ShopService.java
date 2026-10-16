package Middle.Middle3.Service;

import Middle.Middle3.Model.Product;

import java.util.List;

public interface ShopService {

    public List<Product> getProductsByPath(String catalogName, String chapterName, String pageName);

}
