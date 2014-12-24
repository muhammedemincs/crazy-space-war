package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
import java.awt.Event;
import java.awt.image.BufferedImage;




public abstract class GameObject {

	//Properties
	
	
	public final int cell = 100;
	protected int xPos;
	protected int yPos;
	protected BufferedImage image ;
	//Methods
	
	abstract boolean moveLeft();
	abstract boolean moveRight();
	abstract boolean moveY();
	//Get and Set Methods
	
	
	
	
	public int getXpos()
	{
		return xPos ;
	}
	
	public int getYpos()
	{
		return yPos ;
	}
	
	public void setXpos(int x)
	{
		xPos = x;
	}
	
	public void setYpos(int y)
	{
		yPos = y ;
	}
	public BufferedImage getCurrentImage(){
		return image;
	}
	
	
	
	
}
