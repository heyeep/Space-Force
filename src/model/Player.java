import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Mob {
    public Player() {
        super("Player", "PewPewPew");
        this.setText(this.name);
        this.init();
    }

    public Player(String _name) {
        super(_name);
        this.init();
    }

    public Player(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Player.init()");
        this.setCoord(100, 100);
        this.setText(this.name);
        this.setImage("../../assets/sprites/Potatoes.png");
        //        this.setImage("./Potatoes.png");
        //        this.setImage("~/School/summer/cs4310/spaceforce/assets/sprites/Potatoes.png");

        System.out.println("Icon Width: " + getIcon().getIconWidth());
        System.out.println("Icon Height: " + getIcon().getIconHeight());
    }

    public void draw() {
    }

    public void resize() {
    }

}
