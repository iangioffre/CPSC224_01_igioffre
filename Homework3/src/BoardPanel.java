import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Creates the 3x3 TicTacToe Board.

public class BoardPanel extends JPanel
{
	
	private static JButton tiles[] = new JButton[9];
	private static int turnCount = 0;
	private static String currentLetter = "O";
	
	public BoardPanel()
	{
		setLayout(new GridLayout(3,3));
		
		for(int i = 0; i<9; i++)
		{
			tiles[i] = new JButton("");
			tiles[i].setEnabled(false);
			tiles[i].addActionListener(new tileListener());
			add(tiles[i]);
		}
	}
	
	public static void enableBoard()
	{
		for(int i = 0; i<9; i++)
		{
			tiles[i].setEnabled(true);
		}
	}
	
	public static void disableBoard()
	{
		for(int i = 0; i<9; i++)
		{
			tiles[i].setEnabled(false);
		}
	}
	
	private class tileListener extends JButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton tilePlayed = (JButton)e.getSource();
			tilePlayed.setFont(new Font("Dialog", 1, 60));
			if((turnCount%2==0) && tilePlayed.getText().equals(""))
			{ 
				tilePlayed.setText("X");
				turnCount++;
				currentLetter="X";
			}
			else if((turnCount%2==1) && tilePlayed.getText().equals(""))
			{
				tilePlayed.setText("O");
				turnCount++;
				currentLetter="O";
			}
			
			boolean gameStatus = false; //Used to check if game is won/tied.
			
			//checking if a win has happened.
			if((tiles[0].getText().equals(tiles[1].getText())&&tiles[1].getText().equals(tiles[2].getText())
			&&tiles[0].getText()!="") || (tiles[3].getText().equals(tiles[4].getText())&&tiles[4].getText().equals(tiles[5].getText())
			&&tiles[3].getText()!="") || (tiles[6].getText().equals(tiles[7].getText())&&tiles[7].getText().equals(tiles[8].getText())
			&&tiles[6].getText()!="") || (tiles[0].getText().equals(tiles[3].getText())&&tiles[3].getText().equals(tiles[6].getText())
			&&tiles[0].getText()!="") || (tiles[1].getText().equals(tiles[4].getText())&&tiles[4].getText().equals(tiles[7].getText())
			&&tiles[1].getText()!="") || (tiles[2].getText().equals(tiles[5].getText())&&tiles[5].getText().equals(tiles[8].getText())
			&&tiles[2].getText()!="") || (tiles[0].getText().equals(tiles[4].getText())&&tiles[4].getText().equals(tiles[8].getText())
			&&tiles[0].getText()!="") || (tiles[2].getText().equals(tiles[4].getText())&&tiles[4].getText().equals(tiles[6].getText())
			&&tiles[2].getText()!=""))
			{
				gameStatus=true;
			}
			
			if(gameStatus)
			{
				for(int i=0; i<9; i++)
					tiles[i].setEnabled(false);
				if(currentLetter=="X")
					PlayerPanel.player1Won();
				else
					PlayerPanel.player2Won();
				JOptionPane.showMessageDialog(null, currentLetter + " Wins!!!");
			}
			else if(gameStatus==false && turnCount == 9)
			{
				for(int i=0; i<9; i++)
					tiles[i].setEnabled(false);
				JOptionPane.showMessageDialog(null, "Tie, no one wins.");
				gameStatus=true;
			}
			
			if(gameStatus)
			{
				for(int i = 0; i<9; i++)
				{
					tiles[i].setText("");
					tiles[i].setEnabled(true);
				}
				turnCount=0;
				currentLetter = "O";
			}
			
			GameBoard.updateStatus();
		}
	}
	
	public static void clearBoard()
	{
		for(int i = 0; i<9; i++)
		{
			tiles[i].setText("");
			tiles[i].setEnabled(true);
		}
		turnCount=0;
	}
	
	public static String getCurrentLetter()
	{
		return currentLetter;
	}
	
}
