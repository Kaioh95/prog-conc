package org.example;
import java.util.ArrayList;

public class Prod extends Thread{
    protected long id_pacote;
    protected int count;
    protected ArrayList<Long> buffer;
    protected int total;
    protected int sleep;

    public Prod(ArrayList<Long> bf, int total, int sleep){
        this.buffer = bf;
        this.total = total;
        this.sleep = sleep;
    }

    public void run(){
        while(count < this.total){
            System.out.println("Add " + id_pacote + " to list!");
            this.buffer.add(id_pacote++);
            count++;
            try {
                Thread.sleep(this.sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
