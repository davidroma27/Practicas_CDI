package P4;

/**
 *
 * @author david
 */
 public class Consumidor extends Thread {

    private Buffer b;
    int cont = 0;

    public Consumidor(Buffer b) {
        this.b = b;
    }

    public void run() {

        while (true) {
            try {                
                b.read();
                cont++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
