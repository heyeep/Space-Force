/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
/**
 *
 * @author Hoang
 */
public class GameScene extends Scene {
    // The Player
    private Player player;

    private boolean hasBegun = false;

    int x = 0, y = 0, velx =0, vely =0;
    int xline=0,yline=0;

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
        super(_width, _height);
        System.out.println("GameScene(int _width, int _height)");
        this.init();
    }

    public void init() {
        System.out.println("GameScene.init()");
        this.timer = new Timer(20, this);
        this.hasBegun = !this.hasBegun;
        this.addPlayer();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.timer.start();
    }

    public void addPlayer() {
        System.out.println("GameScene.addPlayer()");
        this.player = new Player();
        this.add(this.player);
    }

    public void draw(Graphics g) {
        if (this.hasBegun) {
            //            System.out.println("GameScene.draw()");
            //            System.out.println(player.icon.getWidth(null) + " " + player.icon.getHeight(null));

            //            g.drawImage(this.player.getImage(), this.player.getX(),
            //                        this.player.getY(),50, 50, this);
            this.player.draw();
            g.setColor(Color.RED);
            g.fillRect(this.player.getX(),this.player.getY(),50,30);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //        System.out.println("GameScene.paintComponent(Graphics g)");
        this.draw(g);
        //        g.setColor(Color.RED);
        //        g.fillRect(x,y+322,50,30);

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
    public void actionPerformed(ActionEvent e) {
        if (this.hasBegun) {
            if (this.player.getLocation().getX() < 0) {
                this.player.setVelX(0);
                this.player.setX(0);
            } else if (this.player.getX() > 530
                && this.player.getVelX() > 0) {
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
            yline += 1;
            //y += vely;
            //           System.out.println("X Coord: "
            //                               + this.player.getLocation().getX());
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //        System.out.println("LOL");
        if (this.hasBegun) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_DOWN) {
                this.player.setVelocity(0, 1);
            } else if (code == KeyEvent.VK_UP) {
                this.player.setVelocity(0, -1);
            } else if (code == KeyEvent.VK_LEFT) {
                this.player.setVelocity(-3, 0);
            } else if (code == KeyEvent.VK_RIGHT) {
                this.player.setVelocity(3, 0);
            }
            this.player.setX(this.player.getX() + this.player.getVelX());
            //            System.out.println(this.player.getX() + this.player.getVelX());
            //        y += vely;
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
        //            velx=0;
        //            vely=0;
    }
}
