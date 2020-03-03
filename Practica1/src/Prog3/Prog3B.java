package Prog3;

/**
 *
 * @author david
 */

/**
 * En este ejemplo tenemos dos hilos, uno que implementa Runnable (El hilo hijo)
 * y el hilo principal creado en el main (main thread). 
 * 
 * En las computadoras de un solo núcleo los dos hilos se van turnando para compartir
 * el uso de la CPU. Si se ejecuta el hilo hijo, el hilo principal es interrumpido
 * y viceversa.
 * 
 * Cada vez que uno de los hilos se duerme por el metodo sleep(), el otro hilo 
 * se hace con los recursos de la cpu.
 */
class NewThread implements Runnable {
    Thread t;
    NewThread() {
    t= new Thread(this, "Demo Thread");
    System.out.println("Child thread: " + t);
    }
    public void run() {
    try {
        for(int i=5; i>0; i--) {
            System.out.println("Child Thread " + i);
            Thread.sleep(1000);
        }
    } catch (InterruptedException e) {
        System.out.println("Child interrupted.");
    }
        System.out.println("Exiting child thread.");
    }
}

/**
 * Cada vez que se invoca el método sleep() se duerme al hilo actual y no consume
 * ningún tiempo de procesamiento. Eso significa que ese hilo se borra a sí mismo
 * de la lista de hilos activos y el planificador no lo programa para la próxima ejecución
 * hasta que haya pasado el tiempo de sleep.
 * NOTA: El tiempo que pasa en el sleep solo es una indicación para el planificador
 * y no es un marco de tiempo exacto.
 * Podría ocurrir que el hilo llegase unos nano o milisegundos antes o después debido
 * al planificador 
 */

class Prog3B {
    public static void main(String args[]) {
    NewThread nt = new NewThread();
    nt.t.start();
    try {
        for (int i=5; i>0; i--){
            System.out.println("Main Thread: " +i );
            Thread.sleep(500);
        }
    } catch (InterruptedException e){
    System.out.println("Main thread interrupted");
    }
    System.out.println("Main thread Exiting");
    }
} 
