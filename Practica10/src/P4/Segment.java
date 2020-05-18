package P4;

import java.io.Serializable;

/**
 *
 * @author david
 */
class Segment implements Serializable {

    int[][] segment;
    int initRow;
    int initCol;

    public Segment(int[][] seg, int iRow, int iCol) {
        this.segment = seg;
        this.initRow = iRow;
        this.initCol = iCol;
    }

    public void print() {
        System.out.println("Inicio (" + initRow + ", " + initCol + ").");
        for (int i = 0; i < segment.length; i++) {
            for (int j = 0; j < segment.length; j++) {
                System.out.print(segment[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public int getInitRow() {
        return initRow;
    }

    public int getInitCol() {
        return initCol;
    }

    public int[][] getSegment() {
        return segment;
    }

    public int length() {
        return segment.length;
    }

}

