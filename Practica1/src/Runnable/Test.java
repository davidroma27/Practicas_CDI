package Runnable;

/**
 *
 * @author david
 */
/**
 * Creamos un thread y lo arrancamos mediante un Runnable.
 * La forma más facil de crear un hilo es crear una clase que implemente la 
 * interfaz Runnable.
 * Se puede construir un hilo en cualquier objeto que implemente Runnable (en este caso Test)
 * Para implementar el Runnable lo único necesario es implementar el metodo run()
 */

public class Test implements Runnable {
    /**
     * El metodo run() es implementado por la interfaz Runnable.
     * Este metodo contiene todo el código que vaya a ser ejecutado en el hilo.
     * En este caso se va a mostrar el nombre del hilo que se esta ejecutando.
     * El metodo run() puede llamar a otros métodos, usar otras clases y declarar variables,
     * del mismo modo que el hilo principal(main) tambien puede.
     * La única diferencia es que run() establece el punto de entrada para otro hilo
     */
    @Override
    public void run() {
        System.out.println("Executing thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Se crea el Thread.
         * new Test() es una instancia de una clase que implementa la interfaz Runnable.
         * Esto define dónde va a empezar la ejecución del hilo.
         * El nombre del hilo se especifica despues de crear la instancia ("myRunnable").
         */
        Thread Test = new Thread(new Test(), "myRunnable");
        Test.start();
        /**
         * Se arranca el Thread con el método start().
         * Este método inicia una llamada al método run().
         */
    }
}
