import java.util.Vector;


public class GameEngine {
	private GameMap gameMap;
	private GamePanel gamePanel;
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
	GameEngine( GamePanel gamePanel, GameMap gameMap, int level, int diff)
	{
		this.gameMap = gameMap;
		this.gamePanel = gamePanel;
		this.level = level;
		this.difficulty = diff;
		score = 0;
		remainingLife = 3;
		leftPressed = false;
		rightPressed = false;
		spacePressed = false;
		powerUp = 0;
		physicsEngine = new PhysicsEngine( gameMap);
	}
	
	//Setter
	void setLeftPressed(boolean b){
		leftPressed = b;
	}
	void setRightPressed(boolean b){
		rightPressed = b;
	}
	void setSpacePressed(boolean b){
		spacePressed = b;
	}
	
	//Methods
	void gameStart()
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
		gamePanel.init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			
			updateGame();
			gamePanel.draw();
			gamePanel.drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if( wait < 0) wait = 5;
			try{
				Thread.sleep(wait);
			}catch(Exception e) {
				e.printStackTrace();
			}		
			
		}
		
		gamePanel.endGame(); //end game and show score 
							//calls isInTop() & ask for name etc.
	}
	 
	void updateGame()
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

	public boolean setShipModel(int model)
	{
		return gameMap.setShipModel(model);
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
	
	public Vector getHighScores()
	{
		return gameMap.getHighScores();
	}
	
	public boolean isInTop(int score)
	{
		return gameMap.isInTop(score);
		
	}
	
	public void updateHighScores(String name, int score)
	{
		gameMap.updateHighScores(name, score);
	}
		
}

