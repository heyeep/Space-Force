/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import javax.swing.ImageIcon;
import javax.swing.*;


/**
 *
 * @author Huy
 * keeps track of  
 * setVisible
 * get and set int coordinates
 */
public class Explosion extends JLabel{
    private static final int MAX_FRAME =10;
    private int _frame;
    private int _slowFactor;
    private int _COUNT_BETWEEN_FRAMES;
    private int _x, _y;
    
    public Explosion(int x, int y, int countBetweenFrames){
        this._frame = 1;
        this.setFrame(this._frame);
        this._COUNT_BETWEEN_FRAMES = countBetweenFrames;
        this._slowFactor = this._COUNT_BETWEEN_FRAMES;
        this._x = x;
        this._y = y;
        
        setVisible(true);

    }

    private void setFrame(int frame){
        if (frame>0 && frame <= MAX_FRAME){
            setIcon(new ImageIcon("bubble_explo" + frame + ".png"));
            setLocation(this._x, this._y);
        }
    }
    
    // returnFlag:  true    : explosion is already done
    //              false   : there is more explosion ahead 
    public boolean nextFrame(){
        if(_frame < MAX_FRAME){
            if (this._slowFactor > 0){
                --this._slowFactor;
            } else {
                this._slowFactor = _COUNT_BETWEEN_FRAMES;
                _frame++;
                setFrame(_frame);
            }
            return false;
        } else {
            setVisible(false);
            return true;
        }
    }
}

