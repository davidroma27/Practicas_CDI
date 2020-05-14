package P4;

/**
 *
 * @author david
 */
public class P4 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread p = new Thread(new Productor(buffer));
        Thread c = new Thread(new Consumidor(buffer));
        p.start();
        c.start();

    }
}
