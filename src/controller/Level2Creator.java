package controller;
import java.awt.Rectangle;
import java.util.ArrayList;

import model.*;
public class Level2Creator extends LevelCreatorFactory{
	
	//constructor
	public Level2Creator() {
		numberOfEnemies = 15;
		typeOfEnemies = new int[3];
		typeOfEnemies[0] = 10;
		typeOfEnemies[1] = 5;
		typeOfEnemies[2] = 0;
		numberOfPowerUps = (int) ((Math.random() * 3) + 1);	
	}
	
	public ArrayList<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		//enemy type 0
		for ( int j = 0; j < typeOfEnemies[0]; j++) {
			enemies.add( new Enemy(0,j,2,new Rectangle()));
		}
		//enemy type 1
		for ( int j = 0; j < typeOfEnemies[1]; j++) {
			enemies.add( new Enemy(1,j,1,new Rectangle() ));
		}
		//enemy type 2
		for ( int j = 0; j < typeOfEnemies[2]; j++) {
			enemies.add( new Enemy(2,j,0,new Rectangle() ));
		}
		return enemies;	
	}
	
	public ArrayList<PowerUp> createPowerUp() {
		//decide type of power ups
		int type;
		ArrayList<PowerUp> powerup = new ArrayList<PowerUp>();
		int[] enemiesBound = new int[ numberOfPowerUps];
		int enemyBound;
		boolean bound;
		
		for ( int i = 0; i < numberOfPowerUps; i++) {
			bound = false;
			type = (int)(Math.random() * 3);
			//bind powerUp to an enemy
			enemyBound = (int) (Math.random() * numberOfEnemies);
			for ( int j = 0; j < numberOfPowerUps; j++)
				if ( enemiesBound[j] == enemyBound)
					bound = true;
			if ( !bound) {
				PowerUp newPowerUp;
				if ( type == 0) //add health
					newPowerUp = new PowerUp(0,0, enemy.get(enemyBound).getXpos(), enemy.get(enemyBound).getYpos());
				else if ( type == 1) //speed up
					newPowerUp = new PowerUp(1,20, enemy.get(enemyBound).getXpos(), enemy.get(enemyBound).getYpos());
				else if ( type == 2) //destructive power
					newPowerUp = new PowerUp(2,20, enemy.get(enemyBound).getXpos(), enemy.get(enemyBound).getYpos());
				enemy.get( enemyBound).addPowerUp( newPowerUp);
				enemiesBound[i] = enemyBound;
				powerup.add( newPowerUp);
			}
			else
				i--;
		}
		return powerup;
	}
}
