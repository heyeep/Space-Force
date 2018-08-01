import java.awt.Color;
import java.awt.Graphics;

public abstract class Mob extends Atom {
    public int hp;
    public int maxHp;

    public static final int DEFAULT_MAX_HP = 10;
    public static final int DEFAULT_HP = 10;

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

    public void setHp(int _hp) {
        this.hp = _hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setMaxHp(int _maxHp) {
        this.maxHp = _maxHp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }
}
