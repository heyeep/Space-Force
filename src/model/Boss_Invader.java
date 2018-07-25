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
public class Boss_Invader extends Invader {
    public Boss_Invader() {
        super();
        this.name = "Boss Invader";
        this.init();
    }

    public Boss_Invader(String _name) {
        super(_name);
        this.init();
    }

    public Boss_Invader(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Boss Invader.init()");
        this.setCoord(10, 10);
        this.hp = 100;
        this.maxHp = 100;
        this.speed = 30;
        this.setText(this.name);
    }

    public void draw(Graphics g) {
    }

    public void resize() {
    }

    public void setupIcon() {
        this.setIcon(new ImageIcon("../../../assets/sprites/enemy_4030.png"));
    }

    // TODO: Draw for Invader
    // Have to fix the changing of icons
    // inside Atom first
}

