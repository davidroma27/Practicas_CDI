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

    //Siempre que tengamos un Runnable tenemos que tener el metodo run()
    //Aqui tendremos las tareas que van a realizar los hilos
    public void run() {
        //simulate some CPU expensive task
        for (int i = 0; i < 100000000; i++) {
            rand.nextInt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        //Creamos un array con 5 hilos y los arrancamos en un bucle for
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join(); //el join asegura que el hilo main solo continuara 
                               //sus tareas cuando los hilos hijos hayan terminado
        }
        /**
         * Si no se hace uso del join() en ese for el hilo main siempre terminará
         * antes que los hilos hijos ya que tienen una tarea mucho mas pesada.
         */
        //Al usar join() el ultimo print siempre se mostrara al final siendo
        //el hilo main el ultimo que termina en ejecutarse.
        System.out.println("[" + Thread.currentThread().getName() + "] All threads done!");
    }
}
