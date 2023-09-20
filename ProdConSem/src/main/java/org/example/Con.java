package org.example;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Con extends Thread{
    protected int count;
    protected ArrayList<Long> buffer;
    protected int total;
    protected int sleep;
    private Semaphore semaphore;

    public Con(ArrayList<Long> bf, int total, int sleep, Semaphore semaphore){
        this.buffer = bf;
        this.total = total;
        this.sleep = sleep;
        this.semaphore = semaphore;
    }

    public void run(){
        try{
            this.semaphore.acquire();

            while (count < this.total) {
                if (this.buffer.size() > 0) {
                    System.out.println("Remove " + this.buffer.get(0) + " from list!");
                    this.buffer.remove(0);
                    this.count++;
                }
                Thread.sleep(this.sleep);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

}
