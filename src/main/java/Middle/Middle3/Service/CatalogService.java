package Middle.Middle3.Service;

import Middle.Middle3.Model.Catalog;

import java.util.List;

public interface CatalogService {

    public void create(Catalog catalog);

    public List<Catalog> findByName (String catalogName);

}
