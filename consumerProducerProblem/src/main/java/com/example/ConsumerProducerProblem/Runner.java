package com.example.ConsumerProducerProblem;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Runner {


    public static void main(String [] args) {
         LinkedList list = new LinkedList();
         Semaphore sem = new Semaphore(0);
         Semaphore mutex = new Semaphore(1);

         Producer producer = new Producer(list,sem,mutex);
         Consumer consumer1 = new Consumer("Consumer-1",list,sem,mutex);
         Consumer consumer2 = new Consumer("Consumer-2",list,sem,mutex);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
