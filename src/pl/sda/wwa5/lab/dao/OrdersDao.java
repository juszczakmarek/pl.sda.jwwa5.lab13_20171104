package pl.sda.wwa5.lab.dao;

import pl.sda.wwa5.lab.Order;
import pl.sda.wwa5.lab.converter.OrderConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class OrdersDao {

    private String fileName;
    private OrderConverter orderConverter;

    public Optional<Order> findByOrderId(int orderdId) {
        BufferedReader fileStream = getBufferedReader();

        try {
            String line = fileStream.readLine();

            while (line != null) {
                //TODO pzeniesc to oddzielnej metody abstrakcyjnej
                Order order = orderConverter.parseLineToOrder(line);

                line = fileStream.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
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

}
