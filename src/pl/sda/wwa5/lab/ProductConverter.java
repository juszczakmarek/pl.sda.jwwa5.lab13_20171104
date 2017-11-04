package pl.sda.wwa5.lab;

import java.math.BigDecimal;

public class ProductConverter {

    public Product parseLineToProduct(String line) {
        String[] singleProductTable = line.split(",");
        return new Product(Integer.valueOf(singleProductTable[0]).intValue(),
                singleProductTable[1],
                new BigDecimal(singleProductTable[2]));
    }

    public String parseProductToLine(Product product) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(product.getId());
        stringBuilder.append(",");
        stringBuilder.append(product.getName());
        stringBuilder.append(",");
        stringBuilder.append(product.getPrice());
        return stringBuilder.toString();
    }
}
