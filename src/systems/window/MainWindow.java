import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainWindow extends Window {
    JMenuBar menuBar;
    JMenu startMenu;
    JMenu startMenuLevelOfDifficulty;
    JMenu scoresMenu;
    JMenu helpMenu;
    JMenuItem levelOfDifficultyGodMode;
    JMenuItem levelOfDifficultyDeathMode;
    JMenuItem levelOfDifficultyOne;
    JMenuItem levelOfDifficultyTwo;
    JMenuItem levelOfDifficultyThree;
    JMenuItem levelOfDifficultyFour;
    JMenuItem levelOfDifficultyFive;
    JMenuItem scoresPersonalAchievements;
    JMenuItem scoresBoard;
    JMenuItem helpInstructions;
    JMenuItem helpAbout;
    public MainWindow() {
        //        System.out.println("Main Window");
        this.init();
    }

    public MainWindow(int _width, int _height) {
        super(_width, _height);
        //        System.out.println("Main Window");
        this.init();
    }

    public MainWindow(int _width, int _height, Scene _scene) {
        super(_width, _height, _scene);
        //        System.out.println("Main Window");
        this.init();
    }

    public void init() {
        this.setName("Main Window");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setupMenus();
    }

    public void setupMenus() {
        this.menuBar = new JMenuBar();
        this.startMenu = new JMenu("Start Game");
        this.startMenuLevelOfDifficulty = new JMenu("Leve of Difficulty");
        this.scoresMenu = new JMenu("View Scores");
        this.helpMenu = new JMenu("Help");
        this.setupLevelOfDifficultyMenuItems();
        this.setupScoresMenuItems();
        this.setupHelpMenuItems();
        this.menuBar.add(startMenu);
        this.menuBar.add(scoresMenu);
        this.menuBar.add(helpMenu);
        this.setJMenuBar(this.menuBar);
    }

    public void setupLevelOfDifficultyMenuItems() {
        this.levelOfDifficultyGodMode = new JMenuItem("God Mode");
        this.levelOfDifficultyDeathMode = new JMenuItem("Death Mode");
        this.levelOfDifficultyOne = new JMenuItem("Level 1");
        this.levelOfDifficultyTwo = new JMenuItem("Level 2");
        this.levelOfDifficultyThree = new JMenuItem("Level 3");
        this.levelOfDifficultyFour = new JMenuItem("Level 4");
        this.levelOfDifficultyFive = new JMenuItem("Level 5");
        this.startMenu.add(this.levelOfDifficultyGodMode);
        this.startMenu.add(this.levelOfDifficultyDeathMode);
        this.startMenuLevelOfDifficulty.add(this.levelOfDifficultyOne);
        this.startMenuLevelOfDifficulty.add(this.levelOfDifficultyTwo);
        this.startMenuLevelOfDifficulty.add(this.levelOfDifficultyThree);
        this.startMenuLevelOfDifficulty.add(this.levelOfDifficultyFour);
        this.startMenuLevelOfDifficulty.add(this.levelOfDifficultyFive);
        this.startMenu.add(this.startMenuLevelOfDifficulty);
    }

    public void setupScoresMenuItems() {
        this.scoresPersonalAchievements = new JMenuItem("Personal Achievements");
        this.scoresBoard = new JMenuItem("Score Board");
        this.scoresMenu.add(this.scoresPersonalAchievements);
        this.scoresMenu.add(this.scoresBoard);
    }

    public void setupHelpMenuItems() {
        this.helpInstructions = new JMenuItem("Instructions");
        this.helpAbout = new JMenuItem("About");
        this.helpMenu.add(this.helpInstructions);
        this.helpMenu.add(this.helpAbout);
    }
}
