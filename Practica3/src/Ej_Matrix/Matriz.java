package Ej_Matrix;

import java.util.Random;
import java.util.*;
import java.io.Serializable;

public class Matriz implements Serializable {

    private final int dimension;
    private int segmentNumber = 0;
    private int[][] matrix;
    private Long tiempo = (long) 0;

    public Matriz(Integer d) {
        dimension = d;
        matrix = new int[dimension][dimension];
        Random rand = new Random();
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                //matrix[i][j] = rand.nextInt(10);
                matrix[i][j] = i * j;
            }
        }
    }
    
        
    public static Matriz SimpleFilter(Matriz A) {
        Matriz aux = new Matriz(A.dimension);
        int d = A.dimension;
        int[][] matA = A.matrix;
        int[][] matAux = aux.matrix;
        //System.out.println(A.toString());
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
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
                matAux[i][j] = (int) (sumIJ / 9.);
                System.out.printf(" %s ", matAux[i][j]);
            }
            System.out.println();
        }
        aux.setMatrix(matAux);
        return aux;
    }


    // methods for use in threads:
    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getDim() {
        return dimension;
    }

    public void setSegmentNumber(int segnum) {
        this.segmentNumber = segnum;
    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                ret += matrix[i][j] + " ";
            }
            ret += "\n";
        }
        return ret;
    }

    public String ROItoString(int roi) {
        String ret = "";
        for (int i = 0; i < roi; i++) {
            for (int j = 0; j < roi; j++) {
                ret += matrix[i][j] + " ";
            }
            ret += "\n";
        }
        return ret;
    }

    public void setROI(int segment, int[][] data) {
        for (int i = 0; i < (int) dimension / 2; i++) {
            for (int j = 0; j < (int) dimension / 2; j++) {
                if (segment == 1) {
                    matrix[i][j] = data[i][j];
                } else if (segment == 2) {
                    matrix[i][j + ((int) dimension / 2)] = data[i][j];
                } else if (segment == 3) {
                    matrix[i + ((int) dimension / 2)][j] = data[i][j];
                } else if (segment == 4) {
                    matrix[i + ((int) dimension / 2)][j + ((int) dimension / 2)] = data[i][j];
                }
            }
        }

    }

    public int[][] getSplitRegion(int segment) {
        int[][] dat = new int[(int) (dimension / 2) + 2][(int) (dimension / 2) + 2];
        for (int i = 0; i < (int) dimension / 2; i++) {
            for (int j = 0; j < (int) dimension / 2; j++) {
                if (segment == 1) {
                    dat[i][j] = matrix[i][j];
                } else if (segment == 2) {
                    dat[i][j] = matrix[i][j + ((int) dimension / 2)];
                } else if (segment == 3) {
                    dat[i][j] = matrix[i + ((int) dimension / 2)][j];
                } else if (segment == 4) {
                    dat[i][j] = matrix[i + ((int) dimension / 2)][j + ((int) dimension / 2)];
                }
            }
        }

        return dat;
    }
}
