/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mark Chang
 */
public class Boss_Invader extends Invader {
    int speed; //Speed at which the invader travels at, units: Pixels  
   public Boss_Invader() {
        super();
        this.name = "BossInvader";
        hp = 100;
        maxHp = 100;
        speed = 30;
    }

    public Boss_Invader(String _name) {
        super(_name);
    }

    public Boss_Invader(String _name, String _description) {
        super(_name, _description);
        this.init();
    }

    public void init() {
        System.out.println("Player.init()");
        this.setCoord(10, 10);
    }

    public void draw() {
        
    }

    public void resize() {
        
    }

    // TODO: Draw for Invader
    // Have to fix the changing of icons
    // inside Atom first
}
