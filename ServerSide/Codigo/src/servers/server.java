package servers;
/**
 *Bibliotecas necesarias para la conexion mediante socket y para la creacion del objeto tipo <code>Producto</code>
 */
import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que permite la conexion con el otro computador y la manipulacion del archivo que se recibe conviertiendolo
 * a un objeto de tipo <code>Producto</code> que lo alamacena en un ArrayList
 * @author Abdelfatah Tarek, Alvarado Freddy, Bravo Dayanna, Meza Jhon.
 * @since 5 de septiembre del 2022
 * @version 1.0.0.0
 */
public class server {
    /** Campo que alamacena en un arreglo de objetos <code>Producto</code> el vaor del parametro <code>productos</code>*/
    public static ArrayList<Producto> productos = new ArrayList<Producto>();

    /**
     * Metodo main principal que permite la conexion y el manejo de datos recividos mediante el socket
     * @param args parametro por defecto
     * @throws IOException excepcion para manejo de errores de entrada y salida
     */
    public static void main(String[] args) throws IOException{

        ServerSocket serverSoc = new ServerSocket(45);
        Socket connection;
        System.out.println("Esperando conexion: ");
        connection= serverSoc.accept();
        System.out.println("Conexion con: "+connection.toString());

        JTextArea bckn1 = new JTextArea();
        if(connection.isConnected()) {
            System.out.println("hello");
            Scanner in = new Scanner(connection.getInputStream());
            while(in.hasNext()){

                String nombre= in.next();
                double precio= in.nextDouble();
                boolean iva= in.nextBoolean();
                String tipo = in.next();
                int cantidad = in.nextInt();
                productos.add(new Producto(nombre,precio,iva,tipo,cantidad));
            }
            for(Producto i: productos)
                System.out.println(i.imprimirPruducto());
        }
        StringBuilder texto = new StringBuilder();
        for (int i=0; i<4;i++){
            texto.append(productos.get(i).imprimirPruducto());

        }


        Interfaz cuadro1= new Interfaz(texto.toString());
        cuadro1.setBounds(0,0,675,520);
        cuadro1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadro1.setVisible(true);



    }
}