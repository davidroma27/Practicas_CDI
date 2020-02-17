/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runnable;

/**
 *
 * @author david
 */
public class Test implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing thread "
                +Thread.currentThread().getName());
    }

    public static void main(String[] args) throws
            InterruptedException {
        Thread Test = new Thread(new Test(), "myRunnable");
        Test.start();
    }
}
