package pl.sda.wwa5.lab.dao;

import pl.sda.wwa5.lab.Order;
import pl.sda.wwa5.lab.converter.OrderConverter;

import java.io.*;
import java.util.*;

public class OrdersDao {

    private String fileName;
    private OrderConverter orderConverter;
    private IdGenerator idGenerator;

    public OrdersDao(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
        this.idGenerator = new IdGenerator(fileName);
    }

    public OrdersDao(String fileName, OrderConverter orderConverter, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.orderConverter = orderConverter;
        this.idGenerator = idGenerator;
    }

    public Order createOrder() {
        int orderId = idGenerator.generateId();
        return new Order(orderId,new Date().getTime(),0,null, new LinkedHashMap<>());
    }

    public Optional<Order> findByOrderId(int orderdId) {
        BufferedReader fileStream = getBufferedReader();

        try {
            String line = fileStream.readLine();

            while (line != null) {
                //TODO pzeniesc to oddzielnej metody abstrakcyjnej
                Order order = orderConverter.parseLineToOrder(line);

                line = fileStream.readLine();
                order = orderConverter.parseLineToOrder(line);
                return Optional.of(order);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
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

    public void writeOrderToFile(Order order) {
        BufferedReader bufferedReader = getBufferedReader();
        List<Order> allExistingOrders = new ArrayList<>();

        try {
            String line = bufferedReader.readLine();
            boolean thisIsNewOrder = true;
            while (line != null) {
                Order orderExistingInFile = orderConverter.parseLineToOrder(line);
                if (orderExistingInFile.getId()==order.getId()) {
                    allExistingOrders.add(order);
                    thisIsNewOrder = false;
                } else {
                    allExistingOrders.add(orderExistingInFile);
                }
            }

            if (thisIsNewOrder) {
                allExistingOrders.add(0,order);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        File outputFile = new File(fileName);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outputFile));
            for (Order currentOrder : allExistingOrders) {
                String orderToBeWritten = orderConverter.parseOrderToLine(currentOrder);
                outputStreamWriter.append(orderToBeWritten);
            }
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
