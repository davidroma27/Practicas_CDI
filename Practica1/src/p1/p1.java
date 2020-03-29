package p1;

/**
 *
 * @author david
 */
public class p1 {
    public static void main(String[] args) {
        int numThreads = Integer.parseInt(args[0]);
        int time = Integer.parseInt(args[1]);
        
        for(int i=0; i<=numThreads; i++){
            Thread t = new Thread(new MyRunnable(), "Hello world, I’m a java thread number" + i);
            t.start();
            try {
                Thread.sleep(time);
                System.out.println("Bye, this was thread number" + i);
            } catch (InterruptedException e) {
                System.out.println("Im an interrupted thread [" + i + "]");
            }
        }
    }
}
