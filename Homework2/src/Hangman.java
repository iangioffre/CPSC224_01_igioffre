
/*******************************************************************
	Homework #2
	Due Date: 02-11-2019
	Names: Ian Gioffre and Cole Donovan
	Repo URL: https://github.com/DonovanCo/CPSC224_01_donovan.git
*******************************************************************/

import javax.swing.JOptionPane;

public class Hangman
{

	// main: serves only to call other functions
	// to run the main hangman game.
	public static void main(String[] args)
	{
		while(true)
			menu();
	}
	
	//returns a random word from a list as a string
	public static String randomWord()
	{
		String list[] = {"psychic", "gonzaga", "coding", "hemmingson", "metamorphosis", "balloon", "valentine", "chip", "extra", "bulldog"};
		int num = (int)(Math.random()*10);
		return list[num];
	}
	
	// shows a menu and gets the user's menu option, then runs based on option
	public static void menu()
	{
		String input = null;
		int choice = 0;
		
		while(choice < 1 || choice > 3)
		{
			input = JOptionPane.showInputDialog("Welcome to Hangman!\n"
												+ "1. Play a game with a random word\n"
												+ "2. Play a game with a word from another person\n"
												+ "3. Exit the game\n"
												+ "Enter the number of your choice");
			choice = Integer.parseInt(input);
			
			if(choice < 1 || choice > 3)
				JOptionPane.showMessageDialog(null, "That is not an option. Please try again.");
		}
		
		switch(choice)
		{
			case 1: 
				Player randomGame = new Player(randomWord());
				playGame(randomGame);
				break;
			case 2:
				Player inputGame = new Player(getPlayerWord());
				playGame(inputGame);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Thanks for playing!");
				System.exit(0);
				break;
		}
		
		JOptionPane.showMessageDialog(null, "Thanks for playing!");
	}
	
	//returns a word entered by the user as a string
	public static String getPlayerWord()
	{
		boolean areLetters = false;
		String word = null;
		
		while(!areLetters)
		{
			word = JOptionPane.showInputDialog("Enter a word for another player to guess.");
			
			for(int i = 0; i < word.length(); i++)
			{
				areLetters = ( ((int) word.charAt(i) >= 65 && (int) word.charAt(i) <= 90) || ((int) word.charAt(i) >= 97 && (int) word.charAt(i) <= 122) );

				if(!areLetters)
				{
					JOptionPane.showMessageDialog(null, "That is not a valid word. Please try again.");
					i = word.length();
				}
			}
		}
		
		return word;
	}
	
	// returns a picture of a hangman as a string based on strike count
	public static String hangman(int strikes)
	{
		String output = null;
		
		switch(strikes)
		{
			case 0:
				output = "      \n"
					   + "      \n"
					   + "      \n";
				break;
			case 1:
				output = "  o   \n"
					   + "      \n"
					   + "      \n";
				break;
			case 2:
				output = "  o   \n"
			 	 	   + "  |   \n"
			 	 	   + "      \n";
				break;
			case 3:
				output = "  o   \n"
				 	   + "/ |   \n"
				 	   + "      \n";
				break;
			case 4:
				output = "  o   \n"
				 	   + "/ | \\\n"
				 	   + "      \n";
				break;
			case 5:
				output = "  o   \n"
					   + "/ | \\\n"
					   + " /    \n";
				break;
			case 6:
				output = "  o   \n"
				 	   + "/ | \\\n"
				 	   + " / \\ \n";
				break;
		}
		return output;
	}
	
	// returns the player's guess as a character
	public static char getPlayerGuess(Player game)
	{
		String dummy = game.getDummyWord();
		String input = null;
		char guess = ' ';
		
		while(!( ((int) guess >= 65 && (int) guess <= 90) || ((int) guess >= 97 && (int) guess <= 122)))
		{
			input = JOptionPane.showInputDialog(dummy + "\n" + hangman(game.getStrikes()) + "Enter your guess");
			guess = input.charAt(0);
			
			if(!( ((int) guess >= 65 && (int) guess <= 90) || ((int) guess >= 97 && (int) guess <= 122)))
				JOptionPane.showMessageDialog(null, "That is not a valid guess. Please try again.");
		}
		
		return guess;
	}
	
	// runs the game until strikes hit 6 or word is completely guessed, then calls gameEnd
	public static void playGame(Player game)
	{
		while(game.getStrikes() < 6 && game.isNotEqual())
		{
			char guess;
			guess = getPlayerGuess(game);
			
			if(game.isFoundInWord(guess))
			{
				game.setDummyCharacter(guess);
				JOptionPane.showMessageDialog(null, "Nice! That letter is in the word.");
			}
			else
			{
				game.setStrikes(game.getStrikes() + 1);
				JOptionPane.showMessageDialog(null, "That letter is not in the word. Please try again.");
			}
		}
		
		gameEnd(game);
	}
	
	// outputs game end messages based on if player won or not
	public static void gameEnd(Player game)
	{
		if(game.getStrikes() >=6)
			JOptionPane.showMessageDialog(null, "You lost! The word was " + game.getGuessWord() + ".\n" + hangman(game.getStrikes()));
		else
			JOptionPane.showMessageDialog(null, "You won! The word was " + game.getGuessWord() + ". Congratulations!");
	}

}