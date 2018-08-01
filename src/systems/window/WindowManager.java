import javax.swing.*;

public class WindowManager {
    public static void startNewGame(Scene currentScene) {
        GameScene newGameScene =
            (GameScene) currentScene.getNextScene();
        SpaceForceGame.mainWindow.switchScene(currentScene,
                                              newGameScene);
        newGameScene.startTimerAndInit();
    }

    public void restartGame(GameScene currentScene) {
        currentScene.restartGame();
    }

    public static void openScoreBoard() {
        // This code came from Mark
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AllScoreJFrame().setVisible(true);
                }
            });
    }

    public static void drawBackground(Scene currentScene) {
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("assets/sprites/space.gif"));
        bg.setBounds(0,0, Window.DEFAULT_WIDTH, Window.DEFAULT_HEIGHT);
        currentScene.add(bg, new Integer(1));
    }
}
