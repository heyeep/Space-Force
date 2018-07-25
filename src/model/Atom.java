/**
 * @author Hiep Nguyen
 */
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Atom extends JLabel {
    // TODO: Write setters/getters for name
    protected String name;

    // TODO: Write setters/getters for description
    protected String description;

    // TODO: Write setters/getters for density
    protected boolean density;

    protected int velX;
    protected int velY;

    protected int speed;

    public Atom() {
        this.name = "None";
        this.description = "None";
    }

    public Atom(String _name) {
        this.name = _name;
        this.description = "None";
    }

    public Atom(String _name, ImageIcon _icon) {
        this.name = _name;
        this.description = "None";
        this.setIcon(_icon);
    }

    public Atom(String _name, String _description) {
        this.name = _name;
        this.description = _description;
    }

    public Atom(String _name, String _description, String _fileName) {
        this.name = _name;
        this.description = _description;
        this.setIcon(new ImageIcon(_fileName));
    }

    public abstract void init();
    public abstract void draw(Graphics g);
    public abstract void resize();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void setCoord(int _x, int _y) {
        this.setLocation(_x, _y);
        this.printCoords();
    }

    public void setCoord(double _x, double _y) {
        this.setLocation((int) _x, (int) _y);
        this.printCoords();
    }

    public void setX(int _x) {
        this.setCoord(_x, (int) this.getLocation().getY());
    }

    // public void setX(double _x) {
    //     this.setCoord((int) _x, (int) this.getLocation().getY());
    // }

    // public int getX() {
    //     return (int) this.getLocation().getX();
    // }

    public double getFloatX() {
        return this.getLocation().getX();
    }

    public void setY(int _y) {
        this.setCoord((int) this.getLocation().getX(), _y);
    }

    public void setY(double _y) {
        this.setCoord((int) _y, (int) this.getLocation().getY());
    }

    public int getY() {
        return (int) this.getLocation().getY();
    }

    public double getFloatY() {
        return this.getLocation().getY();
    }

    public void setVelocity(int _velX, int _velY) {
        this.velX = _velX;
        this.velY = _velY;
    }

    public void setVelX(int _velX) {
        this.velX = _velX;
    }

    public int getVelX() {
        return this.velX;
    }

    public void setVelY(int _velY) {
        this.velY = _velY;
    }

    public int getVelY() {
        return this.velY;
    }

    public void setSpeed(int _speed) {
        this.speed = _speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    // TODO: Fix Image
    public void setImage(ImageIcon _icon) {
        this.setIcon(_icon);
    }

    public void setImage(String _fileName) {
        System.out.println("Atom.init(): " + _fileName);
        this.setIcon(new ImageIcon(_fileName));
    }

    //    public Image getIcon() {
    //        return this.icon;
    //    }

    public void printCoords() {
        System.out.println("Coords: ("
                           + this.getLocation().getX() + ", "
                           + this.getLocation().getY() + ")");
    }
}
