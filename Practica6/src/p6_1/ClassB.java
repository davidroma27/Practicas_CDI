package p6_1;

/**
 *
 * @author david
 */
public class ClassB implements Runnable{
    ClassA a;
    private ClassB t;
    private boolean next = true;
    
    public ClassB(ClassA a){
        this.a = a; 
    }
    
    public void setNextThread(ClassB t){
        this.t=t;
    }
    
    public void isInterrupted(){
        next = false;
    }
    
    public void run(){
        while(next){
            synchronized(this){
                try {
                    this.wait();
                    a.EnterAndWait(Thread.currentThread().getName(), Thread.currentThread());
                } catch (InterruptedException e) {
                    next = false;
                }
                synchronized(t){
                    t.notify();
                }
            }
        }
    }
}
