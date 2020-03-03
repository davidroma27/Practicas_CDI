/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiProblema {

    public static void main(String[] args) {
        final int NUMERO_THREADS = 32;
        List<Thread> threadList = new ArrayList<Thread>(NUMERO_THREADS);
        for (int i = 1; i <= NUMERO_THREADS; ++i) {
            threadList.add(new MiThread());
        }
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            l1.next().start();
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
        System.out.println("El programa ha terminado");
    }
}
