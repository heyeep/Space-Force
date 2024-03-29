// Hiep
import java.awt.*;
import javax.swing.*;

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
        this.setName("Main Scene");
        this.setLayout(null);
        this.init();
    }

    public void init() {
        Dimension size = new Dimension();
        this.drawGameTitle(size);
        this.drawStartButton(size);
        this.drawScoreBoardButton(size);
        this.drawHelpButton(size);
        this.add(this.gameTitle, new Integer(Constants.LAYER_HUD));
        this.add(this.startButton, new Integer(Constants.LAYER_HUD));
        this.add(this.scoreBoardButton, new Integer(Constants.LAYER_HUD));
        this.add(this.helpButton, new Integer(Constants.LAYER_HUD));
    }

    public void reset() {
    }

    public void end() {
    }

    public void drawGameTitle(Dimension size) {
        this.gameTitle = new Hud("SPACE FORCE", "Title", 200, 50, this);
        this.gameTitle.setFont(new Font("Tahoma", 0, 72));
        this.gameTitle.setText(this.gameTitle.getName());
        size = gameTitle.getPreferredSize();
        this.gameTitle.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                 (Window.DEFAULT_HEIGHT / 2) - (size.height),
                                 size.width, size.height);
    }

    // Position numbers are honestly don't matter
    public void drawStartButton(Dimension size) {
        this.startButton = new Hud("START", "Start button", 200, 100, this);
        this.startButton.setFont(new Font("Tahoma", 0, 24));
        this.startButton.setText(this.startButton.getName());
        this.setNextScene(new GameScene (Window.DEFAULT_WIDTH,
                                         Window.DEFAULT_HEIGHT));
        size = this.startButton.getPreferredSize();
        this.startButton.setBounds((Window.DEFAULT_WIDTH / 2) - (size.width / 2),
                                   (Window.DEFAULT_HEIGHT / 2) + (size.height),
                                   size.width, size.height);
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
    }
}
