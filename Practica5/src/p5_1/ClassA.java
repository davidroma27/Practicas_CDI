package p5_1;

/**
 *
 * @author david
 */
public class ClassA {

    public void EnterAndWait(int N_THREADS) {
        try {
            System.out.println("Start Thread " + N_THREADS);
            Thread.sleep((int) (Math.random() * 100));
            System.out.println("Finish Thread " + N_THREADS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
