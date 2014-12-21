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
	
	//GUIManager da oyunu baþlatýrken önce GamePanel ýn init() ini
	//sonra da GameEngine in gameStart() ýný çaðýrcaz
	//Bide GUIManager da draw() ve drawToScreen methodlarý olcak
	//içlerinde sadece GamePanel ýn ayný isimli methodlarýný çaðýrcaklar
	
	public void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
	}
	
	public void draw()
	{
		//öylesine yazdým burda iste tek tek objeleri cizcen
		g.clearRect(0, 0, WIDTH, HEIGHT);
	}
	
	public void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, WIDTH * SCALE, null);
		g2.dispose();
	}
	
	//ATTENTION!!
	//bu method GUIManager ýn methodu GUIManager ýn constructorý bi GameEngine alcak
	//bahsi geçen gameEngine o gameEngine
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
			//burdan sonra listeyi gösterebiliriz
		}
	}
}
