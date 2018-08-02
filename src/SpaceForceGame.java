// Hiep
import javax.swing.*;

public class SpaceForceGame {
    public static MainWindow mainWindow;
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainScene mScene = new MainScene(Window.DEFAULT_WIDTH,
                                                     Window.DEFAULT_HEIGHT);
                    mScene.revalidate();
                    mScene.repaint();
                    mainWindow = new MainWindow(Window.DEFAULT_WIDTH,
                                                        Window.DEFAULT_HEIGHT,
                                                        mScene);
                }
            });

    }
}
