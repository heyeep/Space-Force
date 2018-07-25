import javax.swing.ImageIcon;
import java.awt.Graphics;

public abstract class Invader extends Mob {
    public Invader() {
        super();
        this.name = "Invader";
    }

    public Invader(String _name) {
        super(_name);
    }

    public Invader(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Invader.init()");
        this.setCoord(10, 10);
        this.setText(this.name);
        this.setupIcon();
    }

    public void draw(Graphics g) {
        System.out.println("Cake");
    }

    public void resize() {
    }

    public abstract void setupIcon();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    // TODO: Draw for Invader
    // Have to fix the changing of icons
    // inside Atom first
}
