/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Huy
 * keeps track of
 * setVisible
 * get and set int coordinates
 */
public class Explosion extends Object {
    private static final int MAX_FRAME =10;
    private int _frame;
    private int _slowFactor;
    private int _COUNT_BETWEEN_FRAMES;
    private boolean _active;

    public Explosion(int countBetweenFrames){
        this._COUNT_BETWEEN_FRAMES = countBetweenFrames;
        this.resetFrame();
        setVisible(true);
        this.setActive(false);
    }

    public boolean isActive(){
        return _active;
    }

    public void setActive(boolean flag){
        _active = flag;
        if (!flag) {
            hideIt();
        }
    }

    private void hideIt(){
        this.setLocation(999, 999);
    }

    public void resetFrame(){
        this._frame = 1;
        this.setFrame(this._frame);
        this._slowFactor = this._COUNT_BETWEEN_FRAMES;
    }

    private void setFrame(int frame){

        if(frame>0 && frame<=MAX_FRAME){
            //            System.out.println("---------------   bubble_explo" + frame + ".png ------------------");
            setIcon(new ImageIcon("assets/sprites/Bubble_Explo/bubble_explo" + frame + ".png"));
        }
    }

    public void nextFrame(){
        if (this.isActive()) {
            if(_frame < MAX_FRAME){
                if (this._slowFactor > 0){
                    --this._slowFactor;
                } else {
                    this._slowFactor = _COUNT_BETWEEN_FRAMES;
                    _frame++;
                    setFrame(_frame);
                }
            } else {
                //                System.out.println("HIDE EXPLOSION");
                this.setActive(false);
                this.setFrame(1);
            }
        } else {
            this.hideIt();
        }
    }

    // Hiep
    public void initBounds() {
        Dimension size;
        size = this.getPreferredSize();
        this.setBounds(this.getX(), this.getY(), size.width, size.height);
    }
    // End

    public void resize() {
    }

    public void draw(Graphics g) {
    }

    public void init() {
    }
}
