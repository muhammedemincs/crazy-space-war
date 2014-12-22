//Author: Erdinç
//Computations regarding GameMap
public class PhysicsEngine {
	
	//Attributes
	private enum EnemyDirection {left, right, up, down};
	private EnemyDirection enemyDirection;
	//
	private int LEFT_MOST_PIXEL = 30;
	private int RIGHT_MOST_PIXEL = 30;
	private int BOTTOM_MOST_PIXEL = 30;
	//
	private int enemyClusterX;
	private int ENEMY_MOVEMENT_COUNT;
	private GameMap gameMap;
	private int enemyMovementCounter;
	
	//Constructor
	public PhysicsEngine( GameMap gameMap, int difficulty) {
		enemyDirection = EnemyDirection.right;
		enemyMovementCounter = 0;
		ENEMY_MOVEMENT_COUNT = 0;
		this.gameMap = gameMap;
		ENEMY_MOVEMENT_COUNT = 15 / difficulty; //fix	
	}
	
	//Methods
	
	//checks whether ship has collided enemy
	public boolean checkCollision() {		
		for( int i = 0; i < gameMap.bombs.length; i++) {
			//check coordinate
			if ( gameMap.getShip().getX() == gameMap.bombs[i].getX() && 
					gameMap.getShip().getY() == gameMap.bombs[i].getY() )
				return true;
		}
		return false;
	}
	
	//check whether ship collide with powerUps
	public boolean checkPowerUp() {
		for( int i = 0; i < gameMap.powerUps.length; i++) {
			//check coordinate
			if ( gameMap.getShip().getX() == gameMap.powerUps[i].getX() && 
					gameMap.getShip().getY() == gameMap.powerUps[i].getY() )
				ship.getPowerUp( gameMap.powerUps[i]);
		}
	}
	
	//check whether enemies collide with fires
	public int isEnemyDestroyed() {
		int enemyDestroyedNumber = 0;
		for( int i = 0; i < gameMap.fires.length; i++) {
			for( int j = 0; j < gameMap.enemies.length; j++) {
				//check coordinate, destroy objects if necessary
				if ( gameMap.fires[i].getX() == gameMap.enemies[i].getX() && 
						gameMap.fires[i].getY() == gameMap.enemies[i].getY() ) {
					gameMap.enemies[i].isHit( gameMap.fires[i]);
					gameMap.fires[i].isHit();
					enemyDestroyedNumber++;
				}
			}
		}
		return enemyDestroyedNumber;
	}
	
	//move ship according to input from GameEngine
	public void moveShip( int input) {
		if ( input == 0) //left
			gameMap.getShip().setX( gameMap.getShip().getX( ) - 1);
		if ( input == 1) //right
			gameMap.getShip().setX( gameMap.getShip().getX( ) + 1);
//		if ( upPressed)
//			gameMap.getShip().setY( gameMap.getShip().getY( ) + 1);
//		if ( downPressed)
//			gameMap.getShip().setY( gameMap.getShip().getY( ) - 1);
	}
	
	//wrapper function for move objects, is called by game engine
	public void moveEnemies() {
		moveObjects();
		checkPowerUp();
		enemyFire();
	}
	
	//move enemies, fires, bombs
	public void moveObjects() {
		//enemies are not ready to move yet
		if ( enemyMovementCounter != ENEMY_MOVEMENT_COUNT) {
			enemyMovementCounter++;
		}
		//move enemies
		else {
			//cannot go left, move down and turn right
			if ( enemyClusterX == LEFT_MOST_PIXEL && enemyDirection == EnemyDirection.left) {
				for ( int i = 0; i < gameMap.enemies.length; i++)
					gameMap.enemies[i].setY( gameMap.enemies[i].getY() -1);
				enemyDirection = EnemyDirection.right;
			}
			//cannot go right, move down and turn left
			else if ( enemyClusterX == RIGHT_MOST_PIXEL && enemyDirection == EnemyDirection.right) {
				for ( int i = 0; i < gameMap.enemies.length; i++)
					gameMap.enemies[i].setY( gameMap.enemies[i].getY() -1);
				enemyDirection = EnemyDirection.left;
			}
			else if ( enemyDirection == EnemyDirection.right) {
				for ( int i = 0; i < gameMap.enemies.length; i++)
					gameMap.enemies[i].setX( gameMap.enemies[i].getX() + 1);	
			}
			else if ( enemyDirection == EnemyDirection.left) {
				for ( int i = 0; i < gameMap.enemies.length; i++)
					gameMap.enemies[i].setX( gameMap.enemies[i].getX() - 1);	
			}
		}
		//move fire and bomb objects
		for ( int i = 0; i < gameMap.bombs.length; i++)
			gameMap.bombs[i].setY( gameMap.bombs[i].getY() - 1);
		for ( int i = 0; i < gameMap.fires.length; i++)
			gameMap.fires[i].setY( gameMap.fires[i].getY() + 1);
	}
	
	//fire on input
	public void fire() {
		//create and set properties
		Fire fireObject = new Fire();
		fireObject.setY( gameMap.ship.getY());
		fireObject.setX( gameMap.ship.getX());
		fireObject.setPower( gameMap.ship.getPower());
		//add to fire list
		gameMap.fires.add( fireObject);
	}
	
	//enemies are chosen randomly to bomb
	public void enemyFire() {
		int bombNo = (int) (Math.random() * 5);
		int[] enemiesWhoShoot = new int[bombNo];
		//generate who shoot
		for ( int i = 0; i < bombNo; i++) {
			int newBomb = (int) (Math.random() * gameMap.enemies.length);
			//check that same enemies can't shoot twice
			boolean same=false;
			for ( int j =0 ; j < i; j++) {
				if ( enemiesWhoShoot[j] == newBomb)
					same = true;
			}
			//if same enemy shoots twice, reiterate
			if ( same)
				i--;
			else
				enemiesWhoShoot[i] = bombNo;
		}
		//when all is decided, prompt to shoot
		for(int i = 0; i < enemiesWhoShoot.length; i++) {
			gameMap.enemies[i].shoot();
		}
	}
	
	//checks whether enemies reached end on Y-axis
	public boolean hasEnemyArrived() {
		for ( int i = 0; i < gameMap.enemies.length; i++) {
			if ( gameMap.enemies[i].getY() == BOTTOM_MOST_PIXEL )
				return true;
		}
		return false;
	}
}
	//return number of remaining enemies
	public int getEnemyCount() {
		return gameMap.enemies.length;
	}