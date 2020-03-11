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
public class FinTrans {
    private String transName;
    private double amount;

    synchronized void update(String transName, double amount) {
        this.transName = transName;
        this.amount = amount;
        System.out.println(this.transName + " " + this.amount);
    }

}
