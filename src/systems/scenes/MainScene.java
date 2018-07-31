import java.awt.*;

public class MainScene extends Scene {
    private Hud gameTitle;
    private Hud startButton;
    private Hud scoreBoardButton;
    private Hud helpButton;

    public MainScene() {
        super();
    }

    public MainScene(String _name) {
        super(_name);
    }

    public MainScene(int _width, int _height) {
        super(_width, _height);
        this.setLayout(null);
        this.init();
    }

    public void init() {
        Dimension size = new Dimension();
        this.drawGameTitle(size);
        this.drawStartButton(size);
        this.drawScoreBoardButton(size);
        this.drawHelpButton(size);
        this.add(startButton);
        this.add(scoreBoardButton);
        this.add(helpButton);
    }

    public void reset() {
    }

    public void end() {
    }

    public void drawGameTitle(Dimension size) {
        this.gameTitle = new Hud("SPACE FORCE", "Title", 200, 50);
        this.gameTitle.setFont(new Font("Tahoma", 0, 72));
        this.gameTitle.setText(this.gameTitle.getName());
        size = gameTitle.getPreferredSize();
        this.gameTitle.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                 (Window.DEFAULT_HEIGHT / 2) - (size.height),
                                 size.width, size.height);
        this.add(this.gameTitle);
    }

    // Position numbers are honestly don't matter
    public void drawStartButton(Dimension size) {
        this.startButton = new Hud("START", "Start button", 200, 100);
        this.startButton.setFont(new Font("Tahoma", 0, 24));
        this.startButton.setText(this.startButton.getName());
        size = this.startButton.getPreferredSize();
        this.startButton.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                   (Window.DEFAULT_HEIGHT / 2) + (size.height),
                                   size.width, size.height);
        this.add(this.startButton);
    }

    // Position numbers are honestly don't matter
    public void drawScoreBoardButton(Dimension size) {
        this.scoreBoardButton = new Hud("SCOREBOARD", "Scoreboard button", 200, 100);
        this.scoreBoardButton.setFont(new Font("Tahoma", 0, 18));
        this.scoreBoardButton.setText(this.scoreBoardButton.getName());
        size = this.scoreBoardButton.getPreferredSize();
        this.scoreBoardButton.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                        (Window.DEFAULT_HEIGHT / 2) + this.startButton.getPreferredSize().height * 2,
                                        size.width, size.height);
        this.add(this.scoreBoardButton);
    }

    // Position numbers are honestly don't matter
    public void drawHelpButton(Dimension size) {
        this.helpButton = new Hud("HELP", "Help button", 200, 100);
        this.helpButton.setFont(new Font("Tahoma", 0, 18));
        this.helpButton.setText(this.helpButton.getName());
        size = this.helpButton.getPreferredSize();
        this.helpButton.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                  (Window.DEFAULT_HEIGHT / 2)
                                  + (this.startButton.getPreferredSize().height * 3) - 6,
                                        size.width, size.height);
        this.add(this.helpButton);
    }
}
