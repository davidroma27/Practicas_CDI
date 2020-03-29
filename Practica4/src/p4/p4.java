package p4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author david
 */
public class p4 {
    public static void main(String[] args) {
       final int NUMBER_OF_TASKS = 32;
       List<MyTask> threadList = new ArrayList(NUMBER_OF_TASKS);  
       Counter cont = new Counter();
       
       for(int i=1; i<=NUMBER_OF_TASKS; i++){
           MyTask t = new MyTask(cont);
           threadList.add(t);
           t.start();
       }
       
       Iterator<MyTask> i = threadList.iterator();
        
        while(i.hasNext()){
        
            MyTask t = i.next();
           
             while (t.isAlive()){
            }
         }
        
        System.out.println("Contador = " + cont.getCounter());
        System.out.println("El programa ha terminado");
    }
}
