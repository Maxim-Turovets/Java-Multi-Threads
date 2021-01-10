package com.example.ConsumerProducerProblem;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Producer extends Thread{
    private LinkedList list;
    private Semaphore sem;
    private Semaphore mutex;

    public Producer(LinkedList list,Semaphore sem,Semaphore mutex) {
        this.list = list;
        this.sem = sem;
        this.mutex = mutex;
    }

    public void run() {
        try {

            int N = 0;

            while (true) {
                mutex.acquire();
                list.add(new Integer(N++));
                mutex.release();
                sem.release(1);
                Thread.sleep(500);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
