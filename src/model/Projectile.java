/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;
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
    {   this.x = x;
        this.y = y; }
    public Projectile() {
        this.setCoord(274, 400);
        this.init();    }
    public void tick()
    {   y -= 10;    }
    public void init() {
        this.setImage("assets/sprites/bullet.png");
        this.setVisible(true);  }
    //Ammo Select Screen, to be implemented once we figured out New Game Options.
    private JTextField textField = new JTextField();
    JFrame frame; 
    JFrame wpn;
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
    {   frame = new JFrame();
    	frame.setTitle("CHOOSE YOUR WEAPON");
    	frame.setSize(680, 350);
    	frame.getContentPane().setLayout(null);
    	frame.getContentPane().setBackground(Color.WHITE);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	label.setBounds(250, 200, 50, 50);
    	label.setForeground(Color.WHITE);
    	frame.add(label);
    	this.textField.setBounds(340, 250, 130, 60);
    	this.textField.setFont(new Font("Courier", Font.BOLD, 20));
    	this.textField.setEditable(false);
    	textField.setHorizontalAlignment(SwingConstants.RIGHT);
    	frame.add(this.textField);
    	JLabel Hev = new JLabel();
    	Hev.setIcon(new ImageIcon("assets/sprites/hev.png"));
    	Hev.setBounds(0,0,64,64);
    	frame.add(Hev);
    	buttonHeavy.setBounds(200, 250, 130, 60);
    	buttonHeavy.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonHeavy);
        JLabel Dub = new JLabel();
    	Dub.setIcon(new ImageIcon("assets/sprites/dbl.png"));
    	Dub.setBounds(0,64,64,64);
    	frame.add(Dub);
        buttonDouble.setBounds(450, 143, 100, 60);
        buttonDouble.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonDouble);
        JLabel Trip = new JLabel();
    	Trip.setIcon(new ImageIcon("assets/sprites/trip.png"));
    	Trip.setBounds(0,128,64,64);
    	frame.add(Trip);
        buttonTriple.setBounds(450, 32, 100, 60);
        buttonTriple.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonTriple);
        JLabel Rip = new JLabel();
    	Rip.setIcon(new ImageIcon("assets/sprites/rip.png"));
    	Rip.setBounds(0,192,64,64);
    	frame.add(Rip);
        buttonRipple.setBounds(560, 32, 100, 60);
        buttonRipple.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonRipple);
        JLabel Cone = new JLabel();
    	Cone.setIcon(new ImageIcon(""));
    	Cone.setBounds(0,256,64,64);
    	frame.add(Cone);
        buttonCone.setBounds(560, 143, 100, 60);
        buttonCone.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonCone);
        JLabel Snek = new JLabel();
    	Snek.setIcon(new ImageIcon("assets/sprites/snek.png"));
    	Snek.setBounds(0,320,64,64);
    	frame.add(Snek);
        buttonSnake.setBounds(10, 143, 100, 60);
        buttonSnake.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonSnake);
        JLabel Grn = new JLabel();
    	Grn.setIcon(new ImageIcon(""));
    	Grn.setBounds(0,384,64,64);
    	frame.add(Grn);
        buttonGrenade.setBounds(10, 32, 100, 60);
        buttonGrenade.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonGrenade);
        JLabel Rdm = new JLabel();
    	Rdm.setIcon(new ImageIcon("assets/sprites/rdm.png"));
    	Rdm.setBounds(0,448,64,64);
    	frame.add(Rdm);
        buttonRandom.setBounds(230, 143, 100, 60);
        buttonRandom.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonRandom);
        JLabel Lsr = new JLabel();
    	Lsr.setIcon(new ImageIcon(""));
    	Lsr.setBounds(0,512,64,64);
    	frame.add(Lsr);
        buttonLaser.setBounds(230, 32, 100, 60);
        buttonLaser.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonLaser);
        JLabel Sgn = new JLabel();
    	Sgn.setIcon(new ImageIcon("assets/sprites/sgn.png"));
    	Sgn.setBounds(0,576,64,64);
    	frame.add(Sgn);
        buttonShotgun.setBounds(340, 143, 100, 60);
        buttonShotgun.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonShotgun);
        JLabel Wall = new JLabel();
    	Wall.setIcon(new ImageIcon(""));
    	Wall.setBounds(0,640,64,64);
    	frame.add(Wall);
        buttonWall.setBounds(340, 32, 100, 60);
        buttonWall.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonWall);
        JLabel Line = new JLabel();
    	Line.setIcon(new ImageIcon(""));
    	Line.setBounds(0,704,64,64);
    	frame.add(Line);
        buttonLine.setBounds(120, 32, 100, 60);
        buttonLine.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonLine);
        JLabel Nuke = new JLabel();
    	Nuke.setIcon(new ImageIcon(""));
    	Nuke.setBounds(0,768,64,64);
    	frame.add(Hev);
        buttonNuke.setBounds(120, 143, 100, 60);
        buttonNuke.setFont(new Font("Arial", Font.PLAIN, 11));
        frame.add(buttonNuke);
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
        buttonWall.addActionListener(this);    }
    public void actionPerformed(ActionEvent event)
    {	java.lang.Object e = event.getSource();
    	if (e == buttonHeavy)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Hev");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	JLabel hev_ship = new JLabel();
        	hev_ship.setIcon(new ImageIcon("assets/sprites/heavy_ship.png"));
        	hev_ship.setBounds(0, 50, 40, 30);
        	frame.add(hev_ship);										}
    	else if(e == buttonDouble)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Dbl");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel dub_ship = new JLabel();
    		dub_ship.setIcon(new ImageIcon("assets/sprites/double_ship.png"));
    		dub_ship.setBounds(0, 50, 40, 30);
        	frame.add(dub_ship);										}
    	else if(e == buttonTriple)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Tpl");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel tpl_ship = new JLabel();
    		tpl_ship.setIcon(new ImageIcon("assets/sprites/triple_ship.png"));
    		tpl_ship.setBounds(0, 50, 40, 30);
        	frame.add(tpl_ship);										}
    	else if(e == buttonRipple)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Rpl");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel rip_ship = new JLabel();
    		rip_ship.setIcon(new ImageIcon("assets/sprites/ripple_ship.png"));
    		rip_ship.setBounds(0, 50, 40, 30);
        	frame.add(rip_ship);										}	
    	else if(e == buttonSnake)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Snk");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel snek_ship = new JLabel();
    		snek_ship.setIcon(new ImageIcon("assets/sprites/snek_ship.png"));
    		snek_ship.setBounds(0, 50, 40, 30);
        	frame.add(snek_ship);										}
    	else if(e == buttonRandom)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Rdm");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel rdm_ship = new JLabel();
    		rdm_ship.setIcon(new ImageIcon("assets/sprites/rdm_ship.png"));
    		rdm_ship.setBounds(0, 50, 40, 30);
        	frame.add(rdm_ship);										}
    	else if(e == buttonShotgun)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Sgn");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel sgn_ship = new JLabel();
    		sgn_ship.setIcon(new ImageIcon("assets/sprites/sgn_ship.png"));
    		sgn_ship.setBounds(0, 50, 40, 30);
        	frame.add(sgn_ship);										}
    	else if(e == buttonGrenade)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Gnd");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel gnd_ship = new JLabel();
    		gnd_ship.setIcon(new ImageIcon(""));
    		gnd_ship.setBounds(0, 50, 40, 30);
        	frame.add(gnd_ship);										}
    	else if(e == buttonLaser)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Las");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel las_ship = new JLabel();
    		las_ship.setIcon(new ImageIcon(""));
    		las_ship.setBounds(0, 50, 40, 30);
        	frame.add(las_ship);										}
    	else if(e == buttonLine)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Lne");
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel line_ship = new JLabel();
    		line_ship.setIcon(new ImageIcon(""));
    		line_ship.setBounds(0, 50, 40, 30);
        	frame.add(line_ship);										}
    	else if(e == buttonNuke)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Nuk");
    		wpn = new JFrame();
    		wpn.setTitle("Countdown to D E S T R U C T I O N");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.BLACK);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel nuke_ship = new JLabel();
    		nuke_ship.setIcon(new ImageIcon(""));
    		nuke_ship.setBounds(0, 50, 40, 30);
        	frame.add(nuke_ship);										}
    	else if(e == buttonCone)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Cne");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel cone_ship = new JLabel();
    		cone_ship.setIcon(new ImageIcon(""));
    		cone_ship.setBounds(0, 50, 40, 30);
        	frame.add(cone_ship);										}
    	else if(e == buttonWall)
    	{	this.textField.setText("");
    		this.textField.setText(this.textField.getText() + "Wll");	
    		wpn = new JFrame();
    		wpn.setTitle("");
    		wpn.setSize(400,400);
    		wpn.getContentPane().setLayout(null);
    		wpn.getContentPane().setBackground(Color.white);
    		wpn.setResizable(false);
    		wpn.setLocationRelativeTo(null);
    		wpn.setVisible(true);
    		wpn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    		JLabel wall_ship = new JLabel();
    		wall_ship.setIcon(new ImageIcon(""));
    		wall_ship.setBounds(0, 50, 40, 30);
        	frame.add(wall_ship);										}	}
    public void draw(Graphics g) {    }
    public void resize() {    }  
    void remove( ) {    }
    public void draw() {    }
    public double getTheX()
    {return x;}
    public void setX(double x)
    {this.x = x;}
    public double getTheY()
    {return y;}
    public void setY(double y)
    {  this.y = y;} }