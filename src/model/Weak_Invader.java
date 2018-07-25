import javax.swing.ImageIcon;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mark Chang
 */
public class Weak_Invader extends Invader {
    public Weak_Invader() {
        super();
        this.init();
    }

    public Weak_Invader(String _name) {
        super(_name);
        this.init();
    }

    public Weak_Invader(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Weak Invader.init()");
        this.name = "Weak Invader";
        this.setCoord(10, 10);
        this.hp = 20;
        this.maxHp = 100;
        this.speed = 5;
        this.setupIcon();
        this.setText(this.name);
        this.setVisible(true);
    }

    public void draw(Graphics g) {
    }

    public void resize() {

    }

    public void setupIcon() {
        //        this.setIcon(new ImageIcon("../../../assets/sprites/enemy_4030.png"));
        this.setIcon(new ImageIcon("enemy_4030.png"));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    // TODO: Draw for Invader
    // Have to fix the changing of icons
    // inside Atom first
}

