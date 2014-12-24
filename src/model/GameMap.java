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
	private LevelCreatorFactory abc ;
	
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
			abc = new Level1Creator();
		
		}
			
		else
		{
			abc = new Level2Creator() ;
			
		}
		
		enemies = abc.createEnemies();
		powerUps = abc.createPowerUp();
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
