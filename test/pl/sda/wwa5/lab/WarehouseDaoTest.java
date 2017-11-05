package pl.sda.wwa5.lab;

import org.junit.Before;
import org.junit.Test;
import pl.sda.wwa5.lab.converter.ProductConverter;
import pl.sda.wwa5.lab.dao.WarehouseDao;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class WarehouseDaoTest {

    private WarehouseDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new WarehouseDao(new ProductConverter(),"test/produktyTestowe.csv");
    }

    @Test
    public void odczytajWszystkie() throws Exception {
        List<Product> result = dao.getAllProducts();
        assertEquals(result.size(),2);
        assertEquals(result.get(1).getId(),2);
        assertEquals(result.get(1).getName(),"produktB");
        assertEquals(result.get(1).getPrice(),new BigDecimal("20"));
    }

}