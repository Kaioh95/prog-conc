package org.example;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long id_pacote = 0;
        ArrayList<Long> buffer = new ArrayList<Long>();

        Semaphore semaphore = new Semaphore(2, true);
        Prod prod = new Prod(buffer, 60, 10);
        Con con1 = new Con(buffer, 60, 50, semaphore);
        //Con con2 = new Con(buffer, 60, 50);

        // Running the threads
        prod.start();
        con1.start();
        //con2.start();

        prod.join();
        con1.join();
        //con2.join();

        System.out.println("Final List: " + buffer.toString());
    }
}