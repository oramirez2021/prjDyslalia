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
public class NewMain {
static MoverImagen mario=null;
static JTextArea texto=null;
static JFrame frm=null;
static EscenarioPanel lapiz=null;
static EscenarioPanel bufanda=null;
static Timer tiempo=null;
static int peticion=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        texto=new JTextArea();
         texto.setSize(200, 20);
         texto.setLocation(0, 0);
         
// TODO code application logic here
        
         
         //Creando Frame
         frm=new JFrame();
         frm.setSize(1000, 700);
         frm.setLocationRelativeTo(null);
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frm.setResizable(false);
         frm.setVisible(true);
         frm.setLayout(null);
        //Instancias
         
         //Se instancian objetos
         lapiz=new EscenarioPanel("/images/lapiz.png");
         bufanda=new EscenarioPanel("/images/bufanda.png");
         //Aparecen en frame
         
         frm.add(texto);
         
         EscenarioPanel hongo=new EscenarioPanel("/images/hongo.png");
         hongo.setLocation(200, 200);
         hongo.setSize(100, 100);
         frm.add(hongo);
         
         mario=new MoverImagen(0,550,"/images/moviendo.png");
         mario.setSize(1000, 700);
         frm.add(mario);
         
         EscenarioPanel escenario=new EscenarioPanel("/images/escenario2.png");
         escenario.setSize(1000, 660);
         escenario.setLocation(0, 0);
         frm.add(escenario);
         
         tiempo=new Timer(500,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("texto" + texto.getText());
                if(texto.getText().equals("123") && peticion==0){
                   mario.movimiento("avanzar");
                   texto.setText("");
                   muestraImagen();
                   
                }
                 if(texto.getText().equals("321") && peticion==0){
                   mario.movimiento("retroceder");
                   texto.setText("");
                   muestraImagen();
                }
                 if(texto.getText().equals("456") && peticion==0){
                   mario.movimiento("saltar");
                   texto.setText("");
                   muestraImagen();
                   try{
                    Clip sonido=AudioSystem.getClip();
                    File b=new File("C:\\Users\\omar\\Documents\\NetBeansProjects\\AppReconocimientoVoz\\src\\sonidos\\jump.wav");
                    sonido.open(AudioSystem.getAudioInputStream(b));
                    sonido.start();
                    
                   } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.toString(),"Mensaje",JOptionPane.CANCEL_OPTION);
                    }
                   
                }
                if(texto.getText().equals("654") && peticion==0){
                   mario.movimiento("bajar");
                   texto.setText("");
                   muestraImagen();
                }
                if(peticion==1){
                    if(texto.getText().equals("xxx")){
                        mario.movimiento("subir");
                        texto.setText("");
                        borraImagen();
                    }
                    if(texto.getText().equals("yyy")){
                        mario.movimiento("subir");
                        texto.setText("");
                        borraImagen();
                    }
                }
                
            }
        });
         texto.requestFocus(true);
         tiempo.start();

    }
    static private void muestraImagen(){
        int x=mario.xx;
        int y=mario.yy;
        int x1=350;
        int y1=100;
       System.out.println(x+"   "+y);
       //if(x==200 && y==500){
       if(x==200 && y==500){
           lapiz.setSize(200,200);
           lapiz.setLocation(x1, y1);
           frm.add(lapiz,1);
           peticion=1;
       }
       if(x==200 && y==400){
           bufanda.setSize(200,200);
           bufanda.setLocation(x1, y1);
           frm.add(bufanda,1);
           peticion=1;
       }
    }
    static private void borraImagen(){
        int x1=350;
        int y1=100;
            lapiz.setVisible(false);
            bufanda.setVisible(false);
            peticion=0;
  }
}
