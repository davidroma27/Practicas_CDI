
package P4;


/**
 *
 * @author david
 */
public class Socket {

    public static void main(String args[]) throws InterruptedException {
        new Server().start();
        new Client().start();
        new Client().start();
        new Client().start();
        new Client().start();
        
    }
}
