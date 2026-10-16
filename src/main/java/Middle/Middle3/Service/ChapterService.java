package Middle.Middle3.Service;

import Middle.Middle3.Model.Chapter;

import java.util.List;

public interface ChapterService {

    public void create(Chapter chapter, String catalogName);

    public List<Chapter> findByNameAndCatalog(String name, String catalogName);

}
