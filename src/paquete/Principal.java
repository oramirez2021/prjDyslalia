/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Principal {
static JFrame formulario=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        formulario=new JFrame();
        formulario.setSize(500, 500);
        formulario.setVisible(true);
        //panel
        JPanel panel=new JPanel();
        panel.setSize(400, 100);
        panel.setLocation(1, 1);
        //---------------
        formulario.add(panel);
        panel.setVisible(true);
        //añadiendo boton
        JButton boton=new JButton();
        //Action Listener
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField texto=new JTextField();
                texto.setSize(500, 50);
                texto.setLocation(10, 10);
                JPanel panel1=new JPanel();
                panel1.setSize(400, 100);
                panel1.setLocation(1, 1);
                formulario.add(panel1);
                panel1.setVisible(true);
                panel1.add(texto);
                texto.setVisible(true);
            }
        });
        boton.setText("AGREGAR");
        boton.setLocation(1,1);
        boton.setSize(200, 50);
        
        //***************
        panel.add(boton);
        
        boton.setVisible(true);
        
        //para cerrar correctamente el formulario
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
