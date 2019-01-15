// Name: James Gibbons
// USC NetID: 2993752268
// CS 455 PA1
// Fall 2018

import java.util.Scanner;
import javax.swing.JFrame;

/**
 * CoinSimViewer class
 * Prompts user for a number of two coin toss trials greater than 0 and only allows
 * the user to enter a positive non-zero integer.  Creates a JFrame to display the 
 * results of each coin toss in bar graph form
 */

class CoinSimViewer {
	
	public static void main(String[] args) {	
		
		Scanner in = new Scanner(System.in);
		
		// prompts user for # of trials and ensures the user only enters a positive, non-zero integer
		boolean valid = false;
		while (!valid) {
			
			System.out.print("Enter number of trials: ");
			int enteredTrials = in.nextInt();
	
			if (enteredTrials > 0) {
				valid = true;
				JFrame frame = new JFrame();
				frame.setSize(800, 500);
				frame.setTitle("CoinSim");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CoinSimComponent component = new CoinSimComponent(enteredTrials);
				frame.add(component);
				frame.setVisible(true);
			}
			else {
				System.out.println("ERROR: Number entered must be greater than 0.");
			}
		}
	}
}