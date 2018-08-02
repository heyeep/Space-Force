// Hiep

import java.util.*;

public class SceneManager {
    private Scene curScene;
    private Vector<Scene> scenes;

    public SceneManager() {
        this.scenes = new Vector<Scene>();
    }

    public SceneManager(Scene _initScene) {
        this.scenes = new Vector<Scene>();
        this.curScene = _initScene;
    }

    public void addScene(Scene _scene) {
        this.scenes.addElement(_scene);
        System.out.println(_scene.toString());
    }
}
