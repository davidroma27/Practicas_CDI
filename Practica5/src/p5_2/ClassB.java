package p5_2;

/**
 *
 * @author david
 */
public class ClassB extends Thread{
    ClassA a;
    int nh;
    
    public ClassB(int N_THREADS, ClassA a){
        this.nh = N_THREADS;
        this.a = a; 
    }
    
    public void run(){
        
        synchronized (a) {
            while (!a.isFinished()) {
                System.out.println("ThreadID=" + nh + " name=" + Thread.currentThread().getName()
                        + " state=" + Thread.currentThread().getState() + " lastTh="
                        + a.getThreadID());
                while (a.getThreadID() == nh) {
                    try {
                        System.out.println("sent waiting=" + this.nh);
                        a.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if (!a.isFinished()) {
                    a.EnterAndWait(nh);
                    a.setCounter(a.getCounter() - 1);
                    a.setThreadID(this.nh);
                    a.notifyAll();
                    System.out.println("---------------");
                }
            }
        }
    }
  
}
