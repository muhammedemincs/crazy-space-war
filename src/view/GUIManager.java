package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GUIManager {
	private final static int WIDTH = 1000;
	private final static int HEIGHT = 1000;
	private JFrame frame;
	private JPanel currentPanel;
	private HelpPanel helpPanel;
	private MenuPanel menuPanel;
	
	public GUIManager(JFrame f){
		frame = f;
		menuPanel = new MenuPanel(this);
		currentPanel = menuPanel;
		setPanel(menuPanel);
	}
	public void setPanel(JPanel panel){
		frame.setVisible(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
