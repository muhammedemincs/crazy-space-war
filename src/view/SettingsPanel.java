package view;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsPanel extends javax.swing.JPanel{
	private MenuPanel menuPanel;
	private GUIManager guiManager;
	private JFrame f; 
	public SettingsPanel() {
		
		JCheckBox chckbxSound = new JCheckBox("Sound");
		add(chckbxSound);
		
		JRadioButton rdbtnPlayer = new JRadioButton("1 player");
		add(rdbtnPlayer);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SpaceWar();
			}
		});
		add(btnBack);
		
	}

}
