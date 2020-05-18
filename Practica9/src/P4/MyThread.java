package P4;

/**
 *
 * @author david
 */
class MyThread implements Runnable {

    String name;
    int fact;

    MyThread(String n, int f) {
        name = n;
        fact = f;
    }

    public void run() {
        int result = fact;
        int factorial = fact;   
        
            // Si el numero es 0 o 1, devolver 1
        if ((fact == 0) || (fact == 1)) {
            result = 1;
        } else {
            // Else, calcular la factorial
            while(fact != 1){
                fact--;
                result = result * fact;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("El factorial de " + factorial + " es: " + result);
        
    } //fin run()
}
