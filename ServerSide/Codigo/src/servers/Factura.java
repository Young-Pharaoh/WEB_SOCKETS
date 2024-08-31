package servers;
/** Bibliotecas necesarias para el funcionamiento de un objeto de tipo <code>Factura</code> */
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase usado para generar y calcular la Factura final que va a recevir el usuario.
 * @author Abdelfatah Tarek, Alvarado Freddy, Bravo Dayanna, Meza Jhon.
 * @since 5 de septiembre del 2022
 * @version 1.0.0.0
 */
public class Factura {
    /**Compo que almacena en un formato int el valor del parametro <code>idStatic</code>*/
    public static int idStatic=1;
    /**Compo que almacena en un formato int el valor del parametro <code>id</code>*/
    public int id;
    /**Compo que almacena en un formato Date el valor del parametro <code>fecha</code>*/
    Date fecha= new Date();
    /**Compo que almacena en un arreglo de objetos <code>Producto</code> el valor del parametro <code>productos</code>*/
    private ArrayList<Producto> productos = new ArrayList<>();
    /**Compo que almacena en un formato double el valor del parametro <code>precioTotal</code>*/
    private double precioTotal = 0;

    /**
     * Funcion constructor me permite instanciar objetos del tipo <code> Factura</code>
     * El objeto sera creado con un objeto String codigo, un String nombre y un Arraylist vacio
     * @param productos inicia el valor de <code> productos </code> ingresado por el administrador
     */
    public Factura(ArrayList<Producto> productos) {
        id=idStatic;
        idStatic++;
        this.productos = productos;
    }

    /**
     *Funcion que permite calcular el precio de todos los productos, cada calculo se haces independientemente del otro
     */
    public void calcularPrecio(){
        for(int i = 0; i < 4; i++){
            if(productos.get(i).isIva())
                this.productos.get(i).setIvaValor(this.productos.get(i).getPrecio()*0.12);
            this.precioTotal += this.productos.get(i).getCantidad()*(this.productos.get(i).getPrecio()+this.productos.get(i).getIvaValor());
        }
    }

    /**
     * Funcion que permite imprirmir Factura.
     * @return el objeto <code>str.toString</code>
     */
    public String imprimirFactura(){
        calcularPrecio();
        StringBuilder str = new StringBuilder();
        str.append("Fecha: "+this.fecha + "\n");
        str.append("------------------------------------------ \n");

        str.append(this.id + "\n");
        str.append("------------------------------------------ \n");
        str.append("Factura No: " + this.id + '\n');
        str.append("Producto \t \t Precio \t Cantidad \t Precio Total \n");
        str.append(productos.get(0).getNombre() + "\t \t" + productos.get(0).getPrecio() + "\t " + productos.get(0).getCantidad() + "\t" + productos.get(0).getCantidad()* (productos.get(0).getPrecio()+productos.get(0).getIvaValor()) + '\n');
        str.append(productos.get(1).getNombre() + "\t \t" + productos.get(1).getPrecio() + "\t " + productos.get(1).getCantidad() + "\t" + productos.get(1).getCantidad()* (productos.get(1).getPrecio()+productos.get(1).getIvaValor()) + '\n');
        str.append(productos.get(2).getNombre() + "\t \t" + productos.get(2).getPrecio() + "\t " + productos.get(2).getCantidad() + "\t" + productos.get(2).getCantidad()* (productos.get(2).getPrecio()+productos.get(2).getIvaValor()) + '\n');
        str.append(productos.get(3).getNombre() + "\t \t " + productos.get(3).getPrecio() + "\t " + productos.get(3).getCantidad() + "\t" + productos.get(3).getCantidad()* (productos.get(3).getPrecio()+productos.get(3).getIvaValor()) + '\n');
        str.append("El total a pagar es : "+this.precioTotal + '\n');
        return str.toString();
    }
}
