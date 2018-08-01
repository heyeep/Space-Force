import java.util.Vector;
import java.util.Random;

public class MonsterSpawner {
    private GameScene scene;

    private final int xSpace = 32;
    private final int ySpace = 32;
    private final int spaceGap = 4;

    MonsterSpawner(GameScene _scene) {
        this.scene = _scene;
    }

    public void randomWeakInvader(int maxX, int y) {
        int randX = this.scene.rand.nextInt(maxX) + 1;
        Weak_Invader invader = new Weak_Invader();
        invader.setCoord(randX, y);
        invader.setLocation(1,0);
        //        invader.setX(randX);
        invader.printCoords();
        invader.setVisible(true);
        scene.addInvader(invader);
        scene.add(invader);
    }

    public void weakInvader(int x, int y) {
        Weak_Invader invader = new Weak_Invader();
        invader.setCoord(x, y);
        invader.initBounds();
        //        invader.printCoords();
        scene.addInvader(invader);
        scene.add(invader);
    }

    public void rowOfWeakInvaders(int startX, int startY, int numberOfMonsters) {
        int x_position = startX;
        while(numberOfMonsters > 0) {
            this.weakInvader(x_position, startY);
            x_position = x_position + startX;
            numberOfMonsters--;
        }
    }

    public void rowOfRandomWeakInvaders(int maxX, int startY, int numberOfMonsters) {
        while(numberOfMonsters > 0) {
            this.randomWeakInvader(maxX, startY);
            numberOfMonsters--;
        }
    }

    public void alotOfWeakInvaders(int startX, int startY, int numberOfMonsters, int numberOfRows) {
        int y_position = startY;
        while(numberOfRows > 0) {
            this.rowOfWeakInvaders(startX, y_position, numberOfMonsters);
            y_position += 32;
            numberOfRows--;
        }
    }
}
