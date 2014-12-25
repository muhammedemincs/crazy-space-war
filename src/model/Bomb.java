package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
import java.awt.Event;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Bomb extends GameObject {

	//Properties
	
	private int destroyPower;
	private int kind ;
	private int r ;
	
	private  BufferedImage image ;
	
	Rectangle bounds;
	
	
	//Constructor
	public Bomb(int bombType, int x, int y,  Rectangle bounds)
	{
		this.setBombType(bombType); // GitHub push deneme
		this.setKind(bombType);
		this.xPos=x;
		this.yPos=y;
		this.bounds = bounds;
		destroyPower = 1;
	}
	
	//Methods
	
	public void setBombType(int shipType)
	{
		try{
			image = ImageIO.read(new File("ship"+shipType+".png"));
		}
		catch(Exception e){
			
		}
		this.setKind(shipType);
	}

	public boolean moveLeft()
	{
		xPos = xPos - cell ;
		return true;
	}
	
	public boolean moveRight()
	{
		xPos = xPos + cell ;
		return true;
	}
	
	public boolean moveY()
	{
		yPos = yPos - cell;
		return true;
	}

	public boolean doesCollideEnemy(Ship sp)
	{
		if(Math.pow(xPos- sp.getXpos(),2)+Math.pow(yPos- sp.getYpos() ,2) > 4*Math.pow(sp.r, 2) )
			return false;
		else
			return true;
	}

	public boolean doesContain(Point p)
	{
		return Math.pow(xPos-p.x, 2)+Math.pow(yPos- p.y, 2) < Math.pow(r, 2) ;
	}
	
	public int getDestroyPower() {
		return destroyPower;
	}

	public void setDestroyPower(int destroyPower) {
		this.destroyPower = destroyPower;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}
	
	
	
	
	
}
