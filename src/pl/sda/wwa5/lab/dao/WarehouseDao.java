package pl.sda.wwa5.lab.dao;

import pl.sda.wwa5.lab.Product;
import pl.sda.wwa5.lab.converter.ProductConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WarehouseDao {

    private String fileName;
    private ProductConverter productConverter;

    public WarehouseDao(ProductConverter productConverter, String fileName) throws FileNotFoundException {
        this.productConverter = productConverter;
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    public List<Product> getAllProducts() {

        BufferedReader fileStream = getBufferedReader();
        List<Product> resultProductList = new ArrayList<>();

        try {
            String line = fileStream.readLine();

            while (line != null) {
                //TODO pzeniesc to oddzielnej metody abstrakcyjnej
                Product product = productConverter.parseLineToProduct(line);
                resultProductList.add(product);
                line = fileStream.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultProductList;
    }

    private BufferedReader getBufferedReader() {
        BufferedReader fileStream = null;
        try {
            fileStream = new BufferedReader((new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileStream;
    }


    public Optional<Product> findProductById(int productID) {
        BufferedReader fileStream = getBufferedReader();

        try {
            String line = fileStream.readLine();

            while (line != null) {
                //TODO pzeniesc to oddzielnej metody abstrakcyjnej
                Product product = productConverter.parseLineToProduct(line);
                if (product.getId() == productID) {
                    return Optional.of(product);
                }
                line = fileStream.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
