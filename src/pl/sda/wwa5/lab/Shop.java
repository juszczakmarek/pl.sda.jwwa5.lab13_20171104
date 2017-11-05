package pl.sda.wwa5.lab;

import pl.sda.wwa5.lab.dao.OrdersDao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Shop {

    private Warehouse warehouse;
    private OrdersDao ordersDao;

    public Shop(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Product> showProducts() {

        return warehouse.showProductsForStore();
    }

    public int buy(Product product, int quantity, Order order) {
        //zamowienie
        //sprawdzicy czy jest zamowienie
        //stworzenie nowego zamowienia
        if (checkIfProductIsAvailabl(product)) {
            order.addProduct(product, quantity);
            ordersDao.writeOrderToFile(order);
        }
        return order.getId();
    }

    private boolean checkIfProductIsAvailabl(Product product) {
        return true;
    }
}
