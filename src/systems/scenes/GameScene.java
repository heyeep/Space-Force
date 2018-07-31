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
import java.util.*;
import java.net.URL;

/**
 *
 * @author Hoang
 */
public class GameScene extends Scene {
    Random rand;
    private MonsterSpawner spawner;
    private Player player;
    private Projectile bullet;
    private Turf background;
    private Vector<Invader> invaders;
    Sound so;
    int scores = 0;

    private boolean hasBegun = false;
    private boolean restartGameAfterDeath = true;

    int x1,x2,x3,x4,x5;
    int x12,x22,x32,x42,x52;
    int x13,x23,x33,x43,x53;

    int x = 0, y = 0, velx =0, vely =0;
    int xline=0, yline=0;

    JLabel playerhp = new JLabel();
    JLabel scoreplayer = new JLabel();

    public GameScene() {
        super();
        System.out.println("GameScene");
        this.startTimerAndInit();
    }

    public GameScene(String _name) {
        super(_name);
        System.out.println("GameScene(String _name)");
        this.startTimerAndInit();
    }

    public GameScene(int _width, int _height) {
        super(_width, _height);
        //        System.out.println("GameScene(int _width, int _height)");
        this.startTimerAndInit();
    }

    public void startTimerAndInit() {
        this.timer = new Timer(20, this);
        this.init();
        this.timer.start();
    }

    @Override
    public void init() {
        System.out.println("GameScene.init()");
        so = new Sound();
        this.rand = new Random();
        this.spawner = new MonsterSpawner(this);
        this.invaders = new Vector<Invader>();
        this.hasBegun = !this.hasBegun;
        this.addPlayer();
        //this.background = new Turf("Background", "None", "assets/sprites/space.gif");
        this.bullet = new Projectile(200, 200);

        setFocusable(true);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.setVisible(true);

        this.playerhp.setForeground(Color.CYAN);
        this.playerhp.setVisible(true);
        this.add(playerhp);

        //        so.GameStart();

        this.scoreplayer.setForeground(Color.CYAN);
        this.scoreplayer.setVisible(true);

        this.add(scoreplayer);
        this.add(bullet);
        //this.add(background);

        //        MakeRandomMonster();
        //        testSpawnRandomMonsters();
        testSpawnRandomMonster();
        testSpawnRandomMonster();
        testSpawnRandomMonster();
        testSpawnRandomMonster();
        //        testSpawnMonster();
    }

    // public void MakeRandomMonster(){
    //     rand=new Random();
    //     do
    //     {
    //         x1=rand.nextInt(50);
    //         x2=x1+rand.nextInt(115);
    //         x3=x2+rand.nextInt(260);
    //         x4=x3+rand.nextInt(405);
    //         x5=x4+rand.nextInt(550);
    //     }while(x1 > 550 || x2 > 550 || x3 > 550 || x4 > 550 || x5 >550);

    //     do{
    //         x12=rand.nextInt(50);
    //         x22=x12+rand.nextInt(115);
    //         x32=x22+rand.nextInt(260);
    //         x42=x32+rand.nextInt(405);
    //         x52=x42+rand.nextInt(550);
    //     } while(x12 > 550 || x22 > 550 || x32 > 550 || x42 > 550 || x52 >550);

    //     do{
    //         x13=rand.nextInt(50);
    //         x23=x13+rand.nextInt(115);
    //         x33=x23+rand.nextInt(260);
    //         x43=x33+rand.nextInt(405);
    //         x53=x43+rand.nextInt(550);
    //     }while(x13 > 550 || x23 > 550 || x33 > 550 || x43 > 550 || x53 >550);
    // }

    public void reset() {
        this.rand = null;
        this.spawner = null;
        this.player = null;
        this.bullet = null;
        this.background = null;
        this.invaders.clear();
        this.invaders = null;
        this.so = null;
        this.scores = 0;
        this.hasBegun = false;

        //        JLabel playerhp = new JLabel();
        //        JLabel scoreplayer = new JLabel();
    }

    public void addPlayer() {
        //        String username = JOptionPane.showInputDialog("Enter your name: ");
        this.player = new Player("Test");
        this.add(this.player);
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
            if (this.player.getHp() <= 0) {
                end();
            }
            this.moveInvaders();
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
            playerhp.setText("HP: " + this.player.getHp());
            yline += 1;

            if(yline>550)
            {
                yline=0;
                testSpawnRandomMonster();
            }

            this.bullet.setY(this.bullet.getY() + this.bullet.getVelY());
            if(this.bullet.getY() <= 0)
            {
                this.bullet.setVelocity(0,0);
                this.bullet.setY(999);
            }

            Rectangle[] arrRLabels= new Rectangle[15];
            for(int i=0; i<invaders.size(); i++){
                arrRLabels[i]=invaders.get(i).getBounds();
            }
            for(Invader invader : invaders){
                if(invader.getBounds().intersects(this.bullet.getBounds()))
                {
                    this.bullet.setVelocity(0,0);
                    this.bullet.setY(999);

                    this.remove(invader);
                    invader = null;
                    System.gc();
                    //                    so.MonsterDied();
                    scores++;
                    break;

                }
                if(invader.getBounds().intersects(this.player.getBounds())){
                    timer.stop();
                    //                    so.MonsterDied();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //                    so.PlayerDeath();
                    //                    JOptionPane.showMessageDialog(null, "You died. Your Scores: "+ scores);
                    /*
                     * TODO: RESTART GAME
                     * -------------------
                     * Not sure how y'all want to do this
                     * Could just auto restart the game
                     * Which means resetting the entire map
                     */
                }
            }
            if(scores>14){
                timer.stop();
                JOptionPane.showMessageDialog(null, "You WON. Your Scores: "+ scores);
            }
            //            System.out.println("Score: " + scores);
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
                        //                        so.Shoot();
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

    public void testSpawnMonster() {
        spawner.weakInvader(50, 50);
    }

    public void testSpawnRandomMonsters() {
        spawner.rowOfRandomWeakInvaders(500, 50, 3);
    }

    public void testSpawnRandomMonster() {
        spawner.randomWeakInvader(500, 50);
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

    public void deathCheck() {
        if (isPlayerDead()) {
            System.out.println("Player has died.");
            /*
             * TODO: SOUND EFFECTS
             * -------------------
             * A sound for when the player dies
             */
        }
    }

    public void winCheck() {
        if (areInvadersDead()) {
            System.out.println("You won.");
            /*
             * TODO: SOUND EFFECTS
             * -------------------
             * A nice winning sound
             */
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

    public void moveInvaders() {
        for(Invader invader : invaders) {
            invader.moveDown();
            if (isInvaderOutOfBounds(invader)) {
                System.out.println("Invader has moved pass you.");

                this.player.setHp(this.player.getHp() - 1);
                this.deathCheck();
            }
        }
    }

    public boolean isInvaderOutOfBounds(Invader invader) {
        //        System.out.println("HEIGHT: " + this.getHeight());
        if (invader.getY() >= this.getHeight()) {
            /*
             * TODO: SOUND EFFECTS
             * -------------------
             * Sound Effects for when Invader leaves screen
             */
            return true;
        }
        return false;
    }

    public boolean isPlayerDead() {
        if (player.getHp() <= 0) {
            return true;
        }
        return false;
    }

    public void end() {
        System.out.println("Game has ended.");
        // GameScene nextScene = new GameScene(Window.DEFAULT_WIDTH,
        //                                  Window.DEFAULT_HEIGHT);
        // nextScene.revalidate();
        // nextScene.repaint();
        // this.reset();
        // this.getWindow().switchScene(this, nextScene);
        if (this.restartGameAfterDeath) {
            this.restartGame();
        } else {
            // TODO: Go back to MainMenu Scene
            // MainScene nextScene = new MainScene(Window.DEFAULT_WIDTH,
            //                                  Window.DEFAULT_HEIGHT);
            // this.removeAll();
            // this.revalidate();
            // this.repaint();
            // this.getWindow().switchScene(this, nextScene);
        }
    }

    public void restartGame() {
        System.out.println("Restarting game...");
        this.removeAll();
        this.reset();
        this.revalidate();
        this.repaint();
        this.init();
    }

}
