package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
import java.awt.Event;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Enemy extends GameObject
{
	//Properties
	private BufferedImage image ;
	private int lifeEnergy ;
	private int enemyKind ;
	Rectangle bounds ;
	private int r ;
	
	//Constructor
	
	public Enemy(int enemyType, int x, int y, Rectangle bounds)
	{
		this.setEnemyType(enemyType);
		this.bounds = bounds ;
		
		lifeEnergy = 1;
		xPos=x ;
		yPos=y ;
		
	}
	
	public void setEnemyType( int enemyType)
	{
		try{
			image = ImageIO.read(new File("enemy"+enemyKind+".png"));
		}
		catch(Exception e){
			
		}
		
	}
	
	//Methods
	public int getLifeEnergy()
	{
		return lifeEnergy ;
	}
	
	public int getEnemyKind()
	{
		return enemyKind ;
	}
	
	public void setEnemyKind(int kind)
	{
		enemyKind = kind;
	}
	
	public void setLifeEnergy(int lifeEnergy)
	{
		this.lifeEnergy = lifeEnergy ;
	}
	
	
	public boolean moveY()
	{
		yPos -= cell ;
		return true;
	}
	
	public boolean moveRight()
	{
		xPos += cell;
		return true;
	}
	
	public boolean moveLeft()
	{
		xPos -= cell ;
		return true ;
	}
	
	
	public boolean doesCollideEnemy(Ship ship)
	{
		if(Math.pow(xPos- ship.getXpos(),2)+Math.pow(yPos- ship.getYpos() ,2) > 4*Math.pow(r, 2) )
			return false;
		else
			return true;
	}

	public boolean doesContain(Point p)
	{
		return Math.pow(xPos-p.x, 2)+Math.pow(yPos- p.y, 2) < Math.pow(r, 2) ;
	}
	
	
	
	
	
	
}
