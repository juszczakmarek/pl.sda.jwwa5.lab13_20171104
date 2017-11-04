package pl.sda.wwa5.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductConverterTest {

    private ProductConverter converter;

    @Before
    public void setUp() {
        converter = new ProductConverter();
    }

    @Test
    public void parseLineToProduct() throws Exception {
        Product product = converter.parseLineToProduct("1,testowy,25.00");
        Assert.assertEquals(product.getName(),"testowy");
        Assert.assertTrue(product.getId()==1);
        Assert.assertEquals(product.getPrice(),new BigDecimal("25.00"));
    }

    @Test
    public void parseProductToLine() throws Exception {
        Product product = new Product(2,"testowy2",new BigDecimal("11.11"));
        String line = converter.parseProductToLine(product);
        assertEquals(line,"2,testowy2,11.11");
    }

}