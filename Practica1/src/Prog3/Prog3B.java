/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog3;

/**
 *
 * @author david
 */

/**
 * En este ejemplo tenemos dos hilos, uno que implementa Runnable (El hilo hijo)
 * y el hilo principal creado en el main (main thread). 
 * 
 * En las computadoras de un solo núcleo los dos hilos se van turnando para compartir
 * el uso de la CPU. Si se ejecuta el hilo hijo, el hilo principal es interrumpido
 * y viceversa.
 * 
 * Cada vez que uno de los hilos se duerme por el metodo sleep(), el otro hilo 
 * se hace con los recursos de la cpu.
 */
class NewThread implements Runnable {
    Thread t;
    NewThread() {
    t= new Thread(this, "Demo Thread");
    System.out.println("Child thread: " + t);
    }
    public void run() {
    try {
        for(int i=5; i>0; i--) {
            System.out.println("Child Thread " + i);
            Thread.sleep(500);
        }
    } catch (InterruptedException e) {
        System.out.println("Child interrupted.");
    }
        System.out.println("Exiting child thread.");
    }
}

class Prog3B {
    public static void main(String args[]) {
    NewThread nt = new NewThread();
    nt.t.start();
    try {
        for (int i=5; i>0; i--){
            System.out.println("Main Thread: " +i );
            Thread.sleep(1000);
        }
    } catch (InterruptedException e){
    System.out.println("Main thread interrupted");
    }
    System.out.println("Main thread Exiting");
    }
} 
