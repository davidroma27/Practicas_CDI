package ThreadLocal;

class MyRunnable implements Runnable {
    //Tenemos un thread local sobre un integer
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    

    /**
     * Si ejecutamos el programa sin el thread local en cada print para el mismo thread
     * generara numeros aleatorios distintos.
     * threadLocal lo que hace es mantener siempre el mismo valor para cada hilo y
     * que no se pise.
     */
    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
            System.out.println(threadLocal.get());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
    }
}
