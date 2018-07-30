/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.*;
import java.net.URL;

/**
 *
 * @author Hoang
 */
public class GameScene extends Scene {
    // The Player
    private Player player;
    private Projectile bullet;
    private Turf background;
    //Timer timer;

    private boolean hasBegun = false;

    private MonsterSpawner spawner;

    private Vector<Invader> invaders;

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
        System.out.println("GameScene(int _width, int _height)");
        this.init();
    }

    @Override
    public void init() {
        System.out.println("GameScene.init()");
        this.timer = new Timer(20, this);
        this.spawner = new MonsterSpawner(this);
        this.invaders = new Vector<Invader>();
        this.hasBegun = !this.hasBegun;
        this.addPlayer();
        this.background = new Turf("Background", "None", "assets/sprites/space.gif");
        this.bullet = new Projectile(200, 200);
        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
        this.timer.start();
        this.testSpawnMonsterRow();

        this.add(background);
        this.add(bullet);
    }

    public void addPlayer() {
        //        System.out.println("GameScene.addPlayer()");
        String username = JOptionPane.showInputDialog("Enter your name: ");
        this.player = new Player(username);
        this.add(this.player);
        //this.add(this.bullet);
    }

    public void draw(Graphics g) {
        if (this.hasBegun) {
            this.player.draw(g);
            this.bullet.draw(g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.hasBegun) {
            if(this.player.getLocation().y==5)
                {
                    this.player.setX(270);
                    this.player.setY(330);
                    this.bullet.setX(999);
                    this.bullet.setY(999);
                    background.setLocation(xline-100, yline-100);
                }
            if (this.player.getLocation().getX() < 0) {
                this.player.setVelX(0);
                this.player.setX(0);
            } else if (this.player.getX() > 530
                       && this.player.getVelX() > 0) {
                this.player.setVelX(0);
                this.player.setX(534);
            }

            yline += 1;
            double tmp = this.bullet.getY() + this.bullet.getVelY();
            this.bullet.setY(this.bullet.getY() + this.bullet.getVelY());
            if(this.bullet.getY() <= 0)
                {
                    this.bullet.setVelocity(0,0);
                    this.bullet.setY(999);
                }
            repaint();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.hasBegun) {
            int code = e.getKeyCode();
            testKillAllInvaders();
            switch (code) {
            case KeyEvent.VK_LEFT:
                this.player.setVelocity(-5, 0);
                if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(-5, 0);
                else
                    this.bullet.setVelocity(0,-5);
                break;
            case KeyEvent.VK_RIGHT:
                this.player.setVelocity(5, 0);
                if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(5, 0);
                else
                    this.bullet.setVelocity(0,-5);
                break;
            case KeyEvent.VK_SPACE:
                this.player.setVelocity(0, 0);
                this.bullet.setVelocity(0, -5);
                System.out.println(this.bullet.getY());
                double tmp = this.bullet.getY() + this.bullet.getVelY();
                if(this.bullet.getY() > 500)
                    {
                        this.bullet.setX(this.player.getX());
                        this.bullet.setY(this.player.getY());
                    }
                //}
                repaint();
            default:
                break;
            }

            System.out.println(this.player.getX() + " + " + this.player.getVelX());
            System.out.println(this.player.getY() + " + " + this.player.getVelY());
            this.player.setX(this.player.getX() + this.player.getVelX());
            this.player.setY(this.player.getY() + this.player.getVelY());
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void testSpawnMonster() {
        Weak_Invader test = new Weak_Invader();
        this.invaders.add(test);
        spawner.weakInvader(50, 50);
    }

    public void testSpawnMonsterRow() {
        final int START_X = 50;
        final int START_Y = 50;
        final int MAX_MONSTERS = 10;

        spawner.alotOfWeakInvaders(START_X, START_Y, MAX_MONSTERS, 3);
    }

    public boolean areInvadersDead() {
        if (invaders.size() <= 0) {
            return true;
        }
        return false;
    }

    public void winCheck() {
        if (areInvadersDead()) {
            System.out.println("You won");
        }
    }

    public void testKillAllInvaders() {
        System.out.println("Killing");
        for (Invader a : invaders) {
            System.out.println(a.name);
            this.remove(a);
            a = null;
            System.gc();
        }
        this.invaders.clear();
        this.winCheck();
    }

    public void addInvader(Invader invader) {
        this.invaders.add(invader);
    }
}
