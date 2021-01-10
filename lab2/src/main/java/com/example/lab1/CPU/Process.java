package com.example.lab1.CPU;

import lombok.Data;

@Data
public class Process {

    private int time;
    private int name;
    static volatile int counter;

    public Process(int min, int max) {
        this.time = generateRandomNumber(min, max);
        name = counter++;
    }

    public int generateRandomNumber(int min, int max) {
        int number = (int) (min + Math.random() * (max - min + 1)) * 10;
        return number;
    }


    @Override
    public String toString() {
        return "Process{" +
                "name=" + name +
                '}';
    }
}
