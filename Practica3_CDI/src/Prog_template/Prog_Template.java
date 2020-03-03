package Prog_template;

import java.util.ArrayList;
import java.util.List;

/**
 * A partir de ahora se creará una clase para el hilo main (esta) y los demás hilos
 * se crearan en otra clase distinta
 */

public class Prog_Template {

    public static void main(String[] args) {
        final int NUMBER_THREADS = 20;
        double a = Math.atan(12.3);
        List<Thread> threadList = new ArrayList<Thread>(NUMBER_THREADS);
        // Code given previously to launch & join threads

        System.out.println("The program is Finished!");
    }
}
