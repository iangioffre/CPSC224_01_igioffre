import java.util.Arrays;
// Player class: a simple class that will hold the number of strikes,
// word to be guessed, and the string of letters guessed so far.
  
public class Player {
	
	private int strikes;
	private int size;
	private char[] guessWord;
	private char[] dummyWord;
	
	public Player(String a)
	{
		strikes = 0;
		size = a.length();
		guessWord = new char[size];
		dummyWord = new char[size];
		for(int i = 0; i < size; i++)
		{
			guessWord[i]=a.toUpperCase().charAt(i);
			dummyWord[i]='-';
		}
		
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int s) {
		strikes = s;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int s) {
		size = s;
	}

	public String getGuessWord() 
	{
		String output = new String(guessWord);
		return output;
	}

	public void setGuessWord(char[] guess) 
	{
		guessWord = guess;
	}

	public String getDummyWord() 
	{
		String output = new String(dummyWord);
		return output;
	}

	public void setDummyWord(char[] dummy)
	{
		dummyWord = dummy;
	}
	
	// Sets all characters in dummyWord that are letter in guessWord to the letter
	public void setDummyCharacter(char letter)
	{
		letter = Character.toUpperCase(letter);
		
		for(int i = 0; i < size; i++)
		{
			if(guessWord[i] == letter)
				dummyWord[i] = letter;
		}
	}
	
	// Returns true if both char arrays are NOT equal.
	// False otherwise.
	public boolean isNotEqual()
	{
		return !Arrays.equals(guessWord, dummyWord);
	}
	
	// Returns true if the guessed char is in the word.
	public boolean isFoundInWord(char ch)
	{
		ch = Character.toUpperCase(ch);
		for(char i : guessWord)
		{
			if(i == ch)
				return true;
		}
		return false;
	}
	
}
