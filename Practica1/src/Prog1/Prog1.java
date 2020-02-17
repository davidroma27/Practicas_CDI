/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog1;

/**
 *
 * @author david
 */
public class Prog1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //currentThread() -> Indica el hilo en el que estoy ahora mismo
        long id = Thread.currentThread().getId();
        //getName() -> Le damos un nombre al thread actual
        String name = Thread.currentThread().getName();
        //getPriority() -> Obtenemos la prioridad del hilo actual
        int priority = Thread.currentThread().getPriority();
        //getState() -> Para saber el estado del thread: Si esta activo, dormido, etc...
        Thread.State state = Thread.currentThread().getState();
        //getThreadGroup() -> Se pueden crear grupos de hilos
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        //isAlive() -> Informa de si el hilo está en ejecución
        boolean alive = Thread.currentThread().isAlive();
        
        for (int i = 0; i <= 2; i++) {
            // Pause for 2 seconds
            try {
                
                Thread.sleep(2000);
                System.out.println("Hilo durmiendo");
               
            } catch (InterruptedException e) {
                // We've been interrupted: no more messages.
                return;
            }
            // Print a message
            System.out.println("Hilo en ejecución");
        }
        
        System.out.println("id="+id+"; name="+name+"; priority="
            +priority+"; state="+state+"; threadGroupName="
            +threadGroupName + "; isAlive=" + alive);
    }
    
}
