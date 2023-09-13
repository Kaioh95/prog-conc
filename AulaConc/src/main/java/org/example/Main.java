package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long id_pacote = 0;
        ArrayList<Long> buffer = new ArrayList<Long>();

        Prod prod = new Prod(buffer, 120, 50);
        Con con1 = new Con(buffer, 60, 50);
        Con con2 = new Con(buffer, 60, 50);

        // Running the threads
        prod.start();
        con1.start();
        con2.start();

        prod.join();
        con1.join();
        con2.join();

        System.out.println("Final List: " + buffer.toString());
    }
}