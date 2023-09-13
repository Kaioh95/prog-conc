package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long id_pacote = 0;
        ArrayList<Long> buffer = new ArrayList<Long>();

        Prod prod = new Prod(buffer);
        Con con1 = new Con(buffer);
        Con con2 = new Con(buffer);

        // Running the threads
        prod.start();
        con1.start();
        con2.start();

        System.out.println("Hello world!");
    }
}