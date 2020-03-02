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
//Creamos un thread y lo y lo arrancamos mediante un runnable
public class Test implements Runnable {

    
    /**
     * El metodo run() es implementado por la interfaz Runnable.
     * Este metodo contiene todo el código que vaya a ser ejecutado en el hilo.
     * En este caso se va a mostrar el nombre del hilo que se esta ejecutando.
     */
    @Override
    public void run() {
        System.out.println("Executing thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws
            InterruptedException {
        Thread Test = new Thread(new Test(), "myRunnable"); //Se crea el thread
        Test.start(); //Se arranca el thread
    }
}
