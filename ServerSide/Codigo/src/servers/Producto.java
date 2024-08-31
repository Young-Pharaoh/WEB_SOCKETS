package servers;
/**
 * Clase del tipo <code>Producto</code> que nos permite manipular y generar objetos
 * @author Abdelfatah Tarek, Alvarado Freddy, Bravo Dayanna, Meza Jhon.
 * @since 5 de septiembre del 2022
 * @version 1.0.0.0
 */
public class Producto {
    /**Campo que almacena en un formato Static int el valor del parametro <code>idStatic</code>*/
    public static int idStatic=1;
    /**Campo que almacena en un formato int el valor del parametro <code>id</code>*/
    private int id;
    /**Campo que almacena en un formato String el valor del parametro <code>nombre</code>*/
    private String nombre;
    /**Campo que almacena en un formato double el valor del parametro <code>precio</code>*/
    private double precio;
    /**Campo que almacena en un formato boolean el valor del parametro <code>iva</code>*/
    private boolean iva;
    /**Campo que almacena en un formato double el valor del parametro <code>ivaValor</code>*/
    private double ivaValor=0;
    /**Campo que almacena en un formato String el valor del parametro <code>tipoProducto</code>*/
    private String tipoProducto;
    /**Campo que almacena en un formato int el valor del parametro <code>cantidad</code>*/
    private int cantidad = 0;
    /**Campo que almacena en un formato int el valor del parametro <code>cantidadDisponible</code>*/
    private int cantidadDisponible;


//    constructores

    /**
     * Funcion constructora que permite instanciar objetos del tipo <code>Producto</code>
     * El objeto será creado con un String nombre, un double precio, un boolean iva, un string tipoProducto y un int cantidadDisponible.
     * @param nombre inicia el valor de <code> nombre </code> ingresado por el administrador
     * @param precio inicia el valor de <code> precio </code> ingresado por el administrador
     * @param iva inicia el valor de <code> iva </code> ingresado por el administrador
     * @param tipoProducto inicia el valor de <code> tipoProducto </code> ingresado por el administrador
     * @param cantidadDisponible inicia el valor de <code> cantidadDisponible </code> ingresado por el administrador
     */
    public Producto(String nombre, double precio, boolean iva, String tipoProducto, int cantidadDisponible) {
        id=idStatic;
        idStatic++;
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
        this.ivaValor = 0;
        this.tipoProducto = tipoProducto;
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Funcion que permite imprimir el Producto
     * @return el objeto como un campo con nombre, precio, ivaValor, tipo de producto y cantidad disponible
     */
    public String imprimirPruducto(){
        return ("Producto: \nNombre: "+this.nombre+"\nPrecio: "+this.precio+"\nIva: "+this.ivaValor+"\nTipo de producto: "+ this.tipoProducto+"\nCantidad Disponible: "+this.cantidadDisponible+"\n\n");
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> nombre </code>
     * @return valor asignado para el campo <code> nombre </code>
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> nombre </code>
     * @param nombre valor ingresado desde el usuario para modificar el campo <code> nombre </code>
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> precio </code>
     * @return valor asignado para el campo <code> precio </code>
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> precio </code>
     * @param precio valor ingresado desde el usuario para modificar el campo <code> precio </code>
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> iva </code>
     * @return valor asignado para el campo <code> iva </code>
     */
    public boolean isIva() {
        return iva;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> iva </code>
     * @param iva valor ingresado desde el usuario para modificar el campo <code> iva </code>
     */

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> valor </code>
     * @return valor asignado para el campo <code> valor </code>
     */
    public double getIvaValor() {
        return ivaValor;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> ivaValor </code>
     * @param ivaValor valor ingresado desde el usuario para modificar el campo <code> ivaValor </code>
     */

    public void setIvaValor(double ivaValor) {
        this.ivaValor = ivaValor;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> producto </code>
     * @return valor asignado para el campo <code> producto </code>
     */
    public String getTipoProducto() {
        return tipoProducto;
    }
    /**
     * Funcion que permite asignar un nuevo valor para <code> tipoProducto </code>
     * @param tipoProducto valor ingresado desde el usuario para modificar el campo <code> tipoProducto </code>
     */

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> cantidad </code>
     * @return valor asignado para el campo <code> cantidad </code>
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Funcion que permite solicitar y retornar el valor de <code> cantidadDisponible </code>
     * @return valor asignado para el campo <code> cantidadDisponible </code>
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> cantidadDisponible </code>
     * @param cantidadDisponible valor ingresado desde el usuario para modificar el campo <code> cantidadDisponible </code>
     */

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Funcion que permite asignar un nuevo valor para <code> cantidad </code>
     * @param cantidad valor ingresado desde el usuario para modificar el campo <code> cantidad </code>
     */

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Funcion que permite solicitar y retornar los valores  de <code> nombre </code>, <code>cantidad</code>, <code>precio</code>
     * @return valores asignado para los campos <code> nombre </code>, <code>cantidad</code>, <code>precio</code>
     */
    public String sendText(){
        return (this.nombre +  "\t" + this.cantidad + "\t " + this.precio + "\n \t \t \t \t \n");
    }
}