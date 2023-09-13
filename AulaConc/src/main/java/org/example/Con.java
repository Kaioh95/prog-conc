package org.example;
import java.util.ArrayList;

public class Con extends Thread{
    protected int count;
    protected ArrayList<Long> buffer;
    protected int total;
    protected int sleep;

    public Con(ArrayList<Long> bf, int total, int sleep){
        this.buffer = bf;
        this.total = total;
        this.sleep = sleep;
    }

    public void run(){
        synchronized (this.buffer) {
            while (count < this.total) {
                if (this.buffer.size() > 0) {
                    System.out.println("Remove " + this.buffer.get(0) + " from list!");
                    this.buffer.remove(0);
                    this.count++;
                }
                try {
                    Thread.sleep(this.sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
