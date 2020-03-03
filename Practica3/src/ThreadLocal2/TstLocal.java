package ThreadLocal2;

/**
 * 
 * @author david
 */
class TstLocal {

    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
        }
    }
}