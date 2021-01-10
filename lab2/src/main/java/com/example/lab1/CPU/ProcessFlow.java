package com.example.lab1.CPU;


import com.example.lab1.MVC.View;

public class ProcessFlow implements Runnable {

    private boolean flag;
    static View view = new View();
    private int processNumber;
    private CQueue queue = new CQueue();

    public ProcessFlow(int min, int max) {
        processNumber = generateRandomNumber(min, max);
    }

    @Override
    public void run() {
        view.printMessage(Thread.currentThread() + "\t" + View.GENERATE_FLOW + processNumber);
        int rand;
        Process process = null;
        for (int i = 0; i < processNumber; i++) {
            rand = generateRandomNumber(1, 10);
            process =new Process(rand, 2 * rand);
            view.printMessage(Thread.currentThread() + "\t" + View.PROCESS + process);
            queue.addProcessToQueue(process);
            try {
                view.printMessage(Thread.currentThread() + "\t" + View.TIME_BETWEEN_PROCESSES + process.getTime() + "\n");
                Thread.sleep(process.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        synchronized (this) {
            notifyAll();
        }
    }


    public int generateRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public CQueue getQueue() {
        return queue;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
