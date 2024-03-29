// Hiep
// Note: Most of this section started off from Hoang's skeleton
//       I took a majority of it and broke it up into pieces,
import java.awt.*;
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
    private final int NUMBER_OF_MONSTERS = 5;
    private MonsterSpawner spawner;
    private Player player;
    private Projectile bullet;
    private Turf background;
    private Vector<Invader> invaders;
    private int invadersAlive;
    private ScoreManager scoreManager;
    private Sound soundManager;
    int scores = 0;

    private boolean hasBegun = false;
    private boolean restartGameAfterDeath = true;

    private Hud gameOver;

    int x = 0, y = 0, velx =0, vely =0;
    int xline=0, yline=0;

    JLabel playerhp = new JLabel();
    JLabel scoreplayer = new JLabel();

    // Huy
    Vector<Explosion> explosions = new Vector<Explosion>();
    Explosion explosionTest = new Explosion(3);
    Explosion exp1 = new Explosion(3);
    Explosion exp2 = new Explosion(3);
    Explosion exp3 = new Explosion(3);
    Explosion exp4 = new Explosion(3);
    Explosion exp5 = new Explosion(3);
    Explosion exp6 = new Explosion(3);
    Explosion exp7 = new Explosion(3);
    Explosion exp8 = new Explosion(3);
    Explosion exp9 = new Explosion(3);
    Explosion exp10 = new Explosion(3);
    Explosion exp11 = new Explosion(3);
    Explosion exp12 = new Explosion(3);
    Explosion exp13 = new Explosion(3);
    Explosion exp14 = new Explosion(3);
    Explosion exp15 = new Explosion(3);
    Explosion expPlayer = new Explosion(3);
    // End

    // Hiep
    public GameScene() {
        super();
    }

    public GameScene(String _name) {
        super(_name);
    }

    public GameScene(int _width, int _height) {
        super(_width, _height);
        this.setName("Game Scene");
    }

    public void startTimerAndInit() {
        this.timer = new Timer(20, this);
        this.init();
        this.timer.start();
    }
    // End

    @Override
    public void init() {
        // Hiep
        this.soundManager = new Sound();
        this.rand = new Random();
        this.spawner = new MonsterSpawner(this);
        this.invaders = new Vector<Invader>();
        this.invadersAlive = NUMBER_OF_MONSTERS;
        this.scoreManager = new ScoreManager();
        this.hasBegun = !this.hasBegun;
        this.bullet = new Projectile(200, 200);
        this.addPlayer();
        //        this.soundManager.GameStart();
        this.requestFocusInWindow();

        this.bullet.initBounds();

        this.playerhp.setForeground(Color.CYAN);
        this.playerhp.setVisible(true);
        this.playerhp.setBounds(540, 0, 100, 40);

        this.scoreplayer.setForeground(Color.CYAN);
        this.scoreplayer.setVisible(true);
        this.scoreplayer.setBounds(540, 15, 100, 40);

        this.add(this.playerhp, new Integer(Constants.LAYER_HUD));
        this.add(this.scoreplayer, new Integer(Constants.LAYER_HUD));
        this.add(this.bullet, new Integer(Constants.LAYER_PROJECTILE));

        testSpawnRandomMonsters();

        WindowManager.drawBackground(this);
        // End

        // Huy
        Explosion e = new Explosion(3);
        e.initBounds();
        explosions.add(e);
        this.add(e, new Integer(Constants.LAYER_PROJECTILE));
        this.explosionTest.setLocation(100, 100);
        this.add(explosionTest, new Integer(Constants.LAYER_PROJECTILE));
        // End
    }

    // Hiep
    public void reset() {
        this.rand = null;
        this.spawner = null;
        this.player = null;
        this.bullet = null;
        this.background = null;
        this.invaders.clear();
        this.invaders = null;
        this.soundManager = null;
        this.hasBegun = false;
        this.invadersAlive = 0;
        this.scores = 0;
    }
    // End

    public void addPlayer() {
        // Hoang
        String username = JOptionPane.showInputDialog("Enter your name: ");
        this.player = new Player("Player 1");
        // End

        // Hiep
        this.add(this.player, new Integer(Constants.LAYER_MOB));
        this.player.setLocation(270,330);
        // End
    }

    // Hiep
    public void draw(Graphics g) {
        if (this.hasBegun) {
            this.player.draw(g);
            this.bullet.draw(g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //        this.draw(g);
    }
    // End

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.hasBegun) {
            // Huy
            this.explosionTest.setLocation(100, 100);
            this.explosionTest.nextFrame();
            Explosion exp1 = explosions.firstElement();
            exp1.nextFrame();

            if (areInvadersDead()) {
//                                this.soundManager.WonGame();
//                                winCheck();
                System.out.println("All monsters killed");
            }

            if (isPlayerDead()) {
                this.soundManager.PlayerDeath();
                endGame();
            }
            this.moveInvaders();
            if(this.player.getLocation().getY()!=330)
                {
                    //                    this.player.setX(270);
                    //                    this.player.setY(330);
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
            playerhp.setText("HP: " + this.player.getHp());
            scoreplayer.setText("Score: " + this.scores);
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

            Rectangle[] arrRLabels= new Rectangle[invaders.size()];
            for(int i=0; i<invaders.size(); i++){
                arrRLabels[i]=invaders.get(i).getBounds();
            }
            for(Invader invader : invaders) {
                if (!invader.isDead()) {
                    if(invader.getBounds().intersects(this.bullet.getBounds()))
                        {
                            Explosion exp = explosions.firstElement();
                            exp.setLocation(invader.getX(), invader.getY());
                            exp.setActive(true);
                            exp.nextFrame();
                            exp.setLocation(invader.getX()+5, invader.getY()+5);
                            exp.setActive(true);
                            exp.nextFrame();
                            // End

                            // Hiep
                            Runnable changeStateOfExplosionWhichShouldReallyBeInsideTheExplosionClass = () -> {
                                setVisible(true);
                            };
                            changeStateOfExplosionWhichShouldReallyBeInsideTheExplosionClass.run();
                            Thread thread = new Thread(changeStateOfExplosionWhichShouldReallyBeInsideTheExplosionClass);
                            thread.start();
                            // End

                            this.bullet.setVelocity(0,0);
                            this.bullet.setY(999);

                            this.remove(invader);
                            this.invadersAlive--;
                            invader.setDead();
                            invader = null;
                            System.gc();
                            this.soundManager.MonsterDied();
                            this.scores++;
                            break;

                        }
                    if(invader.getBounds().intersects(this.player.getBounds())){
                       //huy
                        Explosion exp = explosions.firstElement();
                        exp.setLocation(invader.getX(), invader.getY());
                        exp.setActive(true);
                        exp.nextFrame();
                        exp.setLocation(invader.getX()+5, invader.getY()+5);
                        exp.setActive(true);
                        exp.nextFrame();
                        //end
                        this.player.setHp(this.player.getHp() - 2);
                    }
                }
            }
            if(scores>14){
                JOptionPane.showMessageDialog(null, "You WON. Your Scores: "+ scores);
                this.restartGame();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.hasBegun) {
            int code = e.getKeyCode();
            switch (code) {
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                this.player.setVelocity(-10, 0);
                if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(-5, 0);
                else
                    this.bullet.setVelocity(0,-10);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");

                this.player.setVelocity(10, 0);
                if(this.bullet.getVelY() == 0)
                    this.bullet.setVelocity(5, 0);
                else
                    this.bullet.setVelocity(0,-10);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_SPACE:
                System.out.println("Fire");
                this.player.setVelocity(0, 0);
                this.bullet.setVelocity(0, -10);
                if(this.bullet.getY() > 500)
                    {
                        this.bullet.setX(this.player.getX());
                        this.bullet.setY(this.player.getY());
                        this.soundManager.Shoot();
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

    // Hiep
    public void testSpawnMonster() {
        spawner.weakInvader(50, 50);
    }

    public void testSpawnRandomMonsters() {
        spawner.rowOfRandomWeakInvaders(500, 50, NUMBER_OF_MONSTERS);
    }

    public void testSpawnRandomMonster() {
        spawner.randomWeakInvader(500, 50);
    }

    public void testSpawnMonsterRow() {
        final int START_X = 50;
        final int START_Y = 0;
        final int MAX_MONSTERS = 10;

        spawner.alotOfWeakInvaders(START_X, START_Y, MAX_MONSTERS, 1);
    }

    public boolean areInvadersDead() {
        if (this.hasBegun && this.invadersAlive == 0) {
            System.out.println("Next wave...");
            this.invadersAlive = NUMBER_OF_MONSTERS;
            this.testKillAllInvaders();
            this.testSpawnRandomMonsters();
            return true;
        }
        return false;
    }

    public void deathCheck() {
        if (isPlayerDead()) {
            System.out.println("Player has died.");
        }
    }

    public void winCheck() {
        if (areInvadersDead()) {
            System.out.println("You won.");
            this.restartGame();
        }
    }

    public void testKillAllInvaders() {
        for (Invader a : invaders) {
            System.out.println(a.name);
            this.remove(a);
            a = null;
            System.gc();
        }
        this.invaders.clear();
    }

    public void addInvader(Invader invader) {
        this.invaders.add(invader);
    }

    public void moveInvaders() {
        for(Invader invader : invaders) {
            invader.moveDown();
            if (isInvaderOutOfBounds(invader)) {
                if (!invader.isDead()) {
                    //                    System.out.println("Invader has moved pass you.");
                    this.player.setHp(this.player.getHp() - 1);
                    this.deathCheck();
                }
            }
        }
    }

    public boolean isInvaderOutOfBounds(Invader invader) {
        return invader.getY() >= this.getHeight();
    }

    public boolean isPlayerDead() {
        return player.getHp() <= 0;
    }

    public void endGame() {
        System.out.println("Game has ended.");
        try {
            //            this.drawGameOver();
            Thread.sleep(5000);
            //            this.soundManager.stopSound();
        } catch (InterruptedException ex) {
        }

        if (this.restartGameAfterDeath) {
            this.restartGame();
        } else {
            // TODO: Goback to main window
        }
    }

    public void restartGame() {
        scoreManager.insertScore("0," + this.player.getName() + ",0,1," + this.scores);
        System.out.println("Restarting game...");
        this.removeAll();
        this.reset();
        this.revalidate();
        this.repaint();
        this.init();
    }

    // Nonworking
    public void drawGameOver() {
        Dimension size;
        this.gameOver = new Hud("GAME OVER", "Game over message", 200, 50, this);
        this.gameOver.setFont(new Font("Tahoma", 0, 72));
        this.gameOver.setForeground(Color.WHITE);
        this.gameOver.setText(this.gameOver.getName());
        size = this.gameOver.getPreferredSize();
        //        this.gameOver.setLocation((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
        //                               (Window.DEFAULT_HEIGHT / 2) - (size.height));
        this.gameOver.setBounds(this.gameOver.getX(),
                                this.gameOver.getY(),
                                size.width, size.height);
        this.add(this.gameOver, new Integer(Constants.LAYER_HUD));
    }
    // end

    public void end() {
    }
}
