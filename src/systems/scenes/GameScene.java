//package javaapplication10;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Random rand;
    private Player player;
    private Projectile bullet;
    Sound so;
    int scores=0;
    
    private boolean hasBegun = false;

    int x1,x2,x3,x4,x5;
    int x12,x22,x32,x42,x52;
    int x13,x23,x33,x43,x53;
    
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
        System.out.println("GameScene(int _width, int _height)");
        this.init();
    }

    //@Override
    @Override
    public void init() {
        System.out.println("GameScene.init()");
        so=new Sound();
        this.timer = new Timer(20, this);
        this.hasBegun = !this.hasBegun;
        this.addPlayer();
        this.bullet = new Projectile(200,200);
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.timer.start();
        this.player.hp=1;
        playerhp.setForeground(Color.CYAN);
        playerhp.setVisible(true);
        this.add(playerhp);
        
        so.GameStart();
        
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
        
        MakeRandomMonster();
    }
    public void MakeRandomMonster(){
        rand=new Random();

        do
        {
            x1=rand.nextInt(50);
            x2=x1+rand.nextInt(115);
            x3=x2+rand.nextInt(260);
            x4=x3+rand.nextInt(405);
            x5=x4+rand.nextInt(550);
        }while(x1 > 550 || x2 > 550 || x3 > 550 || x4 > 550 || x5 >550);
        
        do{
            x12=rand.nextInt(50);
            x22=x12+rand.nextInt(115);
            x32=x22+rand.nextInt(260);
            x42=x32+rand.nextInt(405);
            x52=x42+rand.nextInt(550);
        }while(x12 > 550 || x22 > 550 || x32 > 550 || x42 > 550 || x52 >550);
        
        do{
            x13=rand.nextInt(50);
            x23=x13+rand.nextInt(115);
            x33=x23+rand.nextInt(260);
            x43=x33+rand.nextInt(405);
            x53=x43+rand.nextInt(550);
        }while(x13 > 550 || x23 > 550 || x33 > 550 || x43 > 550 || x53 >550);
    }
    public void addPlayer() {
        System.out.println("GameScene.addPlayer()");
        String username = JOptionPane.showInputDialog("Enter your name: ");
        this.player = new Player(username);
        this.add(this.player);
    }

    public void draw(Graphics g) {
        if (this.hasBegun) {
            this.player.draw();
            this.bullet.draw();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         background.setLocation(0, 0);
        if (this.hasBegun) {
            if(this.player.getLocation().getY()!=330)
            {
                this.player.setX(270);
                this.player.setY(330);
                this.bullet.setX(999);
                this.bullet.setY(999);
            }
            if (this.player.getLocation().getX() < 0) {
                this.player.setVelX(0);
                this.player.setX(0);
            } else if (this.player.getX() > 530
                && this.player.getVelX() > 0) {
                this.player.setVelX(0);
                this.player.setX(534);
            }
            if(playerhp.getLocation().getX()!=560)
                playerhp.setLocation(560, 5);
            playerhp.setText("HP: " + this.player.hp);
            yline += 1;
            
            if(yline>550)
            {
                yline=0;
                MakeRandomMonster();
            }
            if(lb1.getLocation().getX()!=999)
                lb1.setLocation(x1,yline);
            if(lb2.getLocation().getX()!=999)
                lb2.setLocation(x2,yline);
            if(lb3.getLocation().getX()!=999)
                lb3.setLocation(x3,yline);
            if(lb4.getLocation().getX()!=999)
                lb4.setLocation(x4,yline);
            if(lb5.getLocation().getX()!=999)
                lb5.setLocation(x5,yline);
        
            if(lb12.getLocation().getX()!=999)
                lb12.setLocation(x12,yline-50);
            if(lb22.getLocation().getX()!=999)
                lb22.setLocation(x22,yline-50);
            if(lb32.getLocation().getX()!=999)
                lb32.setLocation(x32,yline-50);
            if(lb42.getLocation().getX()!=999)
                lb42.setLocation(x42,yline-50);
            if(lb52.getLocation().getX()!=999)
                lb52.setLocation(x52,yline-50);
            
            if(lb13.getLocation().getX()!=999)
                lb13.setLocation(x13,yline-100);
            if(lb23.getLocation().getX()!=999)
            lb23.setLocation(x23,yline-100);
            if(lb33.getLocation().getX()!=999)
                lb33.setLocation(x33,yline-100);
            if(lb43.getLocation().getX()!=999)
                lb43.setLocation(x43,yline-100);
            if(lb53.getLocation().getX()!=999)
            lb53.setLocation(x53,yline-100);
            
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
           
            Rectangle[] arrRLabels= new Rectangle[15];
            for(int i=0; i<arr1.length; i++){
                arrRLabels[i]=arr1[i].getBounds();
            }
            for(JLabel lb : arr1){
                if(lb.getBounds().intersects(this.bullet.getBounds()))
                {
                    this.bullet.setVelocity(0,0);                  
                    this.bullet.setY(999);
                    lb.setLocation(999,999);
                    so.MonsterDied();
                    scores++;
                                    
                }
                if(lb.getBounds().intersects(this.player.getBounds())){
                    timer.stop();
                    so.MonsterDied();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    so.PlayerDeath();
                    JOptionPane.showMessageDialog(null, "You died. Your Scores: "+ scores);
                }
            }
            if(scores>14){
                timer.stop();
                JOptionPane.showMessageDialog(null, "You WON. Your Scores: "+ scores);
            }
            System.out.println("Score: " + scores);
        }
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
                  
                case KeyEvent.VK_UP:
                case KeyEvent.VK_SPACE:
                  this.player.setVelocity(0, 0);
                  this.bullet.setVelocity(0, -10);
                    if(this.bullet.getY() > 500)
                    {
                        this.bullet.setX(this.player.getX());
                        this.bullet.setY(this.player.getY());
                        so.Shoot();
                    }
              default:
                  break;
          }
        this.player.setX(this.player.getX() + this.player.getVelX());

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
