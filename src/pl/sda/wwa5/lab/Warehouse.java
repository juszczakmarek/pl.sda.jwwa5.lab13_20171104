package pl.sda.wwa5.lab;

import pl.sda.wwa5.lab.dao.WarehouseDao;

import java.io.FileNotFoundException;
import java.util.List;

public class Warehouse {

    private WarehouseDao dao;

    public Warehouse(WarehouseDao dao) {
        this.dao = dao;
    }

    public List<Product> showProductsForStore() throws FileNotFoundException {

        return dao.odczytajWszystkie();
    }
}
