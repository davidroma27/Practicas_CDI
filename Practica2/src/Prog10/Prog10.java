/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog10;

/**
 *
 * @author david
 */
import java.io.File;
import java.util.concurrent.TimeUnit;

class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath); //se pone en el path inicial
        if (file.isDirectory()) { //si es un directorio y tiene subdirectorios seguimos buscando
            
            try { //Dentro del run se captura las excepciones que lancen los metodos auxiliares
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
                cleanResources();
            }
        }
    }

    private void cleanResources() {
    }

    //si hay archivos se va comprobando si coincide con el buscado
    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        //Se comprueba si hay un pedido de interrupcion
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        //Se comprueba si hay un pedido de interrupcion
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}


public class Prog10 {
    //searches for a file in subfolders; then interrupts the thread.

    public static void main(String[] args) {
        // Creates the Runnable object and the Thread to run it
        FileSearch searcher; 
        //searcher = new FileSearch("D:\\UNIVERSIDAD\\3º\\CDI", "Lab01B_First_threads.pdf");
        searcher = new FileSearch("D:\\UNIVERSIDAD\\1º\\AEDI\\Practicas\\Est_Enlazadas\\src\\Est_Circular", "Nodo.java");
        
        //creamos el hilo con la tarea de buscar el archivo
        Thread thread = new Thread(searcher);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}