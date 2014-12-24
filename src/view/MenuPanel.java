/**
 *
 * @author omerhanci
 */
package view;
import controller.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuPanel extends javax.swing.JPanel {
	GUIManager guiManager;
	private HelpPanel helpPanel;
	private HighScorePanel highScorePanel;
	private SettingsPanel settingsPanel;
	private GamePanel gamePanel;
	private JFrame f;
	
	public MenuPanel(GUIManager guiManager) {
		this.guiManager = guiManager;
		initComponents();
	}
	private void initComponents() {
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.startGame();
			}
		});
			
			JButton btnViewHighScores = new JButton("View High Scores");
			btnViewHighScores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					highScorePanel = new HighScorePanel();
					guiManager.setPanel(highScorePanel);
				}
			});
			
				JButton btnSettings = new JButton("Settings");
				btnSettings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						settingsPanel = new SettingsPanel();
						guiManager.setPanel(settingsPanel);
					}
				});
			
			JButton btnHelp = new JButton("Help");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					helpPanel = new HelpPanel();
					guiManager.setPanel(helpPanel);
				}
			});
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(178)
								.addComponent(btnHelp))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(169)
								.addComponent(btnSettings))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(141)
								.addComponent(btnViewHighScores))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(161)
								.addComponent(btnStartGame)))
						.addContainerGap(157, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(42)
						.addComponent(btnStartGame)
						.addGap(18)
						.addComponent(btnViewHighScores, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnSettings)
						.addGap(18)
						.addComponent(btnHelp)
						.addGap(89))
			);
			setLayout(groupLayout);
	}

}
