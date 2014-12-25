package controller;
import java.util.ArrayList;
import model.*;

//Author: Erdinc
//abstract factory for level creator
public abstract class LevelCreatorFactory {
	//attributes
	int numberOfEnemies;
	int[] typeOfEnemies;
	int numberOfPowerUps;
	ArrayList<Enemy> enemy;
	
	//methods
	public abstract ArrayList<Enemy> createEnemies();
	public abstract ArrayList<PowerUp> createPowerUp();
}