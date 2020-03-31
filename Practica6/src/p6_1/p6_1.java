package p6_1;


/**
 *
 * @author david
 */
public class p6_1 {
    
    public static void main(String[] args) throws InterruptedException{
        ClassA a = new ClassA();
        ClassB b1 = new ClassB(a);
        ClassB b2 = new ClassB(a);

        Thread t1 = new Thread(b1, "Executing b" + 1);
        Thread t2 = new Thread(b2, "Executing b" + 2);
        
        b1.setNextThread(b2);
        b2.setNextThread(b1);
        
        t1.start();
        t2.start();
        
        Thread.sleep(1000);
        
        synchronized(b1){ 
            b1.notify();
            System.out.println("B1 has notified");
        }
        
        b1.isInterrupted();
        b2.isInterrupted();
        
        t1.join();
        System.out.println("B1 stopped");
        
        t2.join();
        System.out.println("B2 stopped");
        
        System.out.println("Done!");
    }
}
