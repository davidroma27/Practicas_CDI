package p4;


/**
 *
 * @author david
 */
public class MyTask extends Thread{
    Counter cont;
    
    public MyTask(Counter cont){
        this.cont=cont;
    }
    
    /** APARTADO B)
    public void run() {
        try {
                Thread.currentThread().sleep((int) (Math.random() * 100));
                cont.increment();
                System.out.println("[" + Thread.currentThread().getName()
                        + "] cont= " + cont.getCounter());

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
    */
    
    //Apartado D)
    public void run() {
        try {
            synchronized (cont) {
                Thread.currentThread().sleep((int) (Math.random() * 100));
                cont.increment();
                System.out.println("[" + Thread.currentThread().getName()
                        + "] cont= " + cont.getCounter());
            }

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}
