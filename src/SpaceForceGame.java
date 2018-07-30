import javax.swing.*;

public class SpaceForceGame {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    GameScene gScene = new GameScene(Window.DEFAULT_WIDTH,
                                                     Window.DEFAULT_HEIGHT);
                    gScene.revalidate();
                    gScene.repaint();
                    Window window = new Window(Window.DEFAULT_WIDTH,
                                               Window.DEFAULT_HEIGHT, gScene);
                }
            });

    }
}
