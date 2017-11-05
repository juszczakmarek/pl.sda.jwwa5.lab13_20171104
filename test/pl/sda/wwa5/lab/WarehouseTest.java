package pl.sda.wwa5.lab;

import org.junit.Before;
import org.junit.Test;
import pl.sda.wwa5.lab.converter.ProductConverter;
import pl.sda.wwa5.lab.dao.WarehouseDao;

import java.util.List;

import static org.junit.Assert.*;

public class WarehouseTest {

    private Warehouse warehouse;

    @Before
    public void setUp() throws Exception {
        WarehouseDao warehouseDao = new WarehouseDao(new ProductConverter(),"test/produktyTestowe.csv");
        warehouse = new Warehouse(warehouseDao);
    }

    @Test
    public void showProductsForStore() throws Exception {
        List<Product> result = warehouse.showProductsForStore();
        assertEquals(result.size(),2);
    }

}