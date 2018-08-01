import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Hud extends Object implements MouseListener {
    public Hud() {
        this.init();
    }

    public Hud(String _name) {
        super(_name);
        this.init();
    }

    public Hud(String _name, ImageIcon _icon) {
        super(_name, _icon);
        this.init();
    }

    public Hud(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public Hud(String _name, String _description, int _x, int _y) {
        super(_name, _description, _x, _y);
        this.init();
    }

    public Hud(String _name, String _description, String _fileName) {
        super(_name, _description, _fileName);
        this.init();
    }

    public Hud(String _name, String _description, String _fileName,
               int _x, int _y) {
        super(_name, _description, _fileName, _x, _y);
        this.init();
    }

    public Hud(String _name, String _description, String _fileName,
               int _x, int _y, Scene _scene) {
        super(_name, _description, _fileName, _x, _y);
        this.init();
    }

    public Hud(String _name, String _description,
               int _x, int _y, Scene _scene) {
        super(_name, _description, _x, _y, _scene);
        this.init();
    }

    public void init() {
        this.setVisible(true);
        addMouseListener(this);
    }

    public void draw(Graphics g) {
    }

    public void resize() {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        this.doAction(this.getName());
    }

    public void doAction(String actionName) {
        //        System.out.println("doAction: " + actionName);
        switch (actionName) {
        case "START":
            WindowManager.startNewGame(this.getScene());
            break;
        case "SCOREBOARD":
            WindowManager.openScoreBoard();
            break;
        case "HELP":
            // Open help menu
            break;
        default:
            System.out.println("None");
        }
    }
}
