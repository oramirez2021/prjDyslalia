/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paquete;

import clase.MoverImagen;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author omar
 */
public class EscenarioPanel extends JPanel {
    JTextArea txtSpeech=new JTextArea();
    String ruta="";
    int x,y;
    public EscenarioPanel(String ruta){
//        this.setSize(ancho,alto);
        this.ruta=ruta;
        this.x=x;
        this.y=y;
    }
    @Override
    public void paintComponent(Graphics g){
        Dimension d=getSize();
        ImageIcon imagen=new ImageIcon(getClass().getResource(ruta));
        g.drawImage(imagen.getImage(), 0,0 , d.getSize().width,d.getSize().height,null);
         
//          txtSpeech.setSize(500,20);
//          txtSpeech.setLocation(0, 0);
//          this.add(txtSpeech);
//          System.out.println(txtSpeech.getText());
//          txtSpeech.requestFocus(true);
//          if(txtSpeech.getText().equals("123")){  
//              System.out.println("avanza der");
//              MoverImagen mueve=new MoverImagen(0, 0, ruta);
//              txtSpeech.setText("");
//              mueve.movimiento("derecha");
//              
//              mueve=null;
//          }}
        setOpaque(false);
    }
    
    
}
