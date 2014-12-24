package controller;
import java.util.Vector;
import view.*;
import model.*;

public class GameEngine {
	private GameMap gameMap;
	private GameData gameData;
	private GUIManager guiManager;
	private PhysicsEngine physicsEngine;
	
	private int score;
	private int level;
	private int difficulty;
	private int remainingLife;
	private int powerUp;
	
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean spacePressed;
	
	//main loop
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	//Constructor
	GameEngine( GUIManager guiManager, GameMap gameMap, GameData gameData, int level, int diff)
	{
		this.gameMap = gameMap;
		this.gameData = gameData;
		this.guiManager = guiManager;
		this.level = level;
		this.difficulty = diff;
		score = 0;
		remainingLife = 3;
		leftPressed = false;
		rightPressed = false;
		spacePressed = false;
		setPowerUp(0);
		physicsEngine = new PhysicsEngine( gameMap, difficulty);
	}
	
	//Getter
	public int getScore()
	{
		return score;
	}
	
	//Setter
	public void setLeftPressed(boolean b){
		leftPressed = b;
	}
	public void setRightPressed(boolean b){
		rightPressed = b;
	}
	public void setSpacePressed(boolean b){
		spacePressed = b;
	}
	
	//Methods
	public void gameStart()
	{
		gameMap.setMap(level,difficulty);
		if( thread == null)
		{
			running = true;
			thread = new Thread();
			thread.start();
		}
			
	}
	
	//game loop
	public void run()
	{
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			
			updateGame();
			guiManager.draw();
			guiManager.drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if( wait < 0) wait = 5;
			try{
				Thread.sleep(wait);
			}catch(Exception e) {
				e.printStackTrace();
			}		
			
		}
		
		guiManager.endGame(); //end game and show score 
							//calls isInTop() & ask for name etc.
	}
	 
	public void updateGame()
	{
		physicsEngine.moveEnemies();
		if ( leftPressed) physicsEngine.moveShip(0);
		if ( rightPressed) physicsEngine.moveShip(1);
		if( spacePressed) physicsEngine.fire();
		
		leftPressed = rightPressed = spacePressed = false;
		
		boolean shipCollision = physicsEngine.checkCollision(); //ship vs. enemies & bombs
		if( shipCollision) remainingLife--;
		
		int enemyDestroyed = physicsEngine.isEnemyDestroyed(); //enemies vs. & fires
		score += enemyDestroyed;
		
		if( isGameOver()) running = false;
	}

	public void setShipModel(int model)
	{
		gameMap.setShipModel(model);
	}
	
	public int getEnemyCount()
	{
		return physicsEngine.getEnemyCount();
	}
	
	public boolean isDestroyed()
	{
		if( remainingLife == 0)
			return true;
		return false;
	}
	
	
	public boolean isGameOver()
	{
		if( isDestroyed() || physicsEngine.hasEnemyArrived())
			return true;
		
		return false;
	}
	
	public ArrayList<String> getHighScores()
	{
		return gameData.getHighScores();
	}
	
	public boolean isInTop(int score)
	{
		return gameData.isInTop(score);
		
	}
	
	public void updateHighScores(String name, int score)
	{
		gameData.updateHighScores(name, score);
	}

	public int getPowerUp() {
		return powerUp;
	}

	public void setPowerUp(int powerUp) {
		this.powerUp = powerUp;
	}
		
}

