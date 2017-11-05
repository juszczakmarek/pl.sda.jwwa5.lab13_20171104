package pl.sda.wwa5.lab;

import pl.sda.wwa5.lab.converter.ProductConverter;
import pl.sda.wwa5.lab.dao.OrdersDao;
import pl.sda.wwa5.lab.dao.WarehouseDao;
import pl.sda.wwa5.lab.view.ProductsConsoleView;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Details described in @see pl/sda/wwa5/lab/applicationModel
 */

public class Runner {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Podaj poprawne parametry");
            System.exit(1);
        }

        WarehouseDao warehouseDao = null;
        OrdersDao ordersDao = null;

        try {
            warehouseDao = new WarehouseDao(new ProductConverter(), "./data/warehouse.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku magazynu");
            System.exit(1);
        }
        Warehouse warehouse = new Warehouse(warehouseDao);
        Shop shop = new Shop(warehouse, ordersDao);

        if (args[0].equals("pokazprodukty")) {
            List<Product> products = shop.showProducts();
            ProductsConsoleView productsConsoleView = new ProductsConsoleView(products);
            productsConsoleView.showProducts();
        }

        if (args[0].equals("kup")) {
            System.out.println("kupujemy");
            //TODO obiekt walidator
            int productID = Integer.valueOf(args[1]);
            int quantity = Integer.valueOf(args[2]);
            int orderId = -1;
            Order order = null;

            if (args.length==4) {
                orderId = Integer.valueOf(args[3]);
                Optional<Order> optionalOrderId = ordersDao.findByOrderId(orderId);
                if (optionalOrderId.isPresent()) {
                    order = optionalOrderId.get();
                } else {
                    System.out.println("Brak zamówienia o tym id");
                    System.exit(1);
                }
            }

            Optional<Product> productOptional = warehouse.getProductById(productID);
            if (productOptional.isPresent()) {
                System.out.println("Nie znaleziono produktu");
                System.exit(1);
            }
            shop.buy(productOptional.get(), quantity, order);
        }

        //TODO action = ActionFactory.createAction(args); action.perform();

    }
}
