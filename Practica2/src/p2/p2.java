package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author david
 * 
 * Apartado B) El resultado es la impresion de cada hilo por pantalla
 *             en función de la variable NUMBER_OF_THREADS por lo tanto se ejecutarán
 *             hilos de 1 hasta 32.
 *             Esto no quiere decir que los hilos se ejecuten de forma ordenada,
 *             eso ocurre porque nosotros lo hemos indicado en nuestro bucle for pero
 *             los threads no siguen ningun orden determinado para ejecutarse.
 */
public class p2 {
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
            while (t.isAlive()) {
                System.out.println("Esperando a que acaben los threads");
            }
        }
        System.out.print("El programa ha terminado realmente");
    }
}
