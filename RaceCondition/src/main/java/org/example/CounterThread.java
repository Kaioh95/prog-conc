package org.example;

public class CounterThread extends Thread {
    protected int tid;
    protected Counter counter;
    public CounterThread(int tid, Counter counter){
        this.tid = tid;
        this.counter = counter;
    }

    public void run(){
        while(counter.count < 10000) {
            System.out.println("Thread " + tid + ": " + counter.getNext());
        }
    }
}
