/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoinExample1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author david
 */
public class JoinExample1 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        final int NUMERO_THREADS = 5;
        List<Thread> threadList = new ArrayList<Thread>(NUMERO_THREADS);
        for (int i = 1; i <= NUMERO_THREADS; ++i) {
            threadList.add(new JoinExample1());
            System.out.println("Thread " + i + " creado");
        }
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            l1.next().start();
        }
        l1 = threadList.iterator();
        while (l1.hasNext()) {
            Thread t = l1.next();
            try {
                t.join();
                System.out.println("Terminado realmente " + t.getName());
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        System.out.println("El programa ha terminado");
    }
}
