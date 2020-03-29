package p3;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Apartado B) Cuando usamos una variable privada en bucles que iteran repetidas
 *             veces, obtenemos que la misma variable se sobreescribe continuamente
 *             por cada hilo que se va ejecutando. Esto se debe a que los atributos
 *             son compartidos ya sea para los objetos o para los hilos que los esten
 *             usando.
 *             Por lo tanto, aunque podamos ver que cada hilo devuelve el mismo valor,
 *             en realidad tienen valores distintos porque la referencia a THIS es 
 *             distinta para cada uno.
 * 
 * Apartado D) Se puede observar como cada thread devuelve un resultado distinto al
 *             del resto de threads. Cada hilo no se interrumpe inmediatamente. Esto
 *             es debido al bucle while(!Thread.currentThread().isInterrupted()) que
 *             impide que un thread sea interrumpido por la funcion interrupt() mientras
 *             esté trabajando.
 */

public class MiProblema {

    public static void main(String[] args) {
        final int NUMBER_OF_THREADS = 4;

        List<MiThread> threadList = new ArrayList<MiThread>(NUMBER_OF_THREADS);

        for (int i = 1; i <= NUMBER_OF_THREADS; i++) {
            MiThread t = new MiThread("Thread " + i);
            threadList.add(t);
            t.start();
        }

        /** Apartados B) y C)
        Iterator<MiThread> i = threadList.iterator();
        while (i.hasNext()) {
            MiThread t = i.next();
            while (t.isAlive()) {

            }
        }
        */
        
        try{
            Thread.currentThread().sleep(100);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        
        Iterator<MiThread> i = threadList.iterator();
        while(i.hasNext()){
            MiThread t2 = i.next();
            t2.interrupt();
         }
       
        Iterator<MiThread> i2 = threadList.iterator();
        while(i2.hasNext()){
            MiThread t2 = i2.next();
             while (t2.isAlive()){ 
            }
         }
        
        System.out.println("El programa ha terminado");
    }
}

