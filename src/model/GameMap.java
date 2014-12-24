package model;
import controller.*;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Graphics2D;

import javax.swing.JPanel;




public class GameMap {
	
	//Properties
	
	private Ship ship ;
	public ArrayList<Bomb> bombs ;
	public ArrayList<PowerUp> powerUps; 
	public ArrayList<Fire> fires;
	public ArrayList<Enemy> enemies; 
	private LevelCreatorFactory factory ;
	
	private int weight ;
	private int height ;
	
	public GameMap()
	{
		ship = new Ship() ;	
		bombs = new ArrayList<Bomb>() ;
		//powerUps = new ArrayList<PowerUp>() ;
		fires = new ArrayList<Fire>() ;
		//enemies = new ArrayList<Enemy>() ;
		setWeight(0);
		setHeight(0);
	}
	
	public GameMap(int weight, int height)
	{
		this.weight = weight ;
		this.height = height ;
		
		ship = new Ship() ;	
		bombs = new ArrayList<Bomb>() ;
		
		fires = new ArrayList<Fire>() ;
		
	}
	
	//Methods
	
	
	//public void draw(Graphi)
	
	public void setMap(int lev, int dif)
	{
		if(lev==1)
		{
			factory = new Level1Creator();
		
		}
			
		else
		{
			factory = new Level2Creator() ;
			
		}
		enemies = factory.createEnemies();
		//powerUps = factory.createPowerUp();
		System.out.println("vofrýh");
	}

	
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
	
	public void setShipModel(int model)
	{
		this.ship.setShipTypeImg(model);
	
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
