package pl.sda.wwa5.lab;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Shop {

    private Warehouse warehouse;

    public Shop(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Product> showProducts() {

        return warehouse.showProductsForStore();
    }

    public int buy(Optional<Product> productOptional, int quantity) {
        //zamowienie
        //sprawdzicy czy jest zamowienie
        //stworzenie nowego zamowienia
        return 0;
    }
}
