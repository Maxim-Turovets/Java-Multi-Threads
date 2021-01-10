package com.example.lab1.MVC;


import com.example.lab1.CPU.CPU;
import com.example.lab1.CPU.ProcessFlow;

import java.util.LinkedList;
import java.util.List;

public class Model {
    ProcessFlow process1 = new ProcessFlow(50, 50);
    ProcessFlow process2 = new ProcessFlow(50, 50);

    CPU cpu1, cpu2, cpu3;


    public void createServiceSystem() {
        cpu1 = createCPU("CPU1", process1);
        cpu2 = createCPU("CPU2", process2);
        cpu3 = createCPU("CPU3", process1, process2);
        Thread p1 = new Thread(process1);
        Thread p2 = new Thread(process2);
        Thread c1 = new Thread(cpu1);
        Thread c2 = new Thread(cpu2);
        Thread c3 = new Thread(cpu3);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int maximumQueuelength(ProcessFlow processFlow) {
        return processFlow.getQueue().getMaxLength();
    }

    public int getProcessedTasks(CPU cpu) {
        return cpu.getWorkedProcesses();
    }


    public CPU createCPU(String CPU_name, ProcessFlow... proc) {
        List list = new LinkedList<>();
        list.add(proc[0]);
        if (proc.length == 2) {//if there are 2 ProcessFlows, second one is also considered in CPU constructor
            list.add(proc[1]);
        }
        CPU cpu = new CPU(CPU_name, list);
        return cpu;
    }


    public int calculateShare(ProcessFlow processFlow, CPU cpu) {
        return 100 * (processFlow.getProcessNumber() - cpu.getWorkedProcesses()) / processFlow.getProcessNumber();
    }


    public ProcessFlow getProcess2() {
        return process2;
    }

    public ProcessFlow getProcess1() {
        return process1;
    }

    public CPU getCpu1() {
        return cpu1;
    }

    public CPU getCpu2() {
        return cpu2;
    }

    public CPU getCpu3() {
        return cpu3;
    }
}
