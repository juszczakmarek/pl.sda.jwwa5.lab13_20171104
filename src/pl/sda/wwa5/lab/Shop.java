package pl.sda.wwa5.lab;

import java.io.FileNotFoundException;
import java.util.List;

public class Shop {

    private Warehouse warehouse;

    public List<Product> showProducts() throws FileNotFoundException {

        return warehouse.showProductsForStore();
    }
}
