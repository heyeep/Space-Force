import javax.swing.ImageIcon;
import java.awt.Graphics;

public abstract class Invader extends Mob {
    private boolean dead = false;

    public Invader() {
        super();
        this.name = "Invader";
    }

    public Invader(String _name) {
        super(_name);
    }

    public Invader(String _name, String _description) {
        super(_name, _description);
    }

    public abstract void init();

    public void draw(Graphics g) {
    }

    public void resize() {
    }

    public void moveDown() {
        if (!dead) {
            this.setCoord(this.getX(), this.getY() + this.getSpeed());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void setDead() {
        this.dead = true;
        this.setVisible(false);
    }

    public boolean isDead() {
        return dead;
    }
}
