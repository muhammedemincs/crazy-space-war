package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
import java.awt.Event;




public abstract class GameObject {

	//Properties
	
	
	public final int cell = 100;
	protected int xPos;
	protected int yPos;
	
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
	public Image getCurrentImage(){
		return Image;
	}
	
	
}
