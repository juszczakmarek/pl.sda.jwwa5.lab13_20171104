package pl.sda.wwa5.lab.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class IdGenerator {

    private String fileName;

    public IdGenerator(String fileName) {
        this.fileName = fileName;
    }

    int generateId() {
        BufferedReader bufferedReader = getBufferedReader();
        try {
            String line = bufferedReader.readLine();

            if (line!=null) {
                String[] orderLine = line.split(",");
                return Integer.valueOf(orderLine[0]) + 1;
            } else {
                return 1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
