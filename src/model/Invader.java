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
        //        this.setText(this.name);
    }

    public void draw(Graphics g) {
        System.out.println("Cake");
    }

    public void resize() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }
}
