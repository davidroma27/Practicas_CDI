/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog9;

/**
 *
 * @author david
 */
//Interrupciones simples

//Este paquete se usa para tiempo en codigo concurrente
import java.util.concurrent.TimeUnit;

class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        // This bucle never ends... until is interrupted
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            // When is interrupted, write a message and ends
            //necesitamos cazar el pedido de interrupcion y dejo de devolver prints
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Prog9 {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        // Wait 5 seconds
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Interrupt the prime number generator
        task.interrupt();
        
        // Write information about the status of the Thread
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}
