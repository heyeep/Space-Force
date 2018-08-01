import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainWindow extends Window {
    JMenuBar menuBar;
    JMenu startMenu;
    JMenu startMenuLevelOfDifficulty;
    JMenu scoresMenu;
    JMenu helpMenu;
    JMenuItem levelOfDifficultyRestart;
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
        this.levelOfDifficultyRestart = new JMenuItem("Restart");
        this.levelOfDifficultyGodMode = new JMenuItem("God Mode");
        this.levelOfDifficultyDeathMode = new JMenuItem("Death Mode");
        this.levelOfDifficultyOne = new JMenuItem("Level 1");
        this.levelOfDifficultyTwo = new JMenuItem("Level 2");
        this.levelOfDifficultyThree = new JMenuItem("Level 3");
        this.levelOfDifficultyFour = new JMenuItem("Level 4");
        this.levelOfDifficultyFive = new JMenuItem("Level 5");
        this.levelOfDifficultyRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuRestartGame(evt);
            }
        });
        this.levelOfDifficultyGodMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuGodMode(evt);
            }
        });
        this.levelOfDifficultyDeathMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuDeathMode(evt);
            }
        });
        this.levelOfDifficultyOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuLevelOne(evt);
            }
        });
        this.levelOfDifficultyTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuLevelTwo(evt);
            }
        });
        this.levelOfDifficultyThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuLevelThree(evt);
            }
        });
        this.levelOfDifficultyFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuLevelFour(evt);
            }
        });
        this.levelOfDifficultyFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startMenuLevelFive(evt);
            }
        });
        this.startMenu.add(this.levelOfDifficultyRestart);
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
        this.scoresPersonalAchievements.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                scoresMenuShowPersonalAchievements(evt);
            }
        });
        this.scoresBoard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                scoresMenuShowScores(evt);
            }
        });
        this.scoresMenu.add(this.scoresPersonalAchievements);
        this.scoresMenu.add(this.scoresBoard);
    }

    public void setupHelpMenuItems() {
        this.helpInstructions = new JMenuItem("Instructions");
        this.helpAbout = new JMenuItem("About");
        this.helpInstructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpMenuShowInstructions(evt);
            }
        });
        this.helpAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpMenuShowAbout(evt);
            }
        });
        this.helpMenu.add(this.helpInstructions);
        this.helpMenu.add(this.helpAbout);
    }

    public void startMenuRestartGame(ActionEvent evt) {
        if (this.isCurrentlyPlayingAGame()) {
            GameScene currentScene = (GameScene) this.getScene();
            currentScene.restartGame();
        }
    }
    public void startMenuGodMode(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("God Mode");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuDeathMode(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("DeathMode");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuLevelOne(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("Level One");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuLevelTwo(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("Level Two");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuLevelThree(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("Level Three");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuLevelFour(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("Level Four");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void startMenuLevelFive(ActionEvent evt) {
        if (!this.isCurrentlyPlayingAGame()) {
            this.printTODO("Level Five");
        }
        this.showCurrentlyPlayingAGameMessage();
    }

    public void scoresMenuShowPersonalAchievements(ActionEvent evt) {
        this.printTODO("Show Personal Achievements");
    }

    public void scoresMenuShowScores(ActionEvent evt) {
        WindowManager.openScoreBoard();
    }

    public void helpMenuShowInstructions(ActionEvent evt) {
        this.printTODO("Show Instructions");
    }

    public void helpMenuShowAbout(ActionEvent evt) {
        this.printTODO("Show About");
    }

    public void printTODO(String _string) {
        System.out.println("TODO" + (_string.length() > 0 ? ": " + _string : ""));
    }

    public boolean isCurrentlyPlayingAGame() {
        return this.getScene() instanceof GameScene;
    }

    public void showCurrentlyPlayingAGameMessage() {
        System.out.println("Cannot start this mode while playing a game.");
    }
}
