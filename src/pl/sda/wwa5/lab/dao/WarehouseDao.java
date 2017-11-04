package pl.sda.wwa5.lab.dao;

import pl.sda.wwa5.lab.Product;
import pl.sda.wwa5.lab.converter.ProductConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDao {

    private String fileName;
    private ProductConverter productConverter;

    public WarehouseDao(ProductConverter productConverter, String fileName) {
        this.productConverter = productConverter;
        this.fileName = fileName;
    }

    public List<Product> odczytajWszystkie() throws FileNotFoundException {

        BufferedReader fileStream = new BufferedReader((new FileReader(fileName)));
        List<Product> resultProductList = new ArrayList<>();

        try {
            String line = fileStream.readLine();

            while (line != null) {
                Product product = productConverter.parseLineToProduct(line);
                resultProductList.add(product);
                line = fileStream.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultProductList;
    }


}
