import java.awt.Color;
import java.awt.Graphics;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Vector;

public abstract class Scene extends JPanel implements ActionListener, KeyListener {
    private String name;
    private Scene nextScene;

    Timer timer;

    public Scene() {
        //        super(new FlowLayout(FlowLayout.LEADING));
        this.name = "Default Scene";
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public Scene(String _name) {
        //        super(new FlowLayout(FlowLayout.LEADING));
        this.name = _name;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public Scene(int _width, int _height) {
        //        super(new FlowLayout(FlowLayout.LEADING));
        this.setSize(_width, _height);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public abstract void init();
    public abstract void reset();
    public abstract void end();

    public String toString() {
        return this.name;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        repaint();
    }

    public void setNextScene(Scene _nextScene) {
        this.nextScene = _nextScene;
    }

    public Scene getNextScene() {
        return this.nextScene;
    }
}
