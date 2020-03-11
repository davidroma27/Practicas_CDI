/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej_Matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author david
 */
class prob2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        // set dimension of Matrix
        Matriz matrix = new Matriz(5); //Crea una matriz 5*5
        
        // set number of threads
        final int NUMERO_THREADS = (int) Math.pow(matrix.getDim(), 2); //Genera tantos hilos como celdas(Un hilo por celda)
        List<Thread> threadList = new ArrayList<Thread>(NUMERO_THREADS);
        for (int i = 1; i <= NUMERO_THREADS; ++i) {
            threadList.add(new Thread());
        }
        
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            Thread myThread = l1.next();
            myThread.start();
            myThread.join();
        }
        
        while (l1.hasNext()) {
            Thread t = l1.next();
            try {
                t.join();
                System.out.println("Terminado realmente " + t.getName());
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }


        // Generate Matrix
        GrayImage img = new GrayImage("D:\\UNIVERSIDAD\\3º\\CDI\\Practicas_CDI\\Practica3\\src\\Ej_Matrix\\monkey.png");
        for(int j=0; j<img.getWidth(); j++){
        }
        // call the SimpleFilter
        
        // or call the Threaded Filter
        
    }
}