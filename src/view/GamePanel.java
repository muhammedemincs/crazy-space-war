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
        g2d.fillRect(0, 0, 1000, 600);
        g2d.drawImage(gameMap.getShip().getCurrentImage(), gameMap.getShip().getXpos(), gameMap.getShip().getYpos(), null);
        ArrayList<Enemy> enemies = gameMap.enemies; 
        for(int i = 0; i < enemies.size(); i++){
        	g2d.drawImage(enemies.get(i).getCurrentImage(), enemies.get(i).getXpos(), enemies.get(i).getYpos(), null);
        }
        ArrayList<Fire> fires = gameMap.fires;
        for(int i = 0; i < fires.size(); i++){
        	g2d.drawImage(fires.get(i).getCurrentImage(), fires.get(i).getXpos(), fires.get(i).getYpos(), null);
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

	public void keyController(){
		bind(KeyEvent.VK_RIGHT, new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent ae){
			gameEngine.setRightPressed(true);
		}
		}, "right pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameEngine.setRightPressed(false);
            }
        }, "right released");
        
        bind(KeyEvent.VK_LEFT, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameEngine.setLeftPressed(true);
            }
        }, "left pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameEngine.setLeftPressed(false);
            }
        }, "left released");
       
        bind(KeyEvent.VK_SPACE, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameEngine.setSpacePressed(true);
            }
        }, "space pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameEngine.setSpacePressed(false);
            }
        }, "space released");
	}
	private void bind(int key, AbstractAction onPressAction, String onPressDescription,
            AbstractAction onReleaseAction, String onReleaseDescription) {
        
        InputMap inputMap = panel.getInputMap(WHEN);
        ActionMap actionMap = panel.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(key,0,false), onPressDescription);
        actionMap.put(onPressDescription, onPressAction);
        inputMap.put(KeyStroke.getKeyStroke(key,0,true), onReleaseDescription);
        actionMap.put(onReleaseDescription, onReleaseAction);
    }
}
