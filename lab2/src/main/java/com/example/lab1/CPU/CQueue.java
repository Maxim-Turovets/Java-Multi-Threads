package com.example.lab1.CPU;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CQueue {

    private Queue<Process> queue = new ConcurrentLinkedQueue<>();

    private int maxLength;

    public synchronized void addProcessToQueue(Process process) {
        queue.add(process);
        maxLength = (maxLength < getSize()) ? getSize() : maxLength;
    }

    public synchronized Process removeProcessFromQueue() {
        Process rem = queue.remove();
        return rem;
    }

    public int getSize() {
        return queue.size();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public int getMaxLength() {
        return maxLength;
    }
}
