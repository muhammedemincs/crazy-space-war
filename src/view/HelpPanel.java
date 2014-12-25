/**
 *
 * @author omerhanci
 */
package view;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class HelpPanel extends javax.swing.JPanel{
	private GUIManager guiManager;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	public HelpPanel() {
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(118, 50, 75, 29);
		
		JLabel lblCrazySpaceWar = new JLabel("Crazy Space War");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(363)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(lblCrazySpaceWar)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblCrazySpaceWar)
					.addGap(214)
					.addComponent(btnBack))
		);
		setLayout(groupLayout);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SpaceWar();
			}
		});
	}
}
