/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Metodos {
//    boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField texto=new JTextField();
                texto.setSize(500, 50);
                texto.setLocation(10, 10);
                JPanel panel1=new JPanel();
                panel1.setSize(400, 100);
                panel1.setLocation(1, 1);
                panel1.setVisible(true);
                panel1.add(texto);
                texto.setVisible(true);
            }
//        });
}
