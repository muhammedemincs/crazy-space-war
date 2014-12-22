package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
import java.awt.Event;
import java.awt.image.BufferedImage ;
import java.io.File;

import javax.imageio.ImageIO;

public class Fire extends GameObject 
{
	//Properties
	 private int destroyForce ;
	 private int kind ;
	 Rectangle bounds;
	 private  BufferedImage image ;
	
	 //Constructor
	 
	 public Fire()
	 {
		 destroyForce = 100 ;
		 setKind(0) ;
	 }
	 
	 public Fire(int fireType, int x, int y,  Rectangle bounds)
	{
		this.setFireType(fireType);
		this.setFireTypeImg(fireType);
		this.xPos=x;
		this.yPos=y;
		this.bounds = bounds;

	}
	
	//Methods
	
	public void setFireType(int type)
	{
			kind = type ;
	}
		
	public void setFireTypeImg(int shipType)
	{
		try{
				image = ImageIO.read(new File("ship"+shipType+".png"));
		}
		catch(Exception e){
		}
	} 
	 
	public int getDestroyForce()
	{
		return destroyForce ;
	}
	
	public void setDestroyForce(int newForce)
	{
		destroyForce = newForce ;
	}
	
	public boolean moveY()
	{
		yPos -= cell/5 ;
		return true;
	}
	
	public boolean moveRight()
	{
		return true;	
	}
	
	public boolean moveLeft()
	{
		return true;
	}
	
	
	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}
	
	
}
