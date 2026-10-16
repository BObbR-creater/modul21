package Middle.Middle3.Service;

import Middle.Middle3.Model.Chapter;
import Middle.Middle3.Model.Page;
import Middle.Middle3.Repository.CatalogRepository;
import Middle.Middle3.Repository.ChapterRepository;
import Middle.Middle3.Repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {


    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    PageRepository pageRepository;


    @Override
    public void create(Page page, String chapterName) {

        List<Chapter> chapterList = chapterRepository.findByName(chapterName);

        if (chapterList.isEmpty()) {
            throw new IllegalArgumentException("Раздел пустой: " + chapterName);
        }

        page.setChapter(chapterList.get(0));

        pageRepository.save(page);
    }

    @Override
    public List<Page> findByNameAndChapter(String name, String chapterName) {
        List<Chapter> chapters = chapterRepository.findByName(chapterName);

        if (chapters.isEmpty()) {
            throw new IllegalArgumentException("Раздел не найден: " + chapterName);
        }

        return pageRepository.findByNameAndChapter(name, chapters.get(0));
    }
}
