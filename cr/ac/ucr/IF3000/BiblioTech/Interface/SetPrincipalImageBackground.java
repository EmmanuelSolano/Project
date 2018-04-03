/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.IF3000.BiblioTech.Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Max
 */
public class SetPrincipalImageBackground extends JPanel{
   
    public void paintComponent(Graphics g){
             
        Dimension tam=getSize();
        
        ImageIcon imagen= new ImageIcon(getClass().getResource("/Backgrounds/fondo.jpg"));
        g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
