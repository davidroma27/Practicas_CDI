/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoinExample;

import java.util.Random;

/**
 *
 * @author david
 */
public class JoinExample implements Runnable {

    private Random rand = new Random(System.currentTimeMillis());

    //Siempre que tengamos un implements tenemos que tener el metodo run()
    //Aqui tendremos las tareas que van a realizar los hilos
    public void run() {
        //simulate some CPU expensive task
        for (int i = 0; i < 100000000; i++) {
            rand.nextInt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        //Creamos un array con 5 hilos y los arramcamos en un bucle for
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join(); //el join asegura que el hilo main solo continuara 
                               //sus tareas cuando los hilos hijos hayan terminado
        }
        //De este modo el ultimo print siempre se mostrara al final
        System.out.println("[" + Thread.currentThread().getName() + "] All threads done!");
    }
}
