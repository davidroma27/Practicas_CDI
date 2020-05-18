package P4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 *
 * @author david
 */
class Client extends Thread {

    InetAddress host = null;
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    int filter;
    int denom;
    int aux[][];


    public void run() {
        try {
            for (int x = 0; x < 4; x++) {
                //Establece conexion con el servidor
                host = InetAddress.getLocalHost();
                socket = new Socket(host.getHostName(), 4444);
                
                //Recibe un segmento nuevo del servidor
                ois = new ObjectInputStream(socket.getInputStream());
                Segment message = (Segment) ois.readObject();
                System.out.println("Client received: Segment " + (x+1));
                
                //Almancenamos temporalmente el segmento recibido del servidor
                aux = new int[message.length()][message.length()];

                //Aplica el filtro al segmento
                System.out.println("Processing segment:" + (x+1) + "...");
                meanFilter(message);

                //Almacena el segmento modificado y lo reenvia al servidor
                Segment result = new Segment(aux, message.initCol, message.initRow);
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Resending segment to server...");
                oos.writeObject(result);

                //Cierra las conexiones
                ois.close();
                oos.close();
                socket.close();
            }
        } catch (Exception e) {
        }
    }

    //Filtro que tiene que aplicar el cliente en cada segment
    public void meanFilter(Segment seg) {
        int r, c, auxI, auxJ;
        int denom = (int) Math.pow(2 * this.filter + 1, 2);

        for (int j = 0; j < seg.length(); j++) {
            for (int i = 0; i < seg.length(); i++) {
                int sum = 0;
                for (int k = -this.filter; k < this.filter + 1; k++) {
                    for (int l = -this.filter; l < this.filter + 1; l++) {
                        r = i + k;
                        c = j + l;
                        
                        if (r < 0) {
                            auxI = -r;
                        } else if (r < seg.length()) {
                            auxI = r;
                        } else {
                            auxI = i - r + i;
                        }

                        if (c < 0) {
                            auxJ = -c;
                        } else if (c < seg.length()) {
                            auxJ = c;
                        } else {
                            auxJ = j - c + j;
                        }
                        sum += seg.segment[auxI][auxJ];
                    }
                }
                aux[i][j] = (int) (Math.floor(sum / (double) denom * 100) / 100);
            }
        }
    }
}