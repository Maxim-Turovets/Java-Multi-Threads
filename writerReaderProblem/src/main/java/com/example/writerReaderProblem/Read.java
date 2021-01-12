package com.example.writerReaderProblem;

import java.util.concurrent.Semaphore;

public class Read implements Runnable {
    private Semaphore readLock;
    private Semaphore writeLock;
    private volatile int readCount;

    public Read(Semaphore readLock, Semaphore writeLock, int readCount) {
        this.readLock = readLock;
        this.writeLock = writeLock;
        this.readCount = readCount;
    }

    public Read() { }

    @Override
    public synchronized void run() {
        try {
            readLock.acquire();
            readCount++;
            if (readCount == 1) {
                writeLock.acquire();
            }
            System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
            Thread.sleep(1500);
            System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
            readLock.release();
            readCount--;
            if(readCount == 0) {
                writeLock.release();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
