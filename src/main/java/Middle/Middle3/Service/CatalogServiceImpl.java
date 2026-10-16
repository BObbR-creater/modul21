package Middle.Middle3.Service;

import Middle.Middle3.Model.Catalog;
import Middle.Middle3.Repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public void create(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findByName(String catalogName) {

        List<Catalog> catalogList = catalogRepository.findByName(catalogName);

        if (catalogList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return catalogRepository.findByName(catalogName);
    }
}
