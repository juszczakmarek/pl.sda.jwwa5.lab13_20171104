package pl.sda.wwa5.lab;

import pl.sda.wwa5.lab.dao.WarehouseDao;

import java.util.List;
import java.util.Optional;

public class Warehouse {

    private WarehouseDao dao;

    public Warehouse(WarehouseDao dao) {
        this.dao = dao;
    }

    public List<Product> showProductsForStore() {

        return dao.getAllProducts();
    }

    public Optional<Product> getProductById(int productID) {
        return dao.findProductById(productID);
    }
}
