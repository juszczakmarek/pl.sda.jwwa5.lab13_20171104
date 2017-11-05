package pl.sda.wwa5.lab.converter;

import pl.sda.wwa5.lab.Order;
import pl.sda.wwa5.lab.Product;

import java.util.Map;

public class OrderConverter {


    public Order parseLineToOrder(String line) {
        //id,orderPlaceDate,orderFullfillDate,totalAmount,cart

        return null;
    }

    public String parseOrderToLine(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(order.getId());
        stringBuilder.append(",");
        stringBuilder.append(order.getOrderPlacedDate());
        stringBuilder.append(",");
        stringBuilder.append(order.getOrderFullfillDate());
        stringBuilder.append(",");
        stringBuilder.append(order.getTotalAmount());


        for (Map.Entry<Product,Integer> currentEntry : order.getCart().entrySet()) {
            stringBuilder.append(",");
            stringBuilder.append(currentEntry.getKey().getId());
            stringBuilder.append(",");
            stringBuilder.append(currentEntry.getValue());
        }


        return stringBuilder.toString();
    }
}
