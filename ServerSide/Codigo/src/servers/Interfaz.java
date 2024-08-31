package servers;
/**
 *Bibliotecas necesarias para la creacion y el funcionamiento de cracion de botones, labels y textAreas.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Clase <code>Interfaz</code> con extencion a <code>JFrame</code> e implementando el <code>ActionListener</code>
 * @see ActionListener
 * @see JFrame
 * @author Abdelfatah Tarek, Alvarado Freddy, Bravo Dayanna, Meza Jhon.
 * @since 5 de septiembre del 2022
 * @version 1.0.0.0
 */
public class Interfaz extends JFrame implements ActionListener {

    /**Compo que almacena en un formato JLabel las etiquetas <code>label1</code>, <code>prod1</code>, <code>prod2</code>, <code>prod3</code> y  <code>prod4</code>*/
    private JLabel label1,prod1,prod2,prod3,prod4;
    /**Compo que almacena en un formato JButton las bonotes <code>aumentraPr1</code>, <code>aumentraPr2</code>, <code>aumentraPr3</code> y <code>aumentraPr4</code>*/
    private JButton aumentraPr1, aumentraPr2, aumentraPr3, aumentraPr4;
    /**Compo que almacena en un formato JButton las bonotes <code>disminuirPr1</code>, <code>disminuirPr2</code>, <code>disminuirPr3</code> y <code>disminuirPr4</code>*/
    private JButton disminuirPr1, disminuirPr2, disminuirPr3, disminuirPr4;
    /**Compo que almacena en un formato JButton las bonotes <code>btnImprimir</code>, <code>btnComprar</code> y <code>btnLimpiare</code>*/
    private JButton btnImprimir, btnComprar, btnLimpiare;
    /**Compo que almacena en un formato JTextArea el cuadro de texto del campo <code>bckn1</code>*/
    private JTextArea bckn1;
    /**Compo que almacena en un obtejo Factura los valores del campo <code>factura</code>*/
    private Factura factura = new Factura(server.productos);

    /**
     * Funcion constructora que permite instanciar la clase <code>Interfaz</code>.
     * Este Objeto sera creado con un String texto.
     * Esta funcion tambien permite la creacion de los botones y definir sus caracteristimas
     * Esta funcion permite la definicion de las acciones que realiza cada boton
     * @param texto inicia el valor de <code> texto</code> que es ingresado por otra maquina mediante <code>server</code>
     */
    public Interfaz(String texto){
        setLayout(null);
        this.label1= new JLabel("Tienda EPN");
        label1.setBounds(250,10,150,40);

        this.aumentraPr1= new JButton("+");
        this.aumentraPr1.setBounds(350,50,43,43);
        this.prod1= new JLabel("Leche: 0");
        prod1.setBounds(400,50,150,40);
        this.disminuirPr1= new JButton("-");
        this.disminuirPr1.setBounds(510,50,40,40);

        this.aumentraPr2= new JButton("+");
        this.aumentraPr2.setBounds(350,100,43,43);
        this.prod2= new JLabel("Tomate: 0");
        prod2.setBounds(400,100,150,40);
        this.disminuirPr2= new JButton("-");
        this.disminuirPr2.setBounds(510,100,43,43);

        this.aumentraPr3= new JButton("+");
        this.aumentraPr3.setBounds(350,150,43,43);
        this.prod3= new JLabel("Papa: 0");
        prod3.setBounds(400,150,150,40);
        this.disminuirPr3= new JButton("-");
        this.disminuirPr3.setBounds(510,150,43,43);

        this.aumentraPr4= new JButton("+");
        this.aumentraPr4.setBounds(350,200,43,43);
        this.prod4= new JLabel("MosterEnergy: 0");
        prod4.setBounds(400,200,200,40);
        this.disminuirPr4= new JButton("-");
        this.disminuirPr4.setBounds(510,200,43,43);

        this.bckn1 = new JTextArea(texto);
        bckn1.setBounds(10,50,300,480);
        bckn1.setEditable(false);

        this.add(aumentraPr1);
        this.add(prod1);
        this.add(disminuirPr1);

        this.add(aumentraPr2);
        this.add(prod2);
        this.add(disminuirPr2);

        this.add(aumentraPr3);
        this.add(prod3);
        this.add(disminuirPr3);

        this.add(aumentraPr4);
        this.add(prod4);
        this.add(disminuirPr4);

        this.btnLimpiare = new JButton("Limpiar");
        this.btnLimpiare.setBounds(550,250,90,40);

        this.btnComprar = new JButton("Comprar");
        this.btnComprar.setBounds(450,250,90,40);

        this.btnImprimir = new JButton("Imprimir");
        this.btnImprimir.setBounds(350,250,90,40);

        this.add(btnComprar);
        this.add(btnImprimir);
        this.add(btnLimpiare);

        this.add(label1);
        this.add(bckn1);
        this.btnComprar.addActionListener(this);
        this.btnImprimir.addActionListener(this);
        this.btnLimpiare.addActionListener(this);

        this.aumentraPr1.addActionListener(this);
        this.disminuirPr1.addActionListener(this);

        this.aumentraPr2.addActionListener(this);
        this.disminuirPr2.addActionListener(this);

        this.aumentraPr3.addActionListener(this);
        this.disminuirPr3.addActionListener(this);

        this.aumentraPr4.addActionListener(this);
        this.disminuirPr4.addActionListener(this);
    }

    public void setBckn1(JTextArea bckn1) {
        this.bckn1 = bckn1;
    }

    /**
     * Funcion para la asignacion de las acciones de cada boton creado.
     * @param e the event to be processed Este parametro nos permite identificar el momento en el cual es precionado un boton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**Boton para aumentar la cantidad de Leche y ademas validar la cantidad disponible en stock*/
         if(e.getSource()==aumentraPr1){
            if(server.productos.get(0).getCantidadDisponible() > 0 ) {
                server.productos.get(0).setCantidad(server.productos.get(0).getCantidad() + 1);
                prod1.setText("Leche :" + server.productos.get(0).getCantidad());
                server.productos.get(0).setCantidadDisponible(server.productos.get(0).getCantidadDisponible() - 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        /**Boton para disminuir la cantidad de Leche y ademas validar que disminuyamos correctamente no menor a 0*/
        else if(e.getSource()==disminuirPr1){
            if(server.productos.get(0).getCantidad() > 0 ) {

                server.productos.get(0).setCantidad(server.productos.get(0).getCantidad() - 1);
                prod1.setText("Leche :" + server.productos.get(0).getCantidad());
                server.productos.get(0).setCantidadDisponible(server.productos.get(0).getCantidadDisponible() + 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        //pr2
        /**Boton para aumentar la cantidad de Papa y ademas validar la cantidad disponible en stock*/
        else if(e.getSource()==aumentraPr2){
            if(server.productos.get(1).getCantidadDisponible() > 0 ) {
                server.productos.get(1).setCantidad(server.productos.get(1).getCantidad() + 1);
                prod2.setText("Tomate :" + server.productos.get(1).getCantidad());
                server.productos.get(1).setCantidadDisponible(server.productos.get(1).getCantidadDisponible() - 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        /**Boton para disminuir la cantidad de Papa y ademas validar que disminuyamos correctamente no menor a 0*/
        else if(e.getSource()==disminuirPr2){
            if(server.productos.get(1).getCantidad() > 0 ) {
                server.productos.get(1).setCantidad(server.productos.get(1).getCantidad() - 1);
                prod2.setText("Tomate :" + server.productos.get(1).getCantidad());
                server.productos.get(1).setCantidadDisponible(server.productos.get(1).getCantidadDisponible() + 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        //pr3
        /**Boton para aumentar la cantidad de Tomate y ademas validar la cantidad disponible en stock*/
        else if(e.getSource()==aumentraPr3){
            if(server.productos.get(2).getCantidadDisponible() > 0 ) {
                server.productos.get(2).setCantidad(server.productos.get(2).getCantidad() + 1);
                prod3.setText("Papa :" + server.productos.get(2).getCantidad());
                server.productos.get(2).setCantidadDisponible(server.productos.get(2).getCantidadDisponible() - 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        /**Boton para disminuir la cantidad de Papa y ademas validar que disminuyamos correctamente no menor a 0*/
        else if(e.getSource()==disminuirPr3){
            if(server.productos.get(2).getCantidad() > 0 ) {

                server.productos.get(2).setCantidad(server.productos.get(2).getCantidad() - 1);
                prod3.setText("Papa :" + server.productos.get(2).getCantidad());
                server.productos.get(2).setCantidadDisponible(server.productos.get(2).getCantidadDisponible() + 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        //pr4
        /**Boton para aumentar la cantidad de Monster Energy y ademas validar la cantidad disponible en stock*/
        else if(e.getSource()==aumentraPr4){
            if(server.productos.get(3).getCantidadDisponible() > 0 ) {
                server.productos.get(3).setCantidad(server.productos.get(3).getCantidad() + 1);
                prod4.setText("MosnterEnergy: " + server.productos.get(3).getCantidad());
                server.productos.get(3).setCantidadDisponible(server.productos.get(3).getCantidadDisponible() - 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        /**Boton para disminuir la cantidad de Monster Energy y ademas validar que disminuyamos correctamente no menor a 0*/
        else if(e.getSource()==disminuirPr4){
            if(server.productos.get(3).getCantidad() > 0 ) {

                server.productos.get(3).setCantidad(server.productos.get(3).getCantidad() - 1);
                prod4.setText("MonsterEnergy: " + server.productos.get(3).getCantidad());
                server.productos.get(3).setCantidadDisponible(server.productos.get(3).getCantidadDisponible() + 1);
            }else {
                JOptionPane.showMessageDialog(null,"No hay productos disponibles.");
            }
        }
        /**
         * Buton de comprar que muestra los nombres, los precios y la cnatidad de los productos que el cliente desea comprar.
         * Se presenta esa informaicon en el parte del TextArea que esta a la izquierda.
         */
        else if(e.getSource() == btnComprar){
            StringBuilder text = new StringBuilder();
            for(int i = 0; i < 4; i++){
                if(server.productos.get(i).getCantidad() > 0)
                    text.append(server.productos.get(i).sendText());
                bckn1.setText(text.toString());
            }
        }
         /**
          * Buton Limpiar que limpia el TextArea y reajustar la cnatidad de los productos que el cliente desea comprar.
          */
        else if(e.getSource() == btnLimpiare){
            bckn1.setText("");
            for(int i = 0; i < 4; i++){
                server.productos.get(i).setCantidadDisponible(server.productos.get(i).getCantidad() + server.productos.get(i).getCantidadDisponible());
                server.productos.get(i).setCantidad(0);
            }
            prod1.setText("Leche: 0 ");
            prod2.setText("Tomate: 0");
            prod3.setText("Papa: 0");
            prod4.setText("MonsterEnergy: 0");
        }
         /**
          * Buton Imprimir que da un mensaje que tiene los datos de los preductos comprados, sus precios y el precio final a pagar
          */
        else if(e.getSource() == btnImprimir){
            JOptionPane.showMessageDialog(null,new JTextArea(factura.imprimirFactura()));
             try {
                 FileOutputStream fos = new FileOutputStream("factura.txt");
                 PrintWriter pw= new PrintWriter(fos);
                 pw.println(factura.imprimirFactura());
                 pw.close();

             } catch (FileNotFoundException ex) {
                 throw new RuntimeException(ex);
             }
             for(int i = 0; i < 4; i++)
                server.productos.get(i).setCantidad(0);
                prod1.setText("Leche: 0 ");
                prod2.setText("Tomate: 0");
                prod3.setText("Papa: 0");
                prod4.setText("MonsterEnergy: 0");



        }
    }
}
