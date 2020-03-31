package p5_2;


/**
 *
 * @author david
 */
public class ClassA {
    volatile private int counter;
    private long threadIds=0;
    
    public ClassA(int cont){
        this.counter = cont;
    }
    
    public boolean isFinished(){
        return counter<=0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public long getThreadID(){
        return threadIds;
    }
    
    public void setThreadID(long thread){
        this.threadIds = thread;
    }
    
    synchronized public void EnterAndWait(int N_THREADS) {
        try {
            System.out.println("Start Thread " + N_THREADS + ", cont= " + counter);
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
