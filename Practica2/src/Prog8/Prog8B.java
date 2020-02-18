/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog8;

/**
 *
 * @author david
 */
class Prog8 {

    public static void main(String[] args) throws InterruptedException {
// Thread priority infomation - Las prioridades van de 1 a 10, min-max
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);
        Thread threads[]; //un array para los threads
        Thread.State status[]; //un array para los estados
        
        // 10 threads do work, 5 with the max priority
        // 5 with the min priority
        threads = new Thread[10];
        status = new Thread.State[10];
        
        //A cada posicion del array se le añade un thread y una prioridad
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }
        
        //pide los estados de cada hilo sin haberlos arrancado aun
        for (int i = 0; i < 10; i++) {
            System.out.println("Main : Status of Thread " + i + " : " + threads[i].getState());
            status[i] = threads[i].getState();
        }
        
        //arrancamos los hilos
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        
        // Wait for the finalization of the threads. We save the status of
        // the threads and only write the status if it changes.
        boolean finish = false;
        
        //Se ejectua el bucle hasta que el estado de todos los threads es TERMINATED
        while (!finish) {
            //recorre el array y pregunta cual es el estado actual y lo contrasta con el que tenia antes
            //si el estado cambio lo actualizamos
            for (int i = 0; i < 10; i++) {
                if (threads[i].getState() != status[i]) {
                    writeThreadInfo(threads[i], status[i]);
                    status[i] = threads[i].getState();
                }
            }
            finish = true;
            //Cuando el estado de todos los threads es TERMINATED se acaba el bucle
            //Mientras no hayan acabado todos se sigue ejecutando el metodo de prints
            for (int i = 0; i < 10; i++) {
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }

    //Creamos el metodo que devuelva toda la informacion de los threads 
    private static void writeThreadInfo(Thread thread, Thread.State state) {
        System.out.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        System.out.printf("Main : Priority: %d\n", thread.getPriority());
        System.out.printf("Main : Old State: %s\n", state);
        System.out.printf("Main : New State: %s\n", thread.getState());
        System.out.printf("Main : ************************************\n");
    
    }
}