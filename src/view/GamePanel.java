package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends javax.swing.JPanel{
	
	//Panel Dimensions
	public static final int WIDTH = 520;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	//Drawing 
	private Graphics2D g;
	private BufferedImage image;
	
	public GamePanel()
	{
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	//GUIManager da oyunu ba�lat�rken �nce GamePanel �n init() ini
	//sonra da GameEngine in gameStart() �n� �a��rcaz
	//Bide GUIManager da draw() ve drawToScreen methodlar� olcak
	//i�lerinde sadece GamePanel �n ayn� isimli methodlar�n� �a��rcaklar
	
	public void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
	}
	
	public void draw()
	{
		//�ylesine yazd�m burda iste tek tek objeleri cizcen
		g.clearRect(0, 0, WIDTH, HEIGHT);
	}
	
	public void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, WIDTH * SCALE, null);
		g2.dispose();
	}
	
	//ATTENTION!!
	//bu method GUIManager �n methodu GUIManager �n constructor� bi GameEngine alcak
	//bahsi ge�en gameEngine o gameEngine
	public void endGame()
	{
		//oyunu bitircek
		int score = gameEngine.getScore();
		//display score on screen
		//then
		if( gameEngine.isIntop(score))
		{
			//ask for name do sth sth
			String name;	// get name
			gameEngine.updateHighScore(name, score);
			//burdan sonra listeyi g�sterebiliriz
		}
	}
}
