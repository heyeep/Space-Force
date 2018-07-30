import java.awt.Color;
import java.awt.Graphics;

public  class Turf extends Atom {
    public Turf() {
        super("Default Turf", "None");
        this.init();
    }

    public Turf(String _name) {
        super(_name);
        this.init();
    }

    public Turf(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public Turf(String _name, String _description,
                String _fileName) {
        super(_name, _description, _fileName);
        this.init();
    }

    public void init() {

        this.setCoord(10, 10);
        this.setVisible(true);
    }

    public void draw(Graphics g) {
    }

    public void resize() {
    }

    public void paint() {
    }

    @Override
    public void paintComponent(Graphics g) {
    }
}
