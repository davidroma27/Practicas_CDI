/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog7;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Prog7 {

    public static void main(String[] args) throws InterruptedException {
        final int NUMERO_THREADS = 32;
        List<Thread> threadList = new ArrayList<Thread>(NUMERO_THREADS);
        for (int i = 1; i <= NUMERO_THREADS; ++i) {
            threadList.add(new MyThread());
        }
        
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            Thread myThread = l1.next();
            myThread.start();
            myThread.join();
        }
        
        Iterator<Thread> l2 = threadList.iterator();
        while(l2.hasNext()){
            //System.out.println(l2.next().isAlive());
        }
        
        System.out.println("El programa ha terminado");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Mi nombre es: " + this.getName());
        System.out.println("Finalizado el proceso " + this.getName());
    }
}
