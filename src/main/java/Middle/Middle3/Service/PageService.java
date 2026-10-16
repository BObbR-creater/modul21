package Middle.Middle3.Service;

import Middle.Middle3.Model.Page;

import java.util.List;

public interface PageService {

    public void create(Page page, String chapterName);

    public List<Page> findByNameAndChapter(String name, String chapterName);

}
