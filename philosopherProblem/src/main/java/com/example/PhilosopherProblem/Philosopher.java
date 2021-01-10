package com.example.PhilosopherProblem;

import java.util.Random;

public  class Philosopher implements Runnable {

    private final int id;
    private final ChopStick leftChopStick;
    private final ChopStick rightChopStick;

    volatile boolean isTummyFull = false;

    private Random randomGenerator = new Random();

    private int noOfTurnsToEat = 0;

    /**
     * @param id Philosopher number
     * @param leftChopStick
     * @param rightChopStick
     */
    public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
    }

    @Override
    public void run() {

        try {
            while (!isTummyFull) {
                think();
                // Make the mechanism obvious.
                if (leftChopStick.pickUp(this, "left")) {
                    if (rightChopStick.pickUp(this, "right")) {
                        eat();
                        // Finished.
                        rightChopStick.putDown(this, "right");
                    }
                    // Finished.
                    leftChopStick.putDown(this, "left");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking");
        Thread.sleep(randomGenerator.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating");
        noOfTurnsToEat++;
        Thread.sleep(randomGenerator.nextInt(1000));
    }

    public int getNoOfTurnsToEat() {
        return noOfTurnsToEat;
    }

    @Override
    public String toString() {
        return "Philosopher -" + id;
    }
}
