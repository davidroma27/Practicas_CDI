
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

    public static void main(String args[]) throws InterruptedException {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");
        nt1.t.start();
        nt1.t.join(); //Se usa el join para que no se ejecuten varios hilos a la vez
        nt2.t.start();
        nt2.t.join();
        nt3.t.start();
        try {
            // wait for other threads to end
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread Exiting");
    }
}
