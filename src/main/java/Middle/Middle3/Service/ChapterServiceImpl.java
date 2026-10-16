package Middle.Middle3.Service;

import Middle.Middle3.Model.Catalog;
import Middle.Middle3.Model.Chapter;
import Middle.Middle3.Repository.CatalogRepository;
import Middle.Middle3.Repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public void create(Chapter chapter, String catalogName) {
        List<Catalog> catalogs = catalogRepository.findByName(catalogName);

        if (catalogs.isEmpty()) {
            throw new IllegalArgumentException("Каталог пустой: " + catalogName);
        }

        chapter.setCatalog(catalogs.get(0));
        chapterRepository.save(chapter);
    }

    @Override
    public List<Chapter> findByNameAndCatalog(String name, String catalogName) {
        List<Catalog> catalogList = catalogRepository.findByName(catalogName);

        if (catalogList.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return chapterRepository.findByNameAndCatalog(name, catalogList.get(0));
    }
}
