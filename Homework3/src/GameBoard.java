import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;

//Creates the GUI for TicTacToe

public class GameBoard extends JFrame
{
	private PlayerPanel player;
	private BoardPanel board;
	private final int WINDOW_WIDTH = 500; // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	
	private JButton newgame;
	private JButton reset;
	private JButton exit;
	private JPanel buttons;
	private JPanel bottomPanel;
	private static JLabel status;
	
	public GameBoard()
	{
		// Display a title.
	    setTitle("TicTacToe"); 
	    
	    //sets the size of the frame.
	    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	    // Specify an action for the close button.
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Create a BorderLayout manager.
	    setLayout(new BorderLayout());
	    
	    player = new PlayerPanel();
	    board = new BoardPanel();
	    createButtonsPanel();
	    
	    add(player, BorderLayout.NORTH);
	    add(board, BorderLayout.CENTER);
	    add(bottomPanel, BorderLayout.SOUTH);
	    
	    setVisible(true);
	}
	
	private void createButtonsPanel()
	{		
		// create a panel for buttons and set to center flow layout
		buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// create buttons for new game, reset, and exit
		newgame = new JButton("New Game");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		
		// Register an event listener with all 3 buttons.
		newgame.addActionListener(new newButtonListener());
		reset.addActionListener(new resetButtonListener());
		exit.addActionListener(new exitButtonListener());
		
		// add buttons to buttons panel
		buttons.add(newgame);
		buttons.add(reset);
		buttons.add(exit);
		
		//create status label for bottom
		status = new JLabel("Welcome to Tic-Tac-Toe!");
		status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		bottomPanel = new JPanel(new BorderLayout());
		
		// add buttons and status bar to bottomPanel
		bottomPanel.add(buttons, BorderLayout.CENTER);
		bottomPanel.add(status, BorderLayout.SOUTH);
	}
	
	private class newButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(PlayerPanel.getNameX().equals("") || PlayerPanel.getNameX().charAt(0) == ' ') // if name is blank or starts with a space
			{
				JOptionPane.showMessageDialog(null, "Player 1's name is invalid. Enter a new name.","Invalid Name", JOptionPane.ERROR_MESSAGE);
			}
			else if(PlayerPanel.getNameO().equals("") || PlayerPanel.getNameO().charAt(0) == ' ') // if name is blank or starts with a space
			{
				JOptionPane.showMessageDialog(null, "Player 2's name is invalid. Enter a new name.","Invalid Name", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				player.setEditable(false); // prohibit name changes
				updateStatus();
				BoardPanel.enableBoard();
			}
		}
	}
	
	private class resetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int input = 0;
			input = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?");
			
			if(input == JOptionPane.YES_OPTION)
			{
				player.reset(); // sets win counts to 0
				
				status.setText("Welcome to Tic-Tac-Toe!");
				
				BoardPanel.clearBoard();
				BoardPanel.disableBoard();
			}
		}
	}
	
	private class exitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void updateStatus()
	{
		if(BoardPanel.getCurrentLetter() == "O") // always one ahead of currentLetter
			status.setText(PlayerPanel.getNameX() + "'s turn.");
		else
			status.setText(PlayerPanel.getNameO() + "'s turn.");
	}
}
