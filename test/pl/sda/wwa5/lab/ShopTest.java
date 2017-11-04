package pl.sda.wwa5.lab;

import org.junit.Before;
import org.junit.Test;
import pl.sda.wwa5.lab.converter.ProductConverter;
import pl.sda.wwa5.lab.dao.WarehouseDao;

import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() throws Exception {
        WarehouseDao warehouseDao = new WarehouseDao(new ProductConverter(),"test/produktyTestowe.csv");
        Warehouse warehouse = new Warehouse(warehouseDao);
        shop = new Shop(warehouse);
    }

    @Test
    public void showProducts() throws Exception {
        List<Product> result = shop.showProducts();
        assertEquals(result.size(),2);
    }

}