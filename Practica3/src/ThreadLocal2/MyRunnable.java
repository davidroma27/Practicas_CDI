/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadLocal2;

class MyRunnable implements Runnable {

    ThreadLocal<Integer> tL = new ThreadLocal<Integer>();

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            final int thread = i;
            tL.set(thread);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.printf("%s %d\n", Thread.currentThread().getName(), tL.get());

        }
    }
}