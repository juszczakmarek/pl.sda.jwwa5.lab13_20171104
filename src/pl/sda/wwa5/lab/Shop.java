package pl.sda.wwa5.lab;

import java.io.FileNotFoundException;
import java.util.List;

public class Shop {

    private Warehouse warehouse;

    public Shop(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Product> showProducts() {

        return warehouse.showProductsForStore();
    }
}
