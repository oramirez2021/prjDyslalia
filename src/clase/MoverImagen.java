/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author omar
 */
public class MoverImagen extends JPanel implements ActionListener{
    Timer tiempo=new Timer(50,this);
    public int xx=0,yy=0,velX=0,velY=0;
    String ruta="";
    Graphics gg=null;
    public MoverImagen(int x, int y,String ruta){
        tiempo.start();
//        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
            this.xx=x;
            this.yy=y;
        this.ruta=ruta;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon img=new ImageIcon(getClass().getResource(ruta));
        g.drawImage(img.getImage(),xx,yy,70,70,null);
//        System.out.println("se mueve  "+xx);
        
    }
    public void movimiento(String comando){
        if(comando.equals("avanzar")){
            velX=50;
            velY=0;
        }
        if(comando.equals("retroceder")){
            velX=-50;
            velY=0;
        }
        if(comando.equals("saltar")){
            velX=0;
            velY=-50;
        }
        if(comando.equals("bajar")){
            velX=0;
            velY=50;
        }
        xx=xx+velX;
        
        yy=yy+velY;
//        JOptionPane.showMessageDialog(this,comando+"   "+xx);
//        setOpaque(false);
        super.repaint();
      tiempo.stop();
    }
    public void keyPressed(KeyEvent e){
        
        int b=e.getKeyCode();
        if(b==KeyEvent.VK_LEFT){
            velX=-10;
            velY=0;
        }
        if(b==KeyEvent.VK_RIGHT){
            velX=10;
            velY=0;
        }
        if(b==KeyEvent.VK_UP){
            velX=0;
            velY=-10;
        }
        if(b==KeyEvent.VK_DOWN){
            velX=0;
            velY=10;
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        xx=xx+velX;
        
        yy=yy+velY;

        setOpaque(false);
        repaint();


    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }

//    @Override
//    public void keyReleased(KeyEvent e) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
