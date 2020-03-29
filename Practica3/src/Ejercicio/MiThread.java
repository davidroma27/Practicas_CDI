package Ejercicio;

/**
 *
 * @author david
 */
class MiThread implements Runnable{
    private Integer miSuma=0;
    
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Started thread [" + Thread.currentThread().getId() + "], suma=" + miSuma);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread [" + Thread.currentThread().getName() + "] interrupted");
            } 
            miSuma++;
        }
        
        System.out.println("Finished [" + Thread.currentThread().getId() + "], suma=" + miSuma);
    }
}


