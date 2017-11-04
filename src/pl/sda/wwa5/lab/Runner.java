package pl.sda.wwa5.lab;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Details described in @see pl/sda/wwa5/lab/applicationModel
 */

public class Runner {

    public static void main(String[] args) {

        if(args.length ==0) {
            System.out.println("Podaj poprawne parametry");
            System.exit(1);
        }

        WarehouseDao warehouseDao = new WarehouseDao(new ProductConverter(),"warehouse.csv");
        Warehouse warehouse = new Warehouse(warehouseDao);
        Shop shop = new Shop(warehouse);

        if(args[0].equals("pokazprodukty")) {
            try {
                List<Product> products = shop.showProducts();
            } catch (FileNotFoundException e) {
                System.out.println("Nie znaleziono pliku warehouse.csv");
            }
        }

    }
}
