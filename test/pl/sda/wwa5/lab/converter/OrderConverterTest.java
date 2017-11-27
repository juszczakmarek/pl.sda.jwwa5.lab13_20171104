package pl.sda.wwa5.lab.converter;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Before;
import org.junit.Test;
import pl.sda.wwa5.lab.Order;
import pl.sda.wwa5.lab.Product;

import java.math.BigDecimal;
import java.util.*;

import static javafx.scene.input.KeyCode.H;
import static org.junit.Assert.*;

public class OrderConverterTest {

    private OrderConverter orderConverter;

    @Before
    public void setUp() throws Exception {
        this.orderConverter = new OrderConverter();
    }

    @Test
    public void parseLineToOrder() throws Exception {
        String orderLine = "4,5,6,7.77,10,1,20,2";

        Order order = orderConverter.parseLineToOrder(orderLine);


        assertTrue(order.getId()==4);
        assertTrue(order.getOrderPlacedDate()==5);
        assertTrue(order.getOrderFullfillDate()==6);
        assertEquals(order.getTotalAmount(),new BigDecimal("7.77"));
        assertTrue(order.getCart().size()==2);

        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product(10,null,null));
        productSet.add(new Product(20,null,null));
        assertTrue(order.getCart().keySet().containsAll(productSet));
    }

    @Test
    public void parseOrderToLineWithEmptyCart() throws Exception {
        int orderId = 1;
        long orderPlacedDate = 2;
        long orderFullfillDate = 3;
        BigDecimal totalAmount = new BigDecimal("9.99");
        Map cart = new LinkedHashMap<>();

        Order order = new Order(orderId,orderPlacedDate,orderFullfillDate,totalAmount,cart);

        String line = orderConverter.parseOrderToLine(order);

        assertEquals("1,2,3,9.99",line);
    }

    @Test
    public void parseOrderToLine() throws Exception {
        int orderId = 1;
        long orderPlacedDate = 2;
        long orderFullfillDate = 3;
        BigDecimal totalAmount = new BigDecimal("9.99");
        Product productA = new Product(10,"ProduktA",new BigDecimal("11.00"));
        Product productB = new Product(20,"ProduktB",new BigDecimal("21.00"));
        Map cart = new LinkedHashMap<>();
        cart.put(productA,1);
        cart.put(productB,2);

        Order order = new Order(orderId,orderPlacedDate,orderFullfillDate,totalAmount,cart);

        String line = orderConverter.parseOrderToLine(order);

        assertEquals("1,2,3,9.99,10,1,20,2",line);
    }

}