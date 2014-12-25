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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HighScorePanel extends javax.swing.JPanel {
		
	public String player1,player2,player3,player4,player5;
	public String score1,score2,score3,score4,score5;
	public void editHighScore(String name, int score, int place){
		if(place == 1){
			player1 = name;
			score1 = String.valueOf(score);
		}
		else if(place == 2){
			player2 = name;
			score2 = String.valueOf(score);
		}
		else if(place == 3){
			player3 = name;
			score3 = String.valueOf(score);
		}
		else if(place == 4){
			player4 = name;
			score4 = String.valueOf(score);
		}
		else{
			player5 = name;
			score5 = String.valueOf(score);
		}
			
	}
	
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
		
		JLabel lblScore = new JLabel(score1);
		
		JLabel lblScore_1 = new JLabel(score2);
		
		JLabel lblScore_2 = new JLabel(score3);
		
		JLabel lblScore_3 = new JLabel(score4);
		
		JLabel lblScore_4 = new JLabel(score5);
		
		JLabel lblPlayer = new JLabel(player1);
		
		JLabel lblPlayer_1 = new JLabel(player2);
		
		JLabel lblPlayer_2 = new JLabel(player3);
		
		JLabel lblPlayer_3 = new JLabel(player4);
		
		JLabel lblPlayer_4 = new JLabel(player5);
		
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
