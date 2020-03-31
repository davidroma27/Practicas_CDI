package p5_2;

/**
 * @author david
 * 
 * APARTADO C) Cuando todos los hilos han finalizado, el contador termina en 0 de modo
 *             que ya no se permiten más accesos a la sección crítica por parte de
 *             los hilos.
 *             En el caso de que haya más hilos que accesos permitidos a memoria,
 *             si el contador llega a 0, el método isFinished() devuelve TRUE y por
 *             lo tanto se termina la ejecución de todos los hilos.
 * 
 */
public class p5 {
    public static void main(String[] args) {
        int cont = 20;
        final int N_THREADS = 10;
        int nh=N_THREADS;
        ClassA a = new ClassA(cont);
        ClassB b[] = new ClassB[nh];
        //Thread t[] = new Thread[N_THREADS];
        
        for(int i=0; i<nh; i++){
            b[i] = new ClassB(i,a);
            //t[i] = new Thread(b[i]);
            b[i].start();
        }
        
        while(!a.isFinished());
        try {
            for (int i = 0; i < nh; i++) {
                b[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Counter = " + a.getCounter());
        System.out.println("Finished");
    }
    
}
