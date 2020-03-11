package Ej_Matrix;

/**
 *
 * @author david
 */
public class MyThread {
    private final Matriz A;
    private Matriz C;
    int rStart, rFinish;

    public MyThread(Matriz Abar, Matriz Cbar, int rStart, int rFinish) {
        this.A = Abar;
        this.C = Cbar;
        this.rStart = rStart;
        this.rFinish = rFinish;
    }

    public void run() {
        int[][] matA, matC;
        matA = this.A.getMatrix();
        matC = this.C.getMatrix();
        System.out.println("Printed from thread");
        int d = A.getDim();
        for (int i = 0; i < d; i++) {
            for (int j = this.rStart; j < this.rFinish; j++) {
                int sumIJ = 0;
                for (int q = -1; q <= 1; q++) {
                    for (int p = -1; p <= 1; p++) {
                        int c = i + q;
                        if (c < 0) {
                            c = -c;
                        }
                        if (c >= d) {
                            c = 2 * d - c - 1;
                        }
                        int r = j + p;
                        if (r < 0) {
                            r = -r;
                        }
                        if (r >= d) {
                            r = 2 * d - r - 1;
                        }
                        sumIJ += matA[c][r];
                    }
                }
                matC[i][j] = (int) (sumIJ / 9.);
            }
        }
        C.setMatrix(matC);
    }

}
