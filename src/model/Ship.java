package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
//import java.awt.Event;
import java.awt.image.BufferedImage ;
import java.io.File;
import javax.imageio.ImageIO;
//import javax.swing.JPanel;

public class Ship extends GameObject 
{
	//Properties
	// Bu classta ship'in 
	
	private  BufferedImage image ;
	//Ben haraket olarak cell tan›mlad›m
	final int r;
	
	//private int x , y ;
	Rectangle bounds;
	
	private int lifeEnergy;
	private int shipType ;
	
	public Ship()
	{
		 
		
		
	}
	public Ship(int shipType, int x, int y,  Rectangle bounds)
	{
		this.setShipType(shipType);
		this.setShipTypeImg(shipType);
		this.xPos=x;
		this.yPos=y;
		this.bounds = bounds;
		this.setLifeEnergy(3) ;
	}
	
	//Methods
	
	public boolean moveRight()
	{
		xPos+=cell ;
		if(!bounds.contains(xPos,yPos))
			return false;
		return true;
	}
	
	
	public boolean moveLeft()
	{
		xPos-=cell ;
		if(!bounds.contains(xPos,yPos))
			return false;
		return true;
	}
	
	public boolean moveY()
	{
		return true;
	}
	
	public int getShipType()
	{
		return shipType;
	}
	
	public void setShipType(int type)
	{
		shipType = type ;
	}
	
	public void setShipTypeImg(int shipType)
	{
		try{
			image = ImageIO.read(new File("ship"+shipType+".png"));
		}
		catch(Exception e){
			
		}
	}
	public int getLifeEnergy() {
		return lifeEnergy;
	}
	public void setLifeEnergy(int lifeEnergy) {
		this.lifeEnergy = lifeEnergy;
	}
	
	public boolean doesCollideEnemy(Enemy e)
	{
		if(Math.pow(xPos- e.getX(),2)+Math.pow(yPos- e.getY() ,2) > 4*Math.pow(r, 2) )
			return false;
		else
			return true;
	}

	public boolean doesContain(Point p)
	{
		return Math.pow(xPos-p.x, 2)+Math.pow(yPos- p.y, 2) < Math.pow(r, 2) ;
	}
	
	
	
}
