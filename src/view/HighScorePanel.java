/**
 *
 * @author omerhanci
 */
package view;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HighScorePanel extends javax.swing.JPanel {
		
	public HighScorePanel(){
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SpaceWar();
			}
		});
		
		JLabel lblHighScores = new JLabel("High Scores");
		
		JLabel label = new JLabel("1");
		
		JLabel label_1 = new JLabel("2");
		
		JLabel label_2 = new JLabel("3");
		
		JLabel label_3 = new JLabel("4");
		
		JLabel label_4 = new JLabel("5");
		
		JLabel lblScore = new JLabel("score");
		
		JLabel lblScore_1 = new JLabel("score");
		
		JLabel lblScore_2 = new JLabel("score");
		
		JLabel lblScore_3 = new JLabel("score");
		
		JLabel lblScore_4 = new JLabel("score");
		
		JLabel lblPlayer = new JLabel("Player1");
		
		JLabel lblPlayer_1 = new JLabel("Player2");
		
		JLabel lblPlayer_2 = new JLabel("Player3");
		
		JLabel lblPlayer_3 = new JLabel("Player4");
		
		JLabel lblPlayer_4 = new JLabel("Player5");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(363)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addComponent(lblHighScores)))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPlayer)
						.addComponent(lblPlayer_1)
						.addComponent(lblPlayer_2)
						.addComponent(lblPlayer_3)
						.addComponent(lblPlayer_4))
					.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScore)
						.addComponent(lblScore_1)
						.addComponent(lblScore_2)
						.addComponent(lblScore_3)
						.addComponent(lblScore_4))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblHighScores)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblScore)
						.addComponent(lblPlayer))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblScore_1)
						.addComponent(lblPlayer_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(lblScore_2)
						.addComponent(lblPlayer_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(lblScore_3)
						.addComponent(lblPlayer_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(lblScore_4)
						.addComponent(lblPlayer_4))
					.addGap(46)
					.addComponent(btnBack))
		);
		setLayout(groupLayout);
	}
}
