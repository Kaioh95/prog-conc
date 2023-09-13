package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        List cList = new ArrayList<Thread>();

        for(int i=0; i < 8; i++){
            CounterThread ct = new CounterThread(i, counter);
            cList.add(ct);
            ct.start();
        }

        System.out.println("Hello world!");
    }
}