// Hiep
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.*;
import javax.swing.*;

import java.util.Vector;

public abstract class Scene extends JLayeredPane implements ActionListener, KeyListener {
    private String name;
    private Scene nextScene;

    Timer timer;

    public Scene() {
        this.name = "Default Scene";
        this.initAll();
    }

    public Scene(String _name) {
        this.name = _name;
    }

    public Scene(int _width, int _height) {
        this.setSize(_width, _height);
        this.initAll();
    }

    public void initAll() {
        Dimension panelSize = new Dimension(this.getWidth(), this.getHeight());
        this.setPreferredSize(panelSize);
        this.initListeners();
        this.setLayout(null);
    }

    public void initListeners() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setFocusTraversalKeysEnabled(false);
        this.setVisible(true);
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
