package pl.sda.wwa5.lab.converter;

import com.sun.org.apache.xpath.internal.operations.Or;
import pl.sda.wwa5.lab.Order;
import pl.sda.wwa5.lab.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class OrderConverter {


    public Order parseLineToOrder(String line) {
        String[] orderLine = line.split(",");
        Map<Product, Integer> cart = new LinkedHashMap<>();

        Order order = new Order(Integer.valueOf(orderLine[0]),
                Long.valueOf(orderLine[1]),
                Long.valueOf(orderLine[2]),
                new BigDecimal(orderLine[3]),
                cart);

        for (int i =4; i<orderLine.length; i +=2) {
            Product product = new Product(Integer.valueOf(orderLine[i]),null,null);
            cart.put(product,Integer.valueOf(orderLine[i+1]));
        }
        return order;
    }

    public String parseOrderToLine(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(order.getId());
        stringBuilder.append(",");
        stringBuilder.append(order.getOrderPlacedDate());
        stringBuilder.append(",");
        stringBuilder.append(order.getOrderFullfillDate());
        stringBuilder.append(",");
        stringBuilder.append(order.getTotalAmount()==null ? "" : order.getTotalAmount() );

        //Metoda 1
        for (Map.Entry<Product,Integer> currentEntry : order.getCart().entrySet()) {
            stringBuilder.append(",");
            stringBuilder.append(currentEntry.getKey().getId());
            stringBuilder.append(",");
            stringBuilder.append(currentEntry.getValue());
        }

        //Metoda 2
        //TODO zrobić to w domu
//        Set<Product> orderKeySet = order.getCart().keySet();
//        for (Product currentProduct : orderKeySet) {
//            stringBuilder.append(",");
//            stringBuilder.append(order.getCart().get(currentProduct.getId()));
//            stringBuilder.append(",");
//        }


        return stringBuilder.toString();
    }
}
