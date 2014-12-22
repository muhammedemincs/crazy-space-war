//Author: Erdinc
//Description: creates all types of enemies, bind powerups accordingly
package src;

public class Level1Creator {
	
	//attributes
	int numberOfEnemies;
	int[] typeOfEnemies;
	int numberOfPowerUps;
	
	//constructor
	public Level1Creator() {
		super();
		numberOfEnemies = 15;
		typeOfEnemies = new int[3];
		numberOfPowerUps = (int) ((Math.random() * 2) + 1);
	}
	//methods
	public ArrayList<Enemy> createEnemies() {
		for ( int i = 0; i < typeOfEnemies.length; i++)
			
	}
}
