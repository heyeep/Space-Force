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
public class Strong_Invader extends Invader {
    int speed; //Speed at which the invader travels at, units: Pixels
    public Strong_Invader() {
        super();
        this.name = "StrongInvader";
        hp = 40;
        maxHp = 100;
        speed = 10;
    }

    public Strong_Invader(String _name) {
        super(_name);
    }

    public Strong_Invader(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Player.init()");
        this.setCoord(10, 10);
    }

    public void draw() {
    }

    public void resize() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

}
