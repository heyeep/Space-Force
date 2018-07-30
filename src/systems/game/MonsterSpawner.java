import java.util.Vector;

public class MonsterSpawner {
    private GameScene scene;

    private final int xSpace = 32;
    private final int ySpace = 32;
    private final int spaceGap = 4;

    MonsterSpawner(GameScene _scene) {
        this.scene = _scene;
    }

    public void weakInvader(int x, int y) {
        Weak_Invader invader = new Weak_Invader();
        invader.setCoord(x, y);
        invader.setVisible(true);
        scene.addInvader(invader);
        scene.add(invader);
    }

    public void rowOfWeakInvaders(int startX, int startY, int numberOfMonsters) {
        int x_position = startX;
        while(numberOfMonsters > 0) {
            this.weakInvader(x_position, startY);
            numberOfMonsters--;
        }
    }

    public void alotOfWeakInvaders(int startX, int startY, int numberOfMonsters, int numberOfRows) {
        int y_position = startY;
        while(numberOfRows > 0) {
            this.rowOfWeakInvaders(startX, y_position, numberOfMonsters);
            y_position += startY;
            numberOfRows--;
        }
    }
}
