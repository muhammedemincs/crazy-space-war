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
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Graphics2D;

import javax.swing.JPanel;
// omerhanci

public class GamePanel extends javax.swing.JPanel{
	private GameMap map;
    private GameEngine gameEngine;
    private Ship ship;
    private ArrayList<Fire> fires;
    private HighScorePanel highScorePanel;
    private ArrayList<Enemy> enemies;
    private JPanel panel;

    public static final int WHEN = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	//Panel Dimensions
	public static final int WIDTH = 520;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	
	//Drawing 
	private Graphics2D g;
	private BufferedImage image;
	
	public GamePanel()
	{
		super(true);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	//GUIManager da oyunu baþlatýrken önce GamePanel ýn init() ini
	//sonra da GameEngine in gameStart() ýný çaðýrcaz
	//Bide GUIManager da draw() ve drawToScreen methodlarý olcak
	//içlerinde sadece GamePanel ýn ayný isimli methodlarýný çaðýrcaklar
	
	public void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
	}
	
	public void draw(Graphics2D g2d)
	{
		map = new GameMap();
		g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 1000, 600);
        g2d.setColor(Color.BLACK);
        map.draw(g2d);
        g2d.setColor(Color.WHITE);
        map.fill(g2d);
        g2d.drawImage(ship.getCurrentImage(), ship.getX(), ship.getY(), null);
        for(int i = 0; i < enemies.size(); i++){
        	g2d.drawImage(enemies.get(i).getCurrentImage(), enemies.get(i).getX(), enemies.get(i).getY(), null);
        }
        for(int i = 0; i < fires.size(); i++){
        	g2d.drawImage(fires.get(i).getCurrentImage(), fires.get(i).getX(), fires.get(i).getY(), null);
        }
        g2d.drawImage(fire.getCurrentImage(), fire.getX(), fire.getY(), null);
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
