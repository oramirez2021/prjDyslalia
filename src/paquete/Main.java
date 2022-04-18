/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paquete;

import clase.MoverImagen;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author omar
 */
public class Main {
static MoverImagen mario=null;
static JTextArea texto=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        texto=new JTextArea();
         texto.setSize(200, 20);
         texto.setLocation(0, 0);
         
// TODO code application logic here
        
         mario=new MoverImagen(0,550,"/images/moviendo.png");
//         MoverImagen nube=new MoverImagen(50, 20,"/images/nube.png");
         JFrame frm=new JFrame();
         frm.setSize(1000, 700);
         frm.setLocationRelativeTo(null);
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frm.setVisible(true);
//       frm.setExtendedState(Frame.MAXIMIZED_BOTH);
         //Panel Mario
         frm.add(texto);
//         JPanel pnlMario=new JPanel();
//         pnlMario.setSize(500, 500);
//         pnlMario.setLocation(0, 0);
//         pnlMario.setBorder(BorderFactory.createLineBorder(Color.yellow));
//         pnlMario.setLayout(null);
         
//         pnlMario.setVisible(true);
//         pnlMario.add(mario);
//         frm.setLayout(null);
         
         mario.setSize(1000, 700);
//         mario.setLocation(50, 100);
         frm.add(mario);
         
//         EscenarioPanel bros=new EscenarioPanel("/images/moviendo.png");
//         bros.setSize(50, 50);
//         bros.setLocation(100, 100);
//         frm.add(bros);
         
         
         
         EscenarioPanel escenario=new EscenarioPanel("/images/fondo.png");
         escenario.setLocation(0, 0);
         frm.add(escenario);
         
         Timer tiempo=new Timer(2000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("texto" + texto.getText());
                if(texto.getText().equals("123")){
                   mario.movimiento("avanzar");
                   texto.setText("");
                   
                }
                 if(texto.getText().equals("321")){
                   mario.movimiento("retroceder");
                   texto.setText("");
                }
                 if(texto.getText().equals("456")){
                   mario.movimiento("saltar");
                   texto.setText("");
                   try{
                    Clip sonido=AudioSystem.getClip();
                    File b=new File("C:\\Users\\ADMIN\\Documents\\AppReconocimientoVoz\\src\\sonidos\\jump.wav");
                    sonido.open(AudioSystem.getAudioInputStream(b));
                    sonido.start();
                   } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.toString(),"Mensaje",JOptionPane.CANCEL_OPTION);
                    }
                }
                 if(texto.getText().equals("654")){
                   mario.movimiento("bajar");
                   texto.setText("");
                }
            }
        });
         texto.requestFocus(true);
         tiempo.start();
//   frm.getContentPane().add(mario);
//   pnlMario.add(mario);
//         texto.setText("123");
         
         
    }
    
}
