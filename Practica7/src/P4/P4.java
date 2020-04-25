package P4;

/**
 *
 * @author david
 */
public class P4 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Productor (buffer).start();
        new Consumidor (buffer).start();
    }
}
