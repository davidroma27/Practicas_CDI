/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;
/**
 *
 * @author david
 */
public class ThreadInterrupt extends Thread{
    boolean negative;
    double pi;
    
    public void run(){
        try {
            calculaPi();
        } catch (InterruptedException e) {
            System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName() + "\n");
        }
    }
    
    private void calculaPi() throws InterruptedException {
         pi = 0.0;
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 3; i < 100000; i += 2) {
                if (negative) {
                    pi -= (1.0 / i);
                } else {
                    pi += (1.0 / i);
                }
                negative = !negative;
            }
            pi += 1.0;
            pi *= 4.0;
        }
        System.out.println(pi);
    }
    
}
