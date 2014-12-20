package view;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SpaceWar {
	public SpaceWar(){
		JFrame frame = new JFrame("SpaceWar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		new GUIManager(frame);
	}
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new SpaceWar();//create an instance which incudes GUI etc
            }
        });
    }
}
