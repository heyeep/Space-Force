// Hiep
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Icon {
    private Image image;

    public Icon() {
    }

    public Icon(Image _image) {
        this.image = _image;
    }

    public Icon(String _fileName) {
        ImageIcon icon = new ImageIcon(_fileName);
        this.image = icon.getImage();
    }

    public Image getImage() {
        return this.image;
    }
}
