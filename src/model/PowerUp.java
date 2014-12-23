// Model part of Project 
// Author Muhammed Emin Öztürk


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

public class PowerUp extends GameObject 
{
	//Properties 
	private BufferedImage image ;
	private int powerUpkind;
	private int duration;
	//private int x,y ;
	Rectangle bounds ;
	private boolean taken;
	
	public PowerUp(int kind, int duration , int x , int y )
	{
		this.setPowerUpType(kind);
		this.duration=duration ;
		taken = false ;
		
		xPos =x ;
		yPos =y ;
		
	}
	
	public void setPowerUpType(int powerUpType) {
		try{
			image = ImageIO.read(new File("powerUp"+powerUpType+ ".png")) ; 
		}
		catch(Exception e){
			
		}
		
		this.setPowerUpkind(powerUpType);
		
	}
	public boolean moveRight()
	{
		return true;
	}
	
	public boolean moveLeft()
	{
		return true;
	}
	
	public boolean moveY()
	{
		this.yPos+=cell/3;
		return true;
	}

	public boolean isTaken()
	{
		taken = true;
		return taken;
	}
	
	
	public int getPowerUpkind() {
		return powerUpkind;
	}


	public void setPowerUpkind(int powerUpkind) {
		this.powerUpkind = powerUpkind;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	
	
}
