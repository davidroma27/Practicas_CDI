/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog6;

/**
 *
 * @author david
 */
class NewThread implements Runnable {

    String name;
    Thread t;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread " + t);
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

class Prog6 {

    public static void main(String args[]) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();
        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());
        try {
            System.out.println("Waiting for other threads to finish");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        //Estos print siempre dan false porque los join hacen que 
        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());
        System.out.println("Main thread Exiting");
    }
}
