// Hiep
import javax.swing.*;
import java.awt.*;

public abstract class Atom extends JLabel {
    protected Scene scene;
    protected String name;
    protected String description;
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
        this.setImage(_icon);
    }

    public Atom(String _name, String _description) {
        this.name = _name;
        this.description = _description;
    }

    public Atom(String _name, String _description, int _x, int _y) {
        this.name = _name;
        this.description = _description;
        if(_x>0 && _y>0)
            this.setCoord(_x, _y);
        else
            this.setCoord(0, 0);
    }

    public Atom(String _name, String _description, String _fileName) {
        this.name = _name;
        this.description = _description;
        this.setImage(_fileName);
    }

    public Atom(String _name, String _description, String _fileName,
                int _x, int _y) {
        this.name = _name;
        this.description = _description;
        this.setImage(_fileName);
        if(_x>0 && _y>0)
            this.setCoord(_x, _y);
        else
            this.setCoord(0, 0);
    }

    public Atom(String _name, String _description, String _fileName,
                int _x, int _y, Scene _scene) {
        this.name = _name;
        this.description = _description;
        this.setScene(_scene);
        this.setImage(_fileName);
        if(_x>0 && _y>0)
            this.setCoord(_x, _y);
        else
            this.setCoord(0, 0);
    }

    public Atom(String _name, String _description,
                int _x, int _y, Scene _scene) {
        this.name = _name;
        this.description = _description;
        this.setScene(_scene);
        if(_x>0 && _y>0)
            this.setCoord(_x, _y);
        else
            this.setCoord(0, 0);
    }

    public abstract void init();
    public abstract void draw(Graphics g);
    public abstract void resize();

    public void initBounds() {
        Dimension size;
        size = this.getPreferredSize();
        this.setBounds(this.getX(), this.getY(), size.width, size.height);
    }

    public void initBounds(int _x, int _y, int _width, int _height) {
        if(_x>0 && _y>0 && _width>0 && _height>0)
            this.setBounds(_x, _y, _width, _height);
        else
            this.setBounds(0, 0, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void setCoord(int _x, int _y) {
        if(_x>0 && _y>0)
            this.setLocation(_x, _y);
        else
            this.setLocation(0, 0);
    }

    public void setCoord(double _x, double _y) {
        if(_x>0 && _y>0)
            this.setLocation((int) _x, (int) _y);
        else
            this.setLocation(0, 0);
    }

    public void setX(int _x) {
        if(_x>0)
            this.setCoord(_x, (int) this.getLocation().getY());
        else
            this.setCoord(0, (int) this.getLocation().getY());
    }

    public void setX(double _x) {
        if(_x>0)
            this.setCoord((int)_x, (int) this.getLocation().getY());
        else
            this.setCoord(0, (int) this.getLocation().getY());
    }

    public int getX() {
        return (int) this.getLocation().getX();
    }

    public double getFloatX() {
        return this.getLocation().getX();
    }

    public void setY(int _y) {
        if(_y>0)
            this.setCoord((int) this.getLocation().getX(), _y);
        else
            this.setCoord((int) this.getLocation().getX(), 0);
    }

    public void setY(double _y) {
         if(_y>0)
            this.setCoord((int) this.getLocation().getX(), (int)_y);
        else
            this.setCoord((int) this.getLocation().getX(), 0);
    }

    public int getY() {
        return (int) this.getLocation().getY();
    }

    public double getFloatY() {
        return this.getLocation().getY();
    }

    public void setVelocity(int _velX, int _velY) {
        if(_velX>=0 && _velY>=0){
            this.velX = _velX;
            this.velY = _velY;
        }
        else{
            this.velX = 0;
            this.velY = 0;
        }
    }

    public void setVelX(int _velX) {
        if(_velX>=0)
            this.velX = _velX;
        else
            this.velX=0;
    }

    public int getVelX() {
        return this.velX;
    }

    public void setVelY(int _velY) {
        if(_velY>=0)
            this.velY = _velY;
        else
            this.velY=0;
    }

    public int getVelY() {
        return this.velY;
    }

    public void setSpeed(int _speed) {
        if(_speed>=0)
            this.speed = _speed;
        else
            this.speed=0;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setImage(ImageIcon _icon) {
        this.setIcon(_icon);
    }

    public void setImage(String _fileName) {
        this.setIcon(new ImageIcon(_fileName));
    }

    public void printCoords() {
        System.out.println("Coords: ("
                           + this.getLocation().getX() + ", "
                           + this.getLocation().getY() + ")");
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public void setScene(Scene _scene) {
        this.scene = _scene;
    }

    public Scene getScene() {
        return this.scene;
    }
}
