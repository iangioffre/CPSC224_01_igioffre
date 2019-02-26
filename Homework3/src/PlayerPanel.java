import java.awt.*;
import javax.swing.*;

// creates the player panel for the game board

public class PlayerPanel extends JPanel
{
	private JPanel player1;
	private JPanel player2;
	private final JLabel nameLabel1 = new JLabel("Name: ");
	private final JLabel nameLabel2 = new JLabel("Name: ");
	private final JLabel winLabel1 = new JLabel("Wins: ");
	private final JLabel winLabel2 = new JLabel("Wins: ");
	private final JLabel lossLabel1 = new JLabel("Losses: ");
	private final JLabel lossLabel2 = new JLabel("Losses: ");
	private static JTextField name1;
	private static JTextField name2;
	private static int winNum1 = 0;
	private static int winNum2 = 0;
	private static JLabel wins1;
	private static JLabel wins2;
	private static JLabel losses1;
	private static JLabel losses2;
	
	public PlayerPanel()
	{
		// initialize panels as grid layouts and titled borders
		player1 = new JPanel(new GridLayout(3,2));
		player2 = new JPanel(new GridLayout(3,2));
		player1.setBorder(BorderFactory.createTitledBorder("Player 1 (X):"));
		player2.setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));
		
		// initialize labels and text fields for each player
		name1 = new JTextField("Player 1", 8);
		name2 = new JTextField("Player 2", 8);
		wins1 = new JLabel(String.valueOf(winNum1));
		wins2 = new JLabel(String.valueOf(winNum2));
		losses1 = new JLabel(String.valueOf(winNum2));
		losses2 = new JLabel(String.valueOf(winNum1));
		
		// add everything to each player panel
		player1.add(nameLabel1);
		player1.add(name1);
		player1.add(winLabel1);
		player1.add(wins1);
		player1.add(lossLabel1);
		player1.add(losses1);
		
		player2.add(nameLabel2);
		player2.add(name2);
		player2.add(winLabel2);
		player2.add(wins2);
		player2.add(lossLabel2);
		player2.add(losses2);
		
		// set panel to center flow layout and add each player panel
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(player1);
		add(player2);
	}
	
	public void setEditable(boolean edit)
	{
		name1.setEditable(edit);
		name2.setEditable(edit);
	}
	
	public static void player1Won()
	{
		winNum1++;
		
		wins1.setText(String.valueOf(winNum1));
		losses2.setText(String.valueOf(winNum1));
	}
	
	public static void player2Won()
	{
		winNum2++;
		
		wins2.setText(String.valueOf(winNum2));
		losses1.setText(String.valueOf(winNum2));
	}
	
	public void reset()
	{
			winNum1 = 0;
			winNum2 = 0;
		
			wins1.setText(String.valueOf(winNum1));
			losses2.setText(String.valueOf(winNum1));
			wins2.setText(String.valueOf(winNum2));
			losses1.setText(String.valueOf(winNum2));
			
			name1.setText("Player 1");
			name2.setText("Player 2");
			setEditable(true);
	}
	
	public static String getNameX()
	{
		return name1.getText();
	}
	
	public static String getNameO()
	{
		return name2.getText();
	}
}
