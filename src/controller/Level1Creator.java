package controller;
//Author: Erdinc
import java.awt.Rectangle;
//Description: creates all types of enemies, bind powerUps accordingly
import java.util.ArrayList;
import model.*;

public class Level1Creator extends LevelCreatorFactory {
	
	//constructor
	public Level1Creator() {
		numberOfEnemies = 15;
		typeOfEnemies = new int[3];
		typeOfEnemies[0] = 15;
		typeOfEnemies[1] = 0;
		typeOfEnemies[2] = 0;
		numberOfPowerUps = (int) ((Math.random() * 2) + 1);
	}
	
	//methods
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
				else //destructive power
					newPowerUp = new PowerUp(2,20, enemy.get(enemyBound).getXpos(), enemy.get(enemyBound).getYpos());
//				enemy.get( enemyBound).addPowerUp( newPowerUp);
				powerup.add( newPowerUp);
				enemiesBound[i] = enemyBound;
			}
			else
				i--;
		}
		return powerup;
	}
}