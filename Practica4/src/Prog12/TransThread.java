/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prog12;

/**
 *
 * @author david
 */
public class TransThread extends Thread{
    private FinTrans ft;

    TransThread(FinTrans ft, String name) {
        super(name); // Save thread's name
        this.ft = ft; // Save reference to financial transaction object
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (getName().equals("Deposit Thread")) {
                ft.update("Deposit", 2000.0);
            } else {
                ft.update("Withdrawal", 250.0);
            }
        }
    }

}
