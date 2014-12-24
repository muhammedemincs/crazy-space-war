/**
 *
 * @author omerhanci
 */

// oo class alõrõm bi dal
package view;
import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.*;
import controller.*;

public class SpaceWar {
	public SpaceWar(){
		JFrame frame = new JFrame("SpaceWar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GameMap gameMap = new GameMap(); 
		GUIManager guiManager = new GUIManager(frame,gameMap);
		GameData gameData = new GameData();
		GameEngine gameEngine = new GameEngine(guiManager, gameMap,gameData, 1,1);
		guiManager.setEngine(gameEngine);
	}
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SpaceWar();//create an instance which includes GUI etc
            }
        });
    }
}
