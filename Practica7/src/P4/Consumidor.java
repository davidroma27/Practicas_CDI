package P4;

/**
 *
 * @author david
 */
 public class Consumidor extends Thread {

    private Buffer b;
    private Integer veces = 0;

    public Consumidor(Buffer b) {
        this.b = b;
    }

    public void run() {

        while (veces < 10) {
            try {
                b.read();
                veces++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
