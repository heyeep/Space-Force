import java.awt.*;

public class MainScene extends Scene {
    private Hud gameTitle;
    private Hud startButton;

    public MainScene() {
        super();
    }

    public MainScene(String _name) {
        super(_name);
    }

    public MainScene(int _width, int _height) {
        super(_width, _height);
        //        this.startTimeAndInit();
        this.setLayout(null);
        this.init();
    }

    public void init() {
        Dimension size = new Dimension();
        this.drawGameTitle(size);
        this.drawStartButton(size);
        this.add(startButton);
    }

    public void reset() {
    }

    public void end() {
    }

    public void drawGameTitle(Dimension size) {
        gameTitle = new Hud("SPACE FORCE", "Title", 200, 50);
        gameTitle.setFont(new Font("Tahoma", 0, 72));
        //        gameTitle.setName("Space Force");
        gameTitle.setText(gameTitle.getName());
        size = gameTitle.getPreferredSize();
        gameTitle.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                            (Window.DEFAULT_HEIGHT / 2) - (size.height),
                             size.width, size.height);
        this.add(gameTitle);
    }

    public void drawStartButton(Dimension size) {
        startButton = new Hud("START", "Start button", 200, 100);
        startButton.setFont(new Font("Tahoma", 0, 24));
        //        startButton.setName("Start");
        startButton.setText(startButton.getName());
        size = startButton.getPreferredSize();
        startButton.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                            (Window.DEFAULT_HEIGHT / 2) + (size.height),
                             size.width, size.height);
        this.add(startButton);
    }
}
