/**
 *
 * @author omerhanci

 */
package view;
import model.*;
import controller.*;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends javax.swing.JPanel{
	private GameMap gameMap;
    private GameEngine gameEngine;
    private HighScorePanel highScorePanel;
    private JPanel panel;

    public static final int WHEN = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	//Panel Dimensions
	public static final int WIDTH = 520;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	
	//Drawing 
	private Graphics2D g;
	private BufferedImage image;
	
	public GamePanel(GameMap gameMap)
	{
		super(true);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		this.gameMap = gameMap;
		keyListeners();
	}
	
	public void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		draw(g2d);
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1040, 600);
        g2d.drawImage(gameMap.getShip().getCurrentImage(), gameMap.getShip().getXpos(), gameMap.getShip().getYpos(), null); 
        
        for(int i = 0; i < gameMap.enemies.size(); i++){
        	g2d.drawImage(gameMap.enemies.get(i).getCurrentImage(), gameMap.enemies.get(i).getXpos(), gameMap.enemies.get(i).getYpos(), null);
        	
        }
        for(int i = 0; i < gameMap.fires.size(); i++){
        	g2d.drawImage(gameMap.fires.get(i).getCurrentImage(), gameMap.fires.get(i).getXpos(), gameMap.fires.get(i).getYpos(), null);
        }
        repaint();	
	}
	
	public void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, WIDTH * SCALE, null);
		g2.dispose();
		repaint();
	}
	
	public void keyListeners(){
		
		this.addKeyListener(new KeyAdapter() {
            
	        @Override
            public void keyReleased(KeyEvent e) {
	        	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            		gameEngine.setRightPressed(false);
            	}
            	else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            		gameEngine.setLeftPressed(false);
            	}
            	else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            		gameEngine.setSpacePressed(false);
            	}
            }
            
            @Override
            public void keyPressed(KeyEvent e){
            	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            		gameEngine.setRightPressed(true);
            	}
            	else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            		gameEngine.setLeftPressed(true);
            	}
            	else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            		gameEngine.setSpacePressed(true);
            	}
            }
        });
	}

	public void setEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
}
