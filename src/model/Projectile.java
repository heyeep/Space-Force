/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nave
 */
public class Projectile extends Object implements ActionListener{
    
    private double x;
    private double y;
    
    public Projectile(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Projectile() {
        this.setCoord(274, 400);
        this.init();
    }
    
    public void tick()
    {
        y -= 10;
    }

    public void init() {
        this.setImage("assets/sprites/bullet.png");
        this.setVisible(true);
    }
    
    
    //Ammo Select Screen
    private JTextField textField = new JTextField();
    JFrame frame; 
    JLabel label = new JLabel();
    JButton buttonHeavy = new JButton("H");
    JButton buttonDouble = new JButton("D");
    JButton buttonTriple = new JButton("T");
    JButton buttonRipple = new JButton("R");
    JButton buttonSnake = new JButton("S");
    JButton buttonRandom = new JButton("Rdm");
    JButton buttonShotgun = new JButton("Sgun");
    JButton buttonGrenade = new JButton("G");
    JButton buttonLaser = new JButton("Las");
    JButton buttonLine = new JButton("L");
    JButton buttonNuke = new JButton("N");
    JButton buttonCone = new JButton("C");
    JButton buttonWall = new JButton("W");
    
    public void pallete()
    {
    	frame = new JFrame();
    	frame.setTitle("CHOOSE YOUR WEAPON");
    	frame.setSize(680, 275);
    	frame.getContentPane().setLayout(null);
    	frame.getContentPane().setBackground(Color.WHITE);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	label.setBounds(250, 200, 50, 50);
    	label.setForeground(Color.WHITE);
    	frame.add(label);
    	
    	this.textField.setBounds(340, 175, 130, 60);
    	this.textField.setFont(new Font("Courier", Font.BOLD, 20));
    	this.textField.setEditable(false);
    	textField.setHorizontalAlignment(SwingConstants.RIGHT);
    	frame.add(this.textField);
        
    	buttonHeavy.setBounds(200, 175, 130, 60);
    	buttonHeavy.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonHeavy);
 
        buttonDouble.setBounds(450, 100, 100, 60);
        buttonDouble.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonDouble);
 
        buttonTriple.setBounds(450, 30, 100, 60);
        buttonTriple.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonTriple);
 
        buttonRipple.setBounds(560, 30, 100, 60);
        buttonRipple.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonRipple);
        
        buttonSnake.setBounds(10, 100, 100, 60);
        buttonSnake.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonSnake);
 
        buttonRandom.setBounds(230, 100, 100, 60);
        buttonRandom.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonRandom);
 
        buttonShotgun.setBounds(340, 100, 100, 60);
        buttonShotgun.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonShotgun);
        
        buttonGrenade.setBounds(10, 30, 100, 60);
        buttonGrenade.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonGrenade);
 
        buttonLaser.setBounds(230, 30, 100, 60);
        buttonLaser.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonLaser);
 
        buttonLine.setBounds(120, 30, 100, 60);
        buttonLine.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonLine);
        
        buttonNuke.setBounds(120, 100, 100, 60);
        buttonNuke.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonNuke);

        buttonCone.setBounds(560, 100, 100, 60);
        buttonCone.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonCone);
 
        buttonWall.setBounds(340, 30, 100, 60);
        buttonWall.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonWall);
        
        buttonHeavy.addActionListener(this);
        buttonDouble.addActionListener(this);
        buttonTriple.addActionListener(this);
        buttonRipple.addActionListener(this);
        buttonSnake.addActionListener(this);
        buttonRandom.addActionListener(this);
        buttonShotgun.addActionListener(this);
        buttonGrenade.addActionListener(this);
        buttonLaser.addActionListener(this);
        buttonLine.addActionListener(this);
        buttonNuke.addActionListener(this);
        buttonCone.addActionListener(this);
        buttonWall.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	java.lang.Object e = event.getSource();
    	
    	if (e == buttonHeavy)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Hev");
    	}
    	
    	else if(e == buttonDouble)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Dbl");
    	}
    	
    	else if(e == buttonTriple)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Tpl");
    	}
    	
    	else if(e == buttonRipple)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Rpl");
    	}
    	
    	else if(e == buttonSnake)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Snk");
    	}
    	
    	else if(e == buttonRandom)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Rdm");
    	}
    	
    	else if(e == buttonShotgun)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Sgn");
    	}
    	
    	else if(e == buttonGrenade)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Gnd");
    	}
    	
    	else if(e == buttonLaser)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Las");
    	}
    	
    	else if(e == buttonLine)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Lne");
    	}
    	
    	else if(e == buttonNuke)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Nuk");
    	}
    	
    	else if(e == buttonCone)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Cne");
    	}
    	
    	else if(e == buttonWall)
    	{
    		this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Wll");
    	}
    }
    
    public void draw(Graphics g) {    }

    public void resize() {    }  

    void remove( ) {    }

    public void draw() {    }
    
    public double getTheX()
    {
        return x;
    }
    
    public void setX(double x)
    {
        this.x = x;
    }
    
    public double getTheY()
    {
        return y;
    }
    
    public void setY(double y)
    {  
        this.y = y;
    }

}
