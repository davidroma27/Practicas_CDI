/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interrupt;

/**
 *
 * @author david
 */
public class InterruptExample implements Runnable {
    public void run() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
    }
    while(!Thread.interrupted()) {
        //do nothing here
    }
    System.out.println("["+Thread.currentThread().getName()+"] Interrupted for the second time.");
}

    public static void main(String[] args) throws InterruptedException {
        //Creamos un solo hilo
        //Crea un subproceso y duerme 5 segundos
        Thread myThread = new Thread(new InterruptExample(), "myThread");
        myThread.start();
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);
        //En cada interrupcion interrumpe al subproceso que ha creado
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
        //Despues de cada interrupcion se vuelve a dormir
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
    }
}