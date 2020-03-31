package p6_1;

/**
 *
 * @author david
 */
public class ClassA {

    public void EnterAndWait(String n, Thread t) {
        try {
            System.out.println("Started Thread: " + n);
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
