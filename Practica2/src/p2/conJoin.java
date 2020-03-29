package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author david
 * 
 * Apartado D) No funciona igual porque isAlive() espera a que todos los hilos.
 *             Sin embargo, con join() tenemos que hasta que un hilo no acabe su
 *             ejecución, no se podrá ejecutar el siguiente y así hasta que terminen todos.
 *             
 *             No afecta a los subprocesos en ejecución porque lo único que hace es
 *             esperar a que termine cada uno por separado.
 */
public class conJoin {
    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 32;
        List<Thread> threadList = new ArrayList<Thread>(NUMBER_OF_THREADS);
        
        for(int i=1; i<=NUMBER_OF_THREADS; ++i){
            Thread t = new Thread(new MyRunnable());
            threadList.add(t);
            t.start();
            System.out.println("Thread [" + i + "]");
        }
        System.out.println("El programa ha terminado");

            
        Iterator<Thread> i = threadList.iterator();
        
        while (i.hasNext()) {
            Thread t = i.next();
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Thread " + t.getName() + " interrumpido");
            }
        }
        System.out.print("El programa ha terminado realmente");
    }
}
