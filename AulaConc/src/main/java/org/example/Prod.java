package org.example;
import java.util.ArrayList;

public class Prod extends Thread{
    protected long id_pacote;
    protected int count;
    protected ArrayList<Long> buffer;

    public Prod(ArrayList<Long> bf){
        this.buffer = bf;
    }

    public void run(){
        while(count < 120){
            System.out.println("Add " + id_pacote + " to list!");
            this.buffer.add(id_pacote++);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
