import javax.swing.*;

public class Window extends JFrame {
    static final int DEFAULT_WIDTH = 256;
    static final int DEFAULT_HEIGHT = 256;
    static final String title = "Space Force";

    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;

    public Window() {
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
