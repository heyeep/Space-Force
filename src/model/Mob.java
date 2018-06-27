import java.awt.Color;
import java.awt.Graphics;

public abstract class Mob extends Atom {
    public int hp;
    public int maxHp;

    private final int DEFAULT_MAX_HP = 3;
    private final int DEFAULT_HP = 3;

    public Mob() {
        super("Default Mob", "None");
        this.hp = this.maxHp = DEFAULT_HP;
    }

    public Mob(String _name) {
        super(_name);
        this.hp = this.maxHp = DEFAULT_HP;
    }

    public Mob(String _name, String _description) {
        super(_name, _description);
        this.hp = this.maxHp = DEFAULT_HP;
    }

    public Mob(String _name, String _description, int _hp) {
        super(_name, _description);
        this.hp = this.maxHp = _hp;
    }

}
