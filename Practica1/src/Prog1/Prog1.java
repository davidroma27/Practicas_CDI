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
        //int priority -> Establecemos la prioridad del hilo actual
        int priority = Thread.currentThread().getPriority();
        //state -> Para saber el estado del thread: Si esta activo, caducado, etc...
        Thread.State state = Thread.currentThread().getState();
        //threadGroupName -> Se pueden crear grupos de hilos
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        
        System.out.println("id="+id+"; name="+name+"; priority="
            +priority+"; state="+state+"; threadGroupName="
            +threadGroupName);
    }
    
}
