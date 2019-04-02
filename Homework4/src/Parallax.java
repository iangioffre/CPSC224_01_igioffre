
/*******************************************************************
	Homework #4
	Due Date: 03-25-2019
	Names: Ian Gioffre and Cole Donovan
	Repo URL: https://github.com/DonovanCo/CPSC224_01_donovan.git
*******************************************************************/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class Parallax extends JFrame
{

	private int midX = 150;
	private int midY = 150;

	// Constructor that creates the frame and
	// adds necessary listeners.
	Parallax()
	{
		setTitle("Motion Parallax");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		ParallaxPanel pp = new ParallaxPanel();
		add(pp);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Parallax();
	}

}
