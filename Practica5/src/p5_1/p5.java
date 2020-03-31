package p5_1;

/**
 * @author david
 * 
 * APARTADO D)
 * El resultado de ejecutar una sección crítica sin el bloque synchronized
 * supone que todos los hilos puedan acceder a esa sección simultaneamente y como 
 * vemos en la salida del programa, antes de que el primer hilo haya terminado su
 * ejecución, el resto de hilos ya han iniciado también su trabajo.
 * 
 * APARTADO E)
 * Para resolver los problemas anteriores, introducimos un bloque synchronized en
 * la sección crítica donde todos los hilos tienen acceso a ella (en este caso, el 
 * método de la clase A EnterAndWait() que se llama en el metodo run() de la clase B).
 * Haciendo eso conseguimos que solo pueda acceder a la vez un hilo al metodo EnterAndWait()
 * y de esa forma un hilo no comenzará su ejecución hasta que el anterior haya terminado.
 */
public class p5 {
    public static void main(String[] args) {
        final int N_THREADS = 5;
        ClassA a = new ClassA();
        ClassB b[] = new ClassB[N_THREADS];
        Thread t[] = new Thread[N_THREADS];
        
        for(int i=0; i<N_THREADS; i++){
            b[i] = new ClassB(a,i);
            t[i] = new Thread(b[i]);
            t[i].start();
        }
        
        try {
            for (int i = 0; i < N_THREADS; i++) {
                t[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Finished");
    }
    
}
