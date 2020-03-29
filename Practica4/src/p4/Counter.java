package p4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author david
 */

/** APARTADO A)
public class Counter {
    private int counter=0;
    
    public int getCounter(){
        return counter;
    }
    
    public void increment(){
        counter++;
    }
}
*/

//APARTADO E)
public class Counter{
    private AtomicInteger counter;
    
    public Counter(){
        counter = new AtomicInteger(0);
    }
    
    public int getCounter(){
        int cont;
        return cont = counter.get();
    }
    
    public void increment(){
        counter.getAndAdd(1);
    }
}
