package Synchronized;

/**
 *
 * @author david
 */
class TransThread extends Thread {

    private FinTrans ft;

    TransThread(FinTrans ft, String name) {
        super(name); // Save thread's name
        this.ft = ft; // Save reference to financial transaction object
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (getName().equals("Deposit")) {
                // Start of deposit thread's critical code section
                synchronized(ft){   
                    ft.transName = "Deposit";
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                    ft.amount = 2000.0;
                    System.out.println(ft.transName + " " + ft.amount);
                }
                // End of deposit thread's critical code section
            } else {
                // Start of withdrawal thread's critical code section
                synchronized(ft){
                    ft.transName = "Withdrawal";
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                    ft.amount = 250.0;
                    System.out.println(ft.transName + " " + ft.amount);
                }
                // End of withdrawal thread's critical code section
            }
        }
    }
}
