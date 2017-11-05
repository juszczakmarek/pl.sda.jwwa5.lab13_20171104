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

    public Order(int id, long orderPlacedDate, long orderFullfillDate, BigDecimal totalAmount, Map<Product, Integer> cart) {
        this.id = id;
        this.orderPlacedDate = orderPlacedDate;
        this.orderFullfillDate = orderFullfillDate;
        this.totalAmount = totalAmount;
        this.cart = cart;
    }

    void addProduct(Product product, int quantity) {
        if (cart.containsKey(product)) {
            quantity += cart.get(product);
        }
        cart.put(product,quantity);
    }

    public int getId() {
        return id;
    }

    public long getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public long getOrderFullfillDate() {
        return orderFullfillDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
}
