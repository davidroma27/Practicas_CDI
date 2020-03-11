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
class Prog12
{
    public static void main(String[] args) {
        /**
         * ESTE PROGRAMA NO FUNCIONA PORQUE ESTA USANDO UNA VARIABLE DE FORMA COMPARTIDA
         * SOBRE EL THIS DEL CONSTRUCTOR Y CADA THIS ES DISTINTO.
         */
        FinTrans ft = new FinTrans();
        TransThread tt1 = new TransThread(ft, "Deposit Thread");
        TransThread tt2 = new TransThread(ft, "Withdrawal Thread");
        tt1.start();
        tt2.start();
    }
}
