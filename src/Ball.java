/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Hoang
 */
public class Ball extends JPanel implements ActionListener, KeyListener 
{
    Timer t = new Timer(20, this);
    int x = 0, y = 0, velx =0, vely =0;
    int xline=0,yline=0;
    public Ball() 
    {
	t.start();
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    }
    @Override
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.setColor(Color.RED);
	g.fillRect(x,y+322,50,30);
        
        g.setColor(Color.BLUE);
	g.fillRect(xline,yline,50,30);
        
        g.setColor(Color.BLACK);
	g.fillRect(xline+120,yline,50,30);
        
        g.setColor(Color.GREEN);
	g.fillRect(xline+240,yline,50,30);
        
        g.setColor(Color.ORANGE);
	g.fillRect(xline+360,yline,50,30);
        
        g.setColor(Color.MAGENTA);
	g.fillRect(xline+480,yline,50,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(x < 0)
        {
                velx=0;
                x = 0;		
        }

        if(x > 530 && velx>0)
        {
                velx=0;
                x = 534;		
        }
        
//        if(y < 0)
//        {
//                vely=0;
//                y = 0;		
//        }
//
//        if(y > 330)
//        {
//                vely=0;
//                y = 324;		
//        }
        //x += velx;
        yline+=1;
        //y += vely;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
	int code = e.getKeyCode();
	
	if (code == KeyEvent.VK_DOWN){
		vely = 1;
		velx = 0;
	}
	if (code == KeyEvent.VK_UP){
		vely = -1;
		velx = 0;
	}
	if (code == KeyEvent.VK_LEFT){
		vely = 0;
		velx = -3;
	}
	if (code == KeyEvent.VK_RIGHT){
		vely = 0;
		velx = 3;
		
	}
        x += velx;
//        y += vely;
        repaint();
    }



    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
//            velx=0;
//            vely=0;
    }
}
