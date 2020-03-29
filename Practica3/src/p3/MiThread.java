package p3;

/**
 *
 * @author david
 */
public class MiThread extends Thread {

    /** APARTADOS B) y C)
     *
    //private Integer miSuma = 0;
    private ThreadLocal<Integer> miSuma;

    MiThread(String nombre) {
        super(nombre);
        miSuma = new ThreadLocal<>();
    }

    
    public void run() {
        miSuma.set(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " , suma = " + miSuma.get());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
            //miSuma++;
            miSuma.set(miSuma.get() + 1);
        }
        System.out.println(Thread.currentThread().getName() + " , suma = " + miSuma.get());
    }
    */
    
    //Apartado D)
    private double pi; 
    private boolean negative;
 
    MiThread(String nombre){
        super(nombre);
    }
    
    public void run() {
        try {
            calculaPi();
        } catch (InterruptedException e) {
            System.out.printf("%s: The search has been interrupted \n", Thread.currentThread().getName());
        }
    }

    public void calculaPi() throws InterruptedException {
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
        
        if (Thread.interrupted()) {
            throw new InterruptedException("Thread interrupted");
        }
    }
}



