package P4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @author david
 */
public class P4 {
    
    /**
     * Después de apagar el Executor, ¿qué sucede si intenta ejecutar un nueva tarea?
     * 
     * Al intentar ejecutar una nueva tarea o volver a ejecutar una tarea que ya existía,
     * se lanzará la excepción RejectedExecutionException ya que en cuanto se ejecuta el
     * método shutdown() no se acepta niguna tarea más y rechazará todas las tareas que se intenten
     * ejecutar despues del shutdown.
     */
   
    public static void main(String[] args) throws InterruptedException {
        //Lanzamos el Executor con el numero de procesadores disponible
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        int r1 = (int) (Math.random() * 10);
        int r2 = (int) (Math.random() * 10);
        int r3 = (int) (Math.random() * 10);
        int r4 = (int) (Math.random() * 10);

        while(!pool.isShutdown()){
            pool.execute(new MyThread("T1", r1));
            pool.execute(new MyThread("T2", r2));
            pool.execute(new MyThread("T3", r3));
            pool.execute(new MyThread("T4", r4));
            
            pool.shutdown();
                        
            System.out.println("Done");
            //pool.execute(new MyThread("T1", r1)); Lanza excepción de ejecución rechazada
        }
    }
    
}
