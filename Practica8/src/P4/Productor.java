package P4;
/**
 *
 * @author david
 */
public class Productor extends Thread {

    private Buffer b;
    int cont = 0;

    public Productor(Buffer b) {
        this.b = b;
    }

    public void run() {
        while(true){
            try {
                b.write();
                cont++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
