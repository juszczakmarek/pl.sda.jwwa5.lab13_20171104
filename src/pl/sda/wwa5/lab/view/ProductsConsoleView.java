package pl.sda.wwa5.lab.view;

import pl.sda.wwa5.lab.Product;

import java.util.List;

public class ProductsConsoleView {

    private List<Product> products;

    public ProductsConsoleView(List<Product> products) {
        this.products = products;
    }

    public void showProducts() {
//        products.stream().forEach(product -> System.out.println(changeFormat(product)));
//        products.stream().map(product -> changeFormat(product)).forEach(System.out::println);
        System.out.println(String.format("%-5s | %-50s | %-9s","Id","Nazwa","Cena"));
        System.out.println(String.format("%-6s+%-51s+%-10s","------","----------------------------------------------------","----------"));
        products.stream().map(this::changeFormat).forEach(System.out::println);
    }

    public String changeFormat(Product product) {

        return String.format("%-5s | %-50s | %-9s",product.getId(),product.getName(),product.getPrice());
    }

}
