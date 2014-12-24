//Author: Erdinç
//Computations regarding GameMap
import java.awt.Rectangle;

import model.*;
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
		for( int i = 0; i < gameMap.bombs.size(); i++) {
			//check coordinate
			if ( gameMap.getShip().getXpos() == gameMap.bombs.get(i).getXpos() && 
					gameMap.getShip().getYpos() == gameMap.bombs.get(i).getYpos() )
				return true;
		}
		return false;
	}
	
	//check whether ship collide with powerUps
	public boolean checkPowerUp() {
		for( int i = 0; i < gameMap.powerUps.size(); i++) {
			//check coordinate
			if ( gameMap.getShip().getXpos() == gameMap.powerUps.get(i).getXpos() && 
					gameMap.getShip().getYpos() == gameMap.powerUps.get(i).getYpos() )
//				gameMap.getShip().getPowerUp( gameMap.powerUps.get(i));
				if ( gameMap.powerUps.get(i).getPowerUpkind() == 0) //add health
					gameMap.getShip().setLifeEnergy( gameMap.getShip().getLifeEnergy() + 1);
				else if ( gameMap.powerUps.get(i).getPowerUpkind() == 1) //speed up
//					gameMap.getShip().setSpeed( gameMap.getShip().getSpeed() * 2);
				else if ( gameMap.powerUps.get(i).getPowerUpkind() == 2) //destructive bullets
//					gameMap.getShip().setDestroyForce( gameMap.getShip().getDestroyForce() * 2);
		}
	}
	
	//check whether enemies collide with fires
	public int isEnemyDestroyed() {
		int enemyDestroyedNumber = 0;
		for( int i = 0; i < gameMap.fires.size(); i++) {
			for( int j = 0; j < gameMap.enemies.size(); j++) {
				//check coordinate, destroy objects if necessary
				if ( gameMap.fires.get(j).getXpos() == gameMap.enemies.get(i).getXpos() && 
						gameMap.fires.get(j).getYpos() == gameMap.enemies.get(i).getYpos() ) {
//					gameMap.enemies.get(i).isHit( gameMap.fires[i]);
					gameMap.enemies.get(j).setLifeEnergy(gameMap.enemies.get(j).getLifeEnergy() - gameMap.fires.get(i).getDestroyForce());
					gameMap.fires.remove(i);
					enemyDestroyedNumber++;
				}
			}
		}
		return enemyDestroyedNumber;
	}
	
	//move ship according to input from GameEngine
	public void moveShip( int input) {
		if ( input == 0) //left
			gameMap.getShip().setXpos( gameMap.getShip().getXpos() - 1);
		if ( input == 1) //right
			gameMap.getShip().setXpos( gameMap.getShip().getXpos() + 1);
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
				for ( int i = 0; i < gameMap.enemies.size(); i++)
					gameMap.enemies.get(i).setYpos( gameMap.enemies.get(i).getYpos() -1);
				enemyDirection = EnemyDirection.right;
			}
			//cannot go right, move down and turn left
			else if ( enemyClusterX == RIGHT_MOST_PIXEL && enemyDirection == EnemyDirection.right) {
				for ( int i = 0; i < gameMap.enemies.size(); i++)
					gameMap.enemies.get(i).setYpos( gameMap.enemies.get(i).getYpos() - 1);
				enemyDirection = EnemyDirection.left;
			}
			else if ( enemyDirection == EnemyDirection.right) {
				for ( int i = 0; i < gameMap.enemies.size(); i++)
					gameMap.enemies.get(i).setXpos( gameMap.enemies.get(i).getXpos() + 1);	
			}
			else if ( enemyDirection == EnemyDirection.left) {
				for ( int i = 0; i < gameMap.enemies.size(); i++)
					gameMap.enemies.get(i).setXpos( gameMap.enemies.get(i).getXpos() - 1);	
			}
		}
		//move fire and bomb objects
		for ( int i = 0; i < gameMap.bombs.size(); i++)
			gameMap.bombs.get(i).setYpos( gameMap.bombs.get(i).getYpos() - 1);
		for ( int i = 0; i < gameMap.fires.size(); i++)
			gameMap.fires.get(i).setYpos( gameMap.fires.get(i).getYpos() + 1);
	}
	
	//fire on input
	public void fire() {
		//create and set properties
		Fire fireObject = new Fire();
		fireObject.setYpos( gameMap.getShip().getYpos());
		fireObject.setXpos( gameMap.getShip().getXpos());
//		fireObject.setPower( gameMap.getShip().getPower());
		//add to fire list
		gameMap.fires.add( fireObject);
	}
	
	//enemies are chosen randomly to bomb
	public void enemyFire() {
		int bombNo = (int) (Math.random() * 5);
		int[] enemiesWhoShoot = new int[bombNo];
		//generate who shoot
		for ( int i = 0; i < bombNo; i++) {
			int newBomb = (int) (Math.random() * gameMap.enemies.size() );
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
//			gameMap.enemies.get(i).shoot();
			Bomb newBomb = new Bomb( gameMap.enemies.get( enemiesWhoShoot[i]).getEnemyKind(),
										gameMap.enemies.get( enemiesWhoShoot[i]).getXpos(),
										gameMap.enemies.get( enemiesWhoShoot[i]).getYpos(),
										new Rectangle() );
			gameMap.bombs.add(newBomb);
		}
	}
	
	//checks whether enemies reached end on Y-axis
	public boolean hasEnemyArrived() {
		for ( int i = 0; i < gameMap.enemies.size(); i++) {
			if ( gameMap.enemies.get(i).getYpos() == BOTTOM_MOST_PIXEL )
				return true;
		}
		return false;
	}

	//return number of remaining enemies
	public int getEnemyCount() {
		return gameMap.enemies.size();
	}
}