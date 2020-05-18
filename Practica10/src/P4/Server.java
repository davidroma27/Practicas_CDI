package P4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david
 */
class Server extends Thread {

    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    Matriz matriz;

    public void run() {
        matriz = new Matriz();
        try {
            //Creamos el server en el puerto 4444
            ServerSocket server = new ServerSocket(4444);
            //Mientras haya fragmentos por procesar, envia fragmentos a los clientes
            while (!matriz.getSegments().isEmpty()) {
                //Establece la conexión
                socket = server.accept(); 
                
                oos = new ObjectOutputStream(socket.getOutputStream());
                //Obtenemos un segmento y lo enviamos al cliente
                oos.writeObject(matriz.getSegment());
                
                //Almacenamos el fragmento procesado recibido del cliente
                ois = new ObjectInputStream(socket.getInputStream());
                Segment segmentFiltered = (Segment) ois.readObject();
                System.out.println("Server received: Segment filtered");
                
                //Escribimos el fragmento procesado en la matriz
                matriz.setDestino(segmentFiltered);

                //Cerramos conexiones
                ois.close();
                oos.close();
                socket.close();
            }
            //Escribimos la imagen procesada
            matriz.writeImage();
            System.out.println("***** Result image done *****");
            System.out.println("Program of exercise P4 has terminated");

        } catch (Exception e) {
        }
    }
}
