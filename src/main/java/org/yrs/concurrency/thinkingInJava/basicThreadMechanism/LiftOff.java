package org.yrs.concurrency.thinkingInJava.basicThreadMechanism;

import org.apache.poi.util.SystemOutLogger;

/**
 * Demo of the Runnable interface
 *
 * @author ByrsH
 * @create 2018-04-07 22:19
 **/

public class LiftOff implements Runnable{

    protected int countDown = 10; //Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public  LiftOff() {};

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
