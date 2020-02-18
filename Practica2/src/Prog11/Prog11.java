/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog11;

/**
 *
 * @author david
 */
//Unsafe variables

import java.util.concurrent.TimeUnit;
import java.util.Date;
// * Class that shows the problem generate when some Thread objects share a data structure

class UnsafeTask implements Runnable {
    // Date shared by all threads

    private Date startDate;
    //Main method of the class. Saves the start date and writes it to the
    //console when it starts and when it ends

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        
        //Hacemos que cada thread se duerma um tiempo aleatorio
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}

public class Prog11 {
    // Main method of the UnsafeTaks. Creates a Runnable task and three Thread
    // objects that run it.

    public static void main(String[] args) {
        // Creates the unsafe task
        UnsafeTask task = new UnsafeTask();
        // Throw ten Thread objects
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

