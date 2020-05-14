/**
 * Sincroniza dos operaciones, escribir y leer que son utilizadas por los hilos
 * productor y consumidor
 */
package P4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author david
 * 
 * 
 */
public class Buffer {

    //Creamos una lista enlazada que actuará como buffer y le asignamos un tamaño
    public static final Integer SIZE = 10;
    private List<Integer> buffer = new ArrayList(SIZE);
    private Integer num;
    
    private Semaphore s1;
    private Semaphore s2;
    //private MySemaphore s1;
    //private MySemaphore s2;
    
    public Buffer(){
        //s1 = new MySemaphore(1);
        //s2 = new MySemaphore(0);
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
    }
    
    //Añade un valor nuevo al buffer cada vez que el PRODUCTOR llama a esta función
    void write() throws InterruptedException {

        try {
            while (buffer.size() == SIZE) {
                System.out.println("BUFFER LLENO");
                //s1.down();
                s1.acquire();
            }
            num = (int) (Math.random() * 100);
            buffer.add(num);
            System.out.println("El productor ha añadido: " + num);
            //s2.up();
            s2.release();
        }catch(InterruptedException e){
            System.err.println("Error");
        }
        
    }

    //Obtiene un valor nuevo del buffer cada que el CONSUMIDOR llama a esta función
    void read() throws InterruptedException {
        int cont = 0;
        try {
            
            while (buffer.isEmpty()) {
                while (cont <= 1) {
                    System.out.println("BUFFER VACIO");
                    //s2.down();
                    s2.acquire();
                    cont++;
                }
            }
            buffer.remove(num);
            System.out.println("El consumidor a leído: " + num);
            //s1.up();
            s1.release();

        } catch (InterruptedException e) {
            System.err.println("Error");
        }
    }
}
