package org.yrs.concurrency.thinkingInJava.basicThreadMechanism;

/**
 * @author ByrsH
 * @create 2018-04-07 23:26
 **/

public class MainThread {
    public static void main(String[] args){
        LiftOff launch = new LiftOff();
        LiftOff launch2 = new LiftOff();
        launch.run();
        launch2.run();
    }
}
