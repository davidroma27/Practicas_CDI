package Prog2;

public class Prog2 extends Thread {
    public Prog2(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Executing thread "
                +Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Prog2 myThread = new Prog2("myThread");
        myThread.start();
    }
}