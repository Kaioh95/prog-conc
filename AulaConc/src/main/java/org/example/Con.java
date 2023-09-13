package org.example;
import java.util.ArrayList;

public class Con extends Thread{
    protected int count;
    protected ArrayList<Long> buffer;

    public Con(ArrayList<Long> bf){
        this.buffer = bf;
    }

    public void run(){
        synchronized (this.buffer) {
            while (count < 60) {
                if (this.buffer.size() > 0) {
                    System.out.println("Remove " + this.buffer.get(0) + " from list!");
                    this.buffer.remove(0);
                    this.count++;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
