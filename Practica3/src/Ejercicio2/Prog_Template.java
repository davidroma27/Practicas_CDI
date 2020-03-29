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
            Thread t = new Thread("Thread " + i);
            threadList.add(t);
            t.start();
        }
         
        Iterator<Thread> l1 = threadList.iterator();
        
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
        Iterator<Thread> i = threadList.iterator();
        while(i.hasNext()){
            Thread t2 = i.next();
            t2.interrupt();
         }

        System.out.println("The program is Finished!");
    }
}
