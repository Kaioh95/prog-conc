package org.example;

public class Counter {
    protected long count;

    public Counter() {
        count = 0;
    }

    public long getNext(){
        return count++;
    }
}
