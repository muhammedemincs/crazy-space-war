package model;

import java.util.ArrayList;

public class GameMap {
	
	//Properties
	
	private Ship ship ;
	public ArrayList<Bomb> bombs ;
	public ArrayList<PowerUp> powerUps; 
	public ArrayList<Fire> fires;
	public ArrayList<Enemy> enemies; 
	public GameMap()
	{
		ship = new Ship() ;	
		bombs = new ArrayList<Bomb>() ;
		powerUps = new ArrayList<PowerUp>() ;
		fires = new ArrayList<Fire>() ;
		enemies = new ArrayList<Enemy>() ;
		
	}
	
	//Methods
	public Ship getShip()
	{
		return ship;
	}
	
	public void addPowerUp(PowerUp pw)
	{
		powerUps.add(pw);	
	}
	
	public void addFire(Fire fr)
	{
		fires.add(fr);
	}
	
	public void addEnemey(Enemy en)
	{
		enemies.add(en);
	}
	
	
	
	
	
}
