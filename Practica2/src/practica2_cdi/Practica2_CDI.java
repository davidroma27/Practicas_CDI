/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_cdi;

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

class Prog5 {
    //Creamos 3 threads nuevos y los arrancamos (start())
    //Para que el ultimo print salga de ultimo tenemos que modificar los sleep()
    //Sustituimos los sleep por el metodo isAlive() y join() (siguiente ejemplo JoinExample.java)
    public static void main(String args[]) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();
        try {
            // wait for other threads to end
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread Exiting");
    }
}
