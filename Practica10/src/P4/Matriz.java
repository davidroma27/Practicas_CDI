package P4;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.imageio.ImageIO;

/**
 *
 * @author david
 */
class Matriz {

    private static final int nSegments = 4;
    private static final String SOURCE = ".\\src\\P4\\monkey.png";
    static BufferedImage img;
    static int[][] origin;
    static int[][] result;
    Queue<Segment> segments;

    public Matriz() {
        segments = new LinkedList<Segment>();
        readImg();
        splitMatrix();
    }

    private void splitMatrix() {
        int segmentSize = origin.length / nSegments;
        int[][] segment = new int[segmentSize][segmentSize];
        int m = 0, n = 0;
        for (int i = 0; i < nSegments; i++) {
            for (int j = 0; j < nSegments; j++) {
                int filaInicio = i * segmentSize, colInicio = j * segmentSize;
                for (int k = filaInicio; k < (i + 1) * segmentSize; k++) {
                    for (int l = colInicio; l < (j + 1) * segmentSize; l++) {
                        segment[m][n++] = origin[k][l];
                    }
                    n = 0;
                    m++;
                }
                m = 0;
                segments.add(new Segment(segment, colInicio, filaInicio));
                segment = new int[segmentSize][segmentSize];
            }
        }

    }

    public Queue<Segment> getSegments() {
        return segments;
    }

    public void setDestino(Segment s) {
        int fil, col;
        fil = s.initRow;

        for (int i = 0; i < s.length(); i++) {
            col = s.getInitCol();
            for (int j = 0; j < s.length(); j++) {
                result[fil][col] = s.segment[i][j];
                col++;
            }
            fil++;

        }
    }

    private void readImg() {
        try {
            File file_in = new File(SOURCE);
            img = ImageIO.read(file_in);
            final int width = img.getWidth();
            final int height = img.getHeight();
            origin = new int[width][height];
            result = new int[width][height];

            Raster raster_in = img.getData();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    final int d = raster_in.getSample(i, j, 0);
                    origin[i][j] = d;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading image");
        }

    }

    public void writeImage() {
        final int width = img.getWidth();
        final int height = img.getHeight();
        WritableRaster raster_out = img.getRaster();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                raster_out.setSample(i, j, 0, result[i][j] / 2);
            }
        }
        img.setData(raster_out);
        File file_out = new File(".\\src\\P4\\result.png");
        try {
            ImageIO.write(img, "png", file_out);
        } catch (IOException ex) {
        }
    }

    public Segment getSegment() {
        return segments.poll();
    }

    public static void print() {
        System.out.println("Origin matrix");
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                System.out.print(origin[i][j] + "\t");
            }
            System.out.println();

        }
    }

}
