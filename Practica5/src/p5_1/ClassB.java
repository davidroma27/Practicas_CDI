package p5_1;

/**
 *
 * @author david
 */
public class ClassB implements Runnable{
    ClassA a;
    int N_THREADS;
    
    public ClassB(ClassA a, int N_THREADS){
        this.N_THREADS = N_THREADS;
        this.a = a; 
    }
    
    /** APARTADO B)
    public void run(){
        
        a.EnterAndWait(N_THREADS);
    }
    */
    
    //APARTADO E)
    public void run(){
        
        synchronized(a){
        a.EnterAndWait(N_THREADS);
        }
    }
}
