package Synchronized;

/**
 *
 * @author david
 */
public class Prog10 {
    public static void main(String[] args) {
        FinTrans ft = new FinTrans();
        TransThread tt1 = new TransThread(ft, "Deposit");
        TransThread tt2 = new TransThread(ft, "Withdrawal");
        tt1.start();
        tt2.start();
    }

}

class FinTrans{
    public static String transName;
    public static double amount;
}

