package Ejercicio;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiProblema {

    public static void main(String[] args) {
        final int NUMERO_THREADS = 32;
        List<Thread> threadList = new ArrayList<Thread>(NUMERO_THREADS);
        
        //Bucle que crea los 32 hilos y los añade al arraylist
        for (int i = 1; i <= NUMERO_THREADS; ++i) {
            Thread miThread = new Thread(new MiThread());
            threadList.add(miThread);
        }
        
        Iterator<Thread> l1 = threadList.iterator();
        while (l1.hasNext()) {
            l1.next().start();
        }
//        while (l1.hasNext()) {
//            Thread t = l1.next();
//            try {
//                t.join();
//                System.out.println("Terminado realmente " + t.getName());
//            } catch (InterruptedException e) {
//                System.out.println("Error");
//            }
//        }
        System.out.println("El programa ha terminado");
    }
}
