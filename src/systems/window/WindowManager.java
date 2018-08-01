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
}
