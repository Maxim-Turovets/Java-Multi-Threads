package com.example.writerReaderProblem;

import java.util.concurrent.Semaphore;

public class Write implements Runnable {

    private Semaphore readLock;
    private Semaphore writeLock;

    public Write(Semaphore readLock, Semaphore writeLock) {
        this.readLock = readLock;
        this.writeLock = writeLock;
    }

    @Override
    public synchronized void run() {
        try {
            writeLock.acquire();
            System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
            Thread.sleep(2500);
            System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
            writeLock.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}