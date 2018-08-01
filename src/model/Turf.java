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
        System.out.println("Cake");
        this.setCoord(50, 50);
        this.setImage("assets/sprites/ship_4030.png");
        this.setText(this.name);
        this.setVisible(true);
        this.printCoords();
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
