/**
 *
 * @author omerhanci
 */
package view;
import javax.swing.JFrame;

import controller.*;
import model.*;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
public class GUIManager {
	private final static int WIDTH = 1000;
	private final static int HEIGHT = 1000;
	private JFrame frame;
	private JPanel currentPanel;
	private HelpPanel helpPanel;
	private MenuPanel menuPanel;
	private GamePanel gamePanel;
	private GameEngine gameEngine;
	private GameMap gameMap;
	private Graphics2D g2d;
	
	public GUIManager(JFrame f, GameMap gameMap){
		frame = f;
		this.gameMap = gameMap;
		menuPanel = new MenuPanel(this);
		gamePanel = new GamePanel(gameMap);
		currentPanel = menuPanel;
		setPanel(menuPanel);
	}
	public void setPanel(JPanel panel){
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	/*public void drawToScreen(){
		gamePanel.drawToScreen();
	}*/
	
	public void startGame(){
		setPanel(gamePanel);
		gamePanel.init();
		gameEngine.gameStart();
	}
	
	public void endGame(int score, boolean isInTop)
	{
		//display score
		if(isInTop)
		{
			//ask for name do sth 
			String name;	// get name
			//gameEngine.updateHighScores(name, score);
			//highScorePanel.editHighScore(name,score,place);
		}
	}
	public void setEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.gamePanel.setEngine(gameEngine);
	}
}
