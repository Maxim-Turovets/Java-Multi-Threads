package com.example.ConsumerProducerProblem;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

class Consumer extends Thread {

    private String name;
    private LinkedList list;
    private Semaphore sem;
    private Semaphore mutex;

    public Consumer(String name,LinkedList list,Semaphore sem,Semaphore mutex) {
        this.name = name;
        this.list = list;
        this.sem = sem;
        this.mutex = mutex;
    }


    public void run() {
        try {
            while (true) {
                sem.acquire(1);
                mutex.acquire();
                System.out.println("Consumer \""+name+"\" read: "+list.removeFirst());
                mutex.release();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}

