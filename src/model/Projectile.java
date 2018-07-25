/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Nave
 */
public class Projectile extends Object {

    private double x;
    private double y;

    public Projectile(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Projectile() {}

    public void tick()
    {
        y -= 10;
    }

    public void init(){
        System.out.print("Projectile.init()");
        this.setCoord(274, 400);
        this.setImage("bullet.png");
        System.out.println("Projectile Width: " + getIcon().getIconWidth());
        System.out.println("Projectile Height: " + getIcon().getIconHeight());
    }

    public void resize(){    }

    void remove( ) {
        //draw();
        //revalidate();
    }

    @Override
    public void draw(Graphics g) {
    }
}
