package servers;
/**
 *Bibliotecas necesarias para la conexion mediante socket y para la creacion del objeto tipo <code>Producto</code>
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/**
 * Clase que permite la conexion con el otro computador y la manipulacion del archivo que se envia
 *  @author Abdelfatah Tarek, Alvarado Freddy, Bravo Dayanna, Meza Jhon.
 *  @since 5 de septiembre del 2022
 *  @version 1.0.0.0
 */
public class cliente {
    /**
     * Metodo main principal que permite la conexion y el manejo de datos a enviar.
     * @param args parametro por defecto
     * @throws IOException excepcion para el manejo de erres de entrada y salida
     */
    public static void main(String[] args) throws IOException {

        Socket connection = new Socket("192.168.0.107", 45);
        System.out.println("conectado: "+connection.toString());
        OutputStream out = connection.getOutputStream();


        String ruta = "C:\\Users\\jhon_\\Desktop\\prueba1.txt";

        FileInputStream fileToSend = new FileInputStream(ruta);
        InputStream fileStream = new BufferedInputStream(fileToSend);
        copyStream(fileStream, out);
    }

    /**
     * Metodo para pasar el archivo de inputStream a outputStream
     * @param fileStream parametro de InputStream
     * @param out parametro de OutputStream
     * @throws IOException
     */
    private static void copyStream(InputStream fileStream, OutputStream out) throws IOException {
        fileStream.transferTo(out);
    }
}