/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog12;

/**
 *
 * @author david
 */
//Programa anterior resuelto con ThreadLocal

import java.util.concurrent.TimeUnit;
import java.util.Date;
// Class that shows the usage of ThreadLocal variables to share data between
// Thread objects

class SafeTask implements Runnable {
    // ThreadLocal shared between the Thread objects
    //se crea un objeto threadlocal de tipo Date
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        
        //De esta forma la fecha de cada hilo no va a coincidir con ningun otro
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
// Writes the start date
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Writes the start date
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}

public class Prog12 {

    public static void main(String[] args) {
// Creates a task
        SafeTask task = new SafeTask();
// Creates and start three Thread objects for that Task
        for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(task);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }
}
