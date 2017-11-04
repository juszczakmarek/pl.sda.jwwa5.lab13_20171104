package pl.sda.wwa5.lab;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {

    private int id;
    private long orderPlacedDate;
    private long orderFullfillDate;
    private BigDecimal totalAmount;
    private Map<Product, Integer> cart = new LinkedHashMap<>();

}
