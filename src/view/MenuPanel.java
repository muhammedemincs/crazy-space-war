package view;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class MenuPanel extends javax.swing.JPanel {
	GUIManager guiManager;
	private HelpPanel helpPanel;
	private HighScorePanel highScorePanel;
	private SettingsPanel settingsPanel;
	private JFrame f;
	
	public MenuPanel(GUIManager guiManager) {
		this.guiManager = guiManager;
		initComponents();
	}
	private void initComponents(){
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("141px"),
				ColumnSpec.decode("152px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("29px"),
				RowSpec.decode("28px"),
				RowSpec.decode("29px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				RowSpec.decode("22px"),
				RowSpec.decode("29px"),}));
		
		JButton btnStartGame = new JButton("Start Game");
		add(btnStartGame, "2, 2, center, top");
			
			JButton btnViewHighScores = new JButton("View High Scores");
			btnViewHighScores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					highScorePanel = new HighScorePanel();
					guiManager.setPanel(highScorePanel);
				}
			});
			add(btnViewHighScores, "2, 3, left, top");
			
				JButton btnSettings = new JButton("Settings");
				btnSettings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						settingsPanel = new SettingsPanel();
						guiManager.setPanel(settingsPanel);
					}
				});
				add(btnSettings, "2, 4, center, top");
			
			JButton btnHelp = new JButton("Help");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					helpPanel = new HelpPanel();
					guiManager.setPanel(helpPanel);
				}
			});
			add(btnHelp, "2, 6, center, top");
			
			JButton btnCredits = new JButton("Credits");
			add(btnCredits, "2, 8, center, top");
	}

}
