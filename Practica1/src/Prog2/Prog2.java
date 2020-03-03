package Prog2;

//En este ejemplo arrancamos un Thread desde fuera de la clase main donde se crea el hilo principal
public class Prog2 extends Thread {
    public Prog2(String name) {
        super(name);
    }
    
    @Override
    public void run() { //Metodo que muestra el hilo que se está ejecutando
                        //Este metodo se ejecuta una vez que la maquina virtual de java (JVM) arranca el hilo
        System.out.println("Executing thread " + Thread.currentThread().getName());
    }

    //Creamos el hilo mediante el constructor de la clase Thread que pasa como parametro un string que nombra al hilo.
    //Este hilo es arrancado mediante el metodo run() de la clase Thread al revés que la clase Runnable.
    public static void main(String[] args) throws InterruptedException {
        //Prog2 myThread = new Prog2("myThread"); //Creating the main Thread in main method
        (new Prog2("My Thread")).start(); //starting the thread
    }
}