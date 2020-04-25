/**
 * Sincroniza dos operaciones, escribir y leer que son utilizadas por los hilos
 * productor y consumidor
 */
package P4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

/**
 * @author david
 * 
 * Apartado B) El deadlock se produce en el momento que un hilo tiene que esperar
 *             a que otro thread termine su ejecución para poder usar el mismo recurso. 
 */
public class Buffer {

    //Creamos una lista enlazada que actuará como buffer y le asignamos un tamaño
    public static final Integer SIZE = 10;
    private List<Integer> buffer = new ArrayList(SIZE);
    private Integer num;
    
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    
    //Añade un valor nuevo al buffer cada vez que el PRODUCTOR llama a esta función
    void write() throws InterruptedException {
        lock.lock();

        try {
            while (buffer.size() == SIZE) {
                notFull.await();
            }
            num = (int) (Math.random() * 100);
            buffer.add(num);
            System.out.println("El productor ha añadido: " + num);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    //Obtiene un valor nuevo del buffer cada que el CONSUMIDOR llama a esta función
    void read() throws InterruptedException {
        lock.lock();

        try {
            while (buffer.isEmpty()) {
                notFull.await();
            }
            buffer.remove(num);
            System.out.println("El consumidor a leído: " + num);
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }
}
