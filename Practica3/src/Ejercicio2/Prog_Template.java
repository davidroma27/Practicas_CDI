/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author david
 */
public class Prog_Template {
    public static void main(String[] args) {
        final int NUMBER_THREADS = 20;
        List<Thread> threadList = new ArrayList<Thread>(NUMBER_THREADS);
        // Code given previously to launch
         for (int i = 1; i <= NUMBER_THREADS; ++i) {
            threadList.add(new ThreadInterrupt());
        }
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            l1.next().start();
        }
        
        // join threads
        while (l1.hasNext()) {
            Thread t = l1.next();
            try {
                t.join();
                System.out.println("Terminado realmente " + t.getName());
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        // CODE FOR Interrupting Threads
        

        System.out.println("The program is Finished!");
    }
}
