// Hiep
import java.awt.*;
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
        this.setHp(Mob.DEFAULT_MAX_HP);
        this.setText(this.name);
        this.setImage("assets/sprites/ship_4030.png");
        this.initBounds();
    }

    public void draw(Graphics g) {
    }

    public void resize() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

}
