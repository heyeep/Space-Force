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

    Timer timer;

    public Scene() {
        super(new FlowLayout(FlowLayout.LEADING));
        this.name = "Default Scene";
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public Scene(String _name) {
        this.name = _name;
    }

    public Scene(int _width, int _height) {
        super();
        setSize(_width, _height);
    }

    public abstract void init();

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
}
