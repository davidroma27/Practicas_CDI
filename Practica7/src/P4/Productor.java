package P4;
/**
 *
 * @author david
 */
public class Productor extends Thread {

    private Buffer b;

    public Productor(Buffer b) {
        this.b = b;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                b.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
