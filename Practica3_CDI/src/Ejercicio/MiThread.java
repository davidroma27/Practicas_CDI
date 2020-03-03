/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

/**
 *
 * @author david
 */
class MiThread extends Thread{
    private Integer miSuma;
    MiThread t = new MiThread();
    
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Started" + t.getId() + miSuma);
        }
        
        System.out.println("Started" + t.getId() + miSuma);
    }
}
