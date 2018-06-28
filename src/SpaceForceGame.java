import javax.swing.*;

public class SpaceForceGame {
    public static void main(String args[]) {
       // Window window = new Window(Window.DEFAULT_WIDTH,
        //                           Window.DEFAULT_HEIGHT);
        GameScene gScene = new GameScene(Window.DEFAULT_WIDTH,
                                         Window.DEFAULT_HEIGHT);
        gScene.revalidate();
        gScene.repaint();
        //window.addScene(gScene);
        Window window = new Window(Window.DEFAULT_WIDTH,
                                   Window.DEFAULT_HEIGHT, gScene);
    }

}
