import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Object extends Atom {
    public Object() {
    }

    public Object(String _name) {
        super(_name);
    }

    public Object(String _name, ImageIcon _icon) {
        super(_name, _icon);
    }

    public Object(String _name, String _description) {
        super(_name, _description);
    }

    public Object(String _name, String _description, int _x, int _y) {
        super(_name, _description, _x, _y);
    }

    public Object(String _name, String _description, String _fileName) {
        super(_name, _description, _fileName);
    }

    public Object(String _name, String _description, String _fileName,
                  int _x, int _y) {
        super(_name, _description, _fileName, _x, _y);
    }
}
