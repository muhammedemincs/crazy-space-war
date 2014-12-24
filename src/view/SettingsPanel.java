package view;
import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.GroupLayout.Alignment;


/**
*
* @author omerhanci
*/
public class SettingsPanel extends javax.swing.JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuPanel menuPanel;
	private GUIManager guiManager;
	private JFrame f; 
	public SettingsPanel() {
		
		JLabel lblSound = new JLabel("Sound :");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SpaceWar();
			}
		});
		
		
		JCheckBox chckbxSound = new JCheckBox("Sound");
		
		JLabel lblDifficulty = new JLabel("Difficulty :");
		
		JLabel lblSpaceship = new JLabel("Spaceship :");
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnEasy);
	    group.add(rdbtnMedium);
	    group.add(rdbtnHard);
	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(55)
	    			.addComponent(lblSound, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
	    			.addGap(183)
	    			.addComponent(chckbxSound))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(354)
	    			.addComponent(btnBack))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(55)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblSpaceship)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblDifficulty, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(70)
	    							.addComponent(rdbtnEasy, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
	    					.addGap(9)
	    					.addComponent(rdbtnMedium)
	    					.addGap(22)
	    					.addComponent(rdbtnHard, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(42)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(4)
	    					.addComponent(lblSound))
	    				.addComponent(chckbxSound))
	    			.addGap(23)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(4)
	    					.addComponent(lblDifficulty))
	    				.addComponent(rdbtnEasy)
	    				.addComponent(rdbtnMedium)
	    				.addComponent(rdbtnHard))
	    			.addGap(28)
	    			.addComponent(lblSpaceship)
	    			.addGap(92)
	    			.addComponent(btnBack))
	    );
	    setLayout(groupLayout);
	}
}
