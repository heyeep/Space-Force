package javaapplication10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.Timer;
/**
 *
 * @author Hoang
 */
public class GameScene extends Scene {
    // The Player
    private Player player;
    private Projectile bullet;
    //Collision compare = new Collision();
    //Timer timer;
    int scores=0;
    
    private boolean hasBegun = false;

    int x = 0, y = 0, velx =0, vely =0;
    int xline=0,yline=0;
    
    JLabel lb1 = new JLabel();
    JLabel lb2 = new JLabel();
    JLabel lb3 = new JLabel();
    JLabel lb4 = new JLabel();
    JLabel lb5 = new JLabel();
    
    JLabel lb12 = new JLabel();
    JLabel lb22 = new JLabel();
    JLabel lb32 = new JLabel();
    JLabel lb42 = new JLabel();
    JLabel lb52 = new JLabel();
    
    JLabel lb13 = new JLabel();
    JLabel lb23 = new JLabel();
    JLabel lb33 = new JLabel();
    JLabel lb43 = new JLabel();
    JLabel lb53 = new JLabel();
    JLabel background = new JLabel();
    //JLabel bullet = new JLabel();
    JLabel playerhp = new JLabel();
    
        
    JLabel scoreplayer = new JLabel();
    
    
    
    public GameScene() {
        super();
        System.out.println("GameScene");
        this.init();
    }

    public GameScene(String _name) {
        super(_name);
        System.out.println("GameScene(String _name)");
        this.init();
    }

    public GameScene(int _width, int _height) {
        //super(_width, _height);
        System.out.println("GameScene(int _width, int _height)");
        this.init();
    }

    //@Override
    @Override
    public void init() {
        System.out.println("GameScene.init()");
        this.timer = new Timer(20, this);
        this.hasBegun = !this.hasBegun;
        this.addPlayer();
        this.bullet = new Projectile(200,200);
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.timer.start();
//        this.player.setX(270);
//        this.player.setY(330);
//        this.player.draw();
        this.player.hp=1;
        
        playerhp.setForeground(Color.CYAN);
        playerhp.setVisible(true);
        this.add(playerhp);
      
        scoreplayer.setForeground(Color.CYAN);
        scoreplayer.setVisible(true);
        this.add(scoreplayer);
        
        

        lb1.setIcon(new ImageIcon("enemy_4030.png"));
        lb1.setVisible(true);
        this.add(lb1);
        
        lb2.setIcon(new ImageIcon("enemy_4030.png"));
        lb2.setVisible(true);
        this.add(lb2);
        
        lb3.setIcon(new ImageIcon("enemy_4030.png"));
        lb3.setVisible(true);
        this.add(lb3);
        
        lb4.setIcon(new ImageIcon("enemy_4030.png"));
        lb4.setVisible(true);
        this.add(lb4);
        
        lb5.setIcon(new ImageIcon("enemy_4030.png"));
        lb5.setVisible(true);
        this.add(lb5);
        
        lb12.setIcon(new ImageIcon("enemy_4030.png"));
        lb12.setVisible(true);
        this.add(lb12);
        
        lb22.setIcon(new ImageIcon("enemy_4030.png"));
        lb22.setVisible(true);
        this.add(lb22);
        
        lb32.setIcon(new ImageIcon("enemy_4030.png"));
        lb32.setVisible(true);
        this.add(lb32);
        
        lb42.setIcon(new ImageIcon("enemy_4030.png"));
        lb42.setVisible(true);
        this.add(lb42);
        
        lb52.setIcon(new ImageIcon("enemy_4030.png"));
        lb52.setVisible(true);
        this.add(lb52);
        
        lb13.setIcon(new ImageIcon("enemy_4030.png"));
        lb13.setVisible(true);
        this.add(lb13);
        
        lb23.setIcon(new ImageIcon("enemy_4030.png"));
        lb23.setVisible(true);
        this.add(lb23);
        
        lb33.setIcon(new ImageIcon("enemy_4030.png"));
        lb33.setVisible(true);
        this.add(lb33);
        
        lb43.setIcon(new ImageIcon("enemy_4030.png"));
        lb43.setVisible(true);
        this.add(lb43);
        
        lb53.setIcon(new ImageIcon("enemy_4030.png"));
        lb53.setVisible(true);
        this.add(lb53);
        
        bullet.setIcon(new ImageIcon("bullet.png"));
        bullet.setVisible(true);
        this.add(bullet);
        
        background.setIcon(new ImageIcon("space2.gif"));
        background.setVisible(true);
        this.add(background);
    }

    public void addPlayer() {
        System.out.println("GameScene.addPlayer()");
        String username = JOptionPane.showInputDialog("Enter your name: ");
        this.player = new Player(username);
        this.add(this.player);
        //this.add(this.bullet);
    }

    public void draw(Graphics g) {
        if (this.hasBegun) {
            //            System.out.println("GameScene.draw()");
            //            System.out.println(player.icon.getWidth(null) + " " + player.icon.getHeight(null));

            //            g.drawImage(this.player.getImage(), this.player.getX(),
            //                        this.player.getY(),50, 50, this);
            this.player.draw();
            this.bullet.draw();
           

            //g.setColor(Color.RED);
            //g.fillRect(this.player.getX(),this.player.getY(),50,30);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
        
//        g.setColor(Color.BLUE);
//        g.fillRect(xline,yline,50,30);
//
//        g.setColor(Color.BLACK);
//        g.fillRect(xline+120,yline,50,30);
//
//        g.setColor(Color.GREEN);
//        g.fillRect(xline+240,yline,50,30);
//
//        g.setColor(Color.ORANGE);
//        g.fillRect(xline+360,yline,50,30);
//
//        g.setColor(Color.MAGENTA);
//        g.fillRect(xline+480,yline,50,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("LOL");
         background.setLocation(0, 0);
        if (this.hasBegun) {
            if(this.player.getLocation().getY()!=330)
            {
                System.out.println("LOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL this.player.getLocation().getY()!=330");
                this.player.setX(270);
                this.player.setY(330);
                this.bullet.setX(999);
                this.bullet.setY(999);
//                lb1.setLocation(xline+0,yline);
//                lb2.setLocation(xline+45,yline);
//                lb3.setLocation(xline+90,yline);
//                lb4.setLocation(xline+135,yline);
//                lb5.setLocation(xline+180,yline);
//                
//                lb12.setLocation(xline+0,yline-50);
//                lb22.setLocation(xline+45,yline-50);
//                lb32.setLocation(xline+90,yline-50);
//                lb42.setLocation(xline+135,yline-50);
//                lb52.setLocation(xline+180,yline-50);
//                
//                lb13.setLocation(xline+0,yline-100);
//                lb23.setLocation(xline+45,yline-100);
//                lb33.setLocation(xline+90,yline-100);
//                lb43.setLocation(xline+135,yline-100);
//                lb53.setLocation(xline+180,yline-100);
                //background.setLocation(xline-100, yline-100);
            }
            if (this.player.getLocation().getX() < 0) {
                System.out.println("LOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL this.player.getLocation().getX() < 0 ");
                this.player.setVelX(0);
                this.player.setX(0);
            } else if (this.player.getX() > 530
                && this.player.getVelX() > 0) {
                System.out.println("LOLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL this.player.getX() > 530\n" +
"                && this.player.getVelX() > 0");
                this.player.setVelX(0);
                this.player.setX(534);
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
            if(playerhp.getLocation().getX()!=560)
                playerhp.setLocation(560, 5);
            playerhp.setText("HP: " + this.player.hp);
            
//            if(scoreplayer.getLocation().getX()!=5)
//                scoreplayer.setLocation(5, 115);
//            scoreplayer.setText("SCORES: " + scores);
            //playerhp.setVisible(true);
            
            yline += 1;
            if(lb1.getLocation().getX()!=999)
                lb1.setLocation(xline+0,yline);
            if(lb2.getLocation().getX()!=999)
                lb2.setLocation(xline+115,yline);
            if(lb3.getLocation().getX()!=999)
                lb3.setLocation(xline+260,yline);
            if(lb4.getLocation().getX()!=999)
                lb4.setLocation(xline+405,yline);
            if(lb5.getLocation().getX()!=999)
                lb5.setLocation(xline+550,yline);
            
            if(lb12.getLocation().getX()!=999)
                lb12.setLocation(xline+0,yline-50);
            if(lb22.getLocation().getX()!=999)
                lb22.setLocation(xline+115,yline-50);
            if(lb32.getLocation().getX()!=999)
                lb32.setLocation(xline+260,yline-50);
            if(lb42.getLocation().getX()!=999)
                lb42.setLocation(xline+405,yline-50);
            if(lb52.getLocation().getX()!=999)
                lb52.setLocation(xline+550,yline-50);
            
            if(lb13.getLocation().getX()!=999)
                lb13.setLocation(xline+0,yline-100);
            if(lb23.getLocation().getX()!=999)
            lb23.setLocation(xline+115,yline-100);
            if(lb33.getLocation().getX()!=999)
                lb33.setLocation(xline+260,yline-100);
            if(lb43.getLocation().getX()!=999)
                lb43.setLocation(xline+405,yline-100);
            if(lb53.getLocation().getX()!=999)
            lb53.setLocation(xline+550,yline-100);
//            //compare = (bullet, lb3);
//            System.out.print("BULLETVELOCITY    " + this.bullet.getVelY());
//            double tmp = this.bullet.getY() + this.bullet.getVelY();
//            System.out.print("  Y IS SUPPOSED TO BE:  "+ tmp);
//            System.out.print("  BULLET Y LOCATIONS    "+this.bullet.getLocation().getY());
            this.bullet.setY(this.bullet.getY() + this.bullet.getVelY());
            if(this.bullet.getY() <= 0)
            {
                this.bullet.setVelocity(0,0);
                this.bullet.setY(999);
                //this.bullet.setVisible(false);
            }
            
            JLabel[] arr1 = new JLabel[15];
            arr1[0] = lb1;
            arr1[1] = lb2;
            arr1[2] = lb3;
            arr1[3] = lb4;
            arr1[4] = lb5;
            arr1[5] = lb12;
            arr1[6] = lb22;
            arr1[7] = lb32;
            arr1[8] = lb42;
            arr1[9] = lb52;
            arr1[10] = lb13;
            arr1[11] = lb23;
            arr1[12] = lb33;
            arr1[13] = lb43;
            arr1[14] = lb53;
            
//            Rectangle Rplayer = this.player.getBounds();
//            Rectangle Rbullet = this.bullet.getBounds();
            Rectangle[] arrRLabels= new Rectangle[15];
            for(int i=0; i<arr1.length; i++){
                arrRLabels[i]=arr1[i].getBounds();
            }
            for(JLabel lb : arr1){
                if(lb.getBounds().intersects(this.bullet.getBounds()))
                {
                    //lb.setEnabled(false);
                    this.bullet.setVelocity(0,0);
//                    this.bullet.setX(this.player.getX());
//                    this.bullet.setY(this.player.getY());
                    this.bullet.setY(999);
                    lb.setLocation(999,999);
                    scores++;
                    //scoreplayer.setText("SCORES: " + scores);
                }
            }
//            Rectangle[] arr2 = new Rectangle[17];
//            arr2[0] = player.getBounds();
//            arr2[1] = bullet.getBounds();
//            for(int i = 2; i < 17; i++)
//            {
//                int u = i-2;
//                arr2[i] = arr1[u].getBounds();
//            }
//        
//            for(int i = 2; i < 17; i++)
//            {
//                int u = i - 2;
//                if(arr2[1].intersects(arr2[i]))
//                    arr1[u].setVisible(false);
//                else if(arr2[0].intersects(arr2[i]))
//                    player.setVisible(false);
//            }
            
             
            //lb1.setLocation(100, 100);
            //y += vely;
            //           System.out.println("X Coord: "
            //                               + this.player.getLocation().getX());
            //System.out.println("LOL");
            //repaint();
        }
        //background.setLocation(xline-100, yline-100);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.hasBegun) {
            int code = e.getKeyCode();
          switch (code) {
              case KeyEvent.VK_LEFT:
                  this.player.setVelocity(-5, 0);
                  if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(-5, 0);
                  else
                    this.bullet.setVelocity(0,-10);
                  break;
              case KeyEvent.VK_RIGHT:
                  this.player.setVelocity(5, 0);
                  if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(5, 0);
                  else
                    this.bullet.setVelocity(0,-10);
                  break;
              case KeyEvent.VK_SPACE:
                  this.player.setVelocity(0, 0);
                  this.bullet.setVelocity(0, -10);
//                  System.out.print("BULLETVELOCITY  " + this.bullet.getVelX());
//                  System.out.println(this.bullet.getY());
//
//                    System.out.print("BULLETVELOCITY    " + this.bullet.getVelY());
//                    double tmp = this.bullet.getY() + this.bullet.getVelY();
//                    System.out.print("  Y IS SUPPOSED TO BE:  "+ tmp);
//                    System.out.print("  BULLET Y LOCATIONS :  "+this.bullet.getLocation().getY());
                    if(this.bullet.getY() > 500)
                    {
                        this.bullet.setX(this.player.getX());
                        this.bullet.setY(this.player.getY());
                    }
                    //}
                    //repaint();
              default:
                  break;
          }
          
//        System.out.println(this.player.getX() + " + " + this.player.getVelX());
//        System.out.println(this.player.getY() + " + " + this.player.getVelY());
        this.player.setX(this.player.getX() + this.player.getVelX());
        //this.player.setY(this.player.getY() + this.player.getVelY());
        //this.bullet.setX(this.bullet.getX() + this.bullet.getVelX());
        //this.bullet.setY(this.bullet.getY() + this.bullet.getVelY());
        //System.out.println(this.player.getX() + " + " + this.player.getVelX());
        //System.out.println(this.player.getY() + " + " + this.player.getVelY());
            //        y += vely;
        //repaint();
        }
    }
    


   
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //            velx=0;
        //            vely=0;
    }
}
