package com.example.lab1.CPU;



import com.example.lab1.MVC.View;

import java.util.List;


public class CPU implements Runnable {
    static View view = new View();
    private List<ProcessFlow> flows;
    private int operationTime;
    private String name;
    private int workedProcesses;

    public CPU(String name, List<ProcessFlow> flows) {
        this.name = name;
        this.flows = flows;
        operationTime = generateRandOperTime(1, 10);//generates initial random operation time of CPU
    }



    public int generateRandOperTime(int min, int max) {
        int number = (int) (min + Math.random() * (max - min + 1)) * 100;
        return number;
    }

    @Override
    public void run() {
        if (flows.size() == 1) {
            operateOneFlow();
        } else {
            operateTwoFlows();
        }
    }

    public void operateOneFlow() {
        ProcessFlow processFlow = flows.get(0);
        CQueue cQueue = processFlow.getQueue();
        while (!processFlow.isFlag() || cQueue.getSize() != 0) {
            if (cQueue.getSize() == 0) {
                waiting();
            } else {
                operating(cQueue);
            }
        }
    }

    public void operateTwoFlows() {
        ProcessFlow processFlow1 = flows.get(0);
        ProcessFlow processFlow2 = flows.get(1);
        CQueue cQueue1 = processFlow1.getQueue();
        CQueue cQueue2 = processFlow2.getQueue();
        while (!processFlow1.isFlag() || !processFlow2.isFlag() || cQueue1.getSize() != 0 || cQueue2.getSize() != 0) {
            if (cQueue1.getSize() != 0) {
                operating(cQueue1);
            } else if (cQueue2.getSize() != 0) {
                operating(cQueue2);
            } else {
                waiting();
            }
        }
    }

    public void operating(CQueue cQueue) {
        try {
            view.printMessage(getName() + "\t" + View.HANDLING_PROCESS + operationTime
                    + "\t" + cQueue.removeProcessFromQueue().toString());
            workedProcesses++;
            Thread.sleep(generateRandOperTime(1, 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void waiting() {
        try {
            view.printMessage(getName() + View.WAITING_FOR_PROCESS);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<ProcessFlow> getFlows() {
        return flows;
    }

    public void setFlows(List<ProcessFlow> flows) {
        this.flows = flows;
    }

    public int getWorkedProcesses() {
        return workedProcesses;
    }
}

