// Name: James Gibbons
// USC NetID: 2993752268
// CS 455 PA1
// Fall 2018

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * CoinSimComponent class
 * Initalizes the CoinTossSimulator data and creates and draws an
 * individual bar object for the amount of heads-heads, tails-tails,
 * and heads-tails value from the user given number of trials.
 */

public class CoinSimComponent extends JComponent {
	
	private static final int VERTICAL_BUFFER = 50;
	private static final int BAR_WIDTH = 50;
	
	private CoinTossSimulator simulator;
	
	/**
		contructor initializing a CoinSimComponent object
		which creates a new CoinToss simulator and using its run
		method with the user entered amount of trials
	  @param enteredTrials used to run an amount of trials
	*/
		
	public CoinSimComponent(int enteredTrials) {
		
		simulator = new CoinTossSimulator();
		simulator.run(enteredTrials);
	
	}
	
	public void paintComponent(Graphics g) {
		
		//creating a scale to adjust bar based on value of frame height
		double scale = getHeight() - 2 * VERTICAL_BUFFER;		
		
		//the fraction of each of the potential outcomes of the run trials
		double twoHeadsRatio = (double) simulator.getTwoHeads()/simulator.getNumTrials();
		double headsAndTailsRatio = (double) simulator.getHeadTails()/simulator.getNumTrials();
		double twoTailsRatio = (double) simulator.getTwoTails()/simulator.getNumTrials();
		
		//adjusting the bar height of the outcomes based on the scale and the fraction of runs
		int barHeightTwoHeads = (int) (scale * twoHeadsRatio);
		int barHeightHeadsAndTails = (int) (scale * headsAndTailsRatio);
		int barHeightTwoTails = (int) (scale * twoTailsRatio);
		
		//the width between each bar and the frame and the outer bars
		int width = (getWidth() - 3 * BAR_WIDTH) / 4;
		
		//evenly spacing the bars horizontally on the frame
		int leftTwoHeads = width;
		int leftHeadsAndTails = 2 * width + BAR_WIDTH;
		int leftTwoTails = 3 * width + 2 * BAR_WIDTH;
		
		//adjusting coordinate system so bars begin at bottom of frame
		int bottomTwoHeads = getHeight() - VERTICAL_BUFFER - barHeightTwoHeads;
		int bottomHeadsAndTails = getHeight() - VERTICAL_BUFFER - barHeightHeadsAndTails;
		int bottomTwoTails = getHeight() - VERTICAL_BUFFER - barHeightTwoTails;
		
		Graphics2D g2 = (Graphics2D) g;
		
		//initializing the three potential outcome bars with three separate colors
		Bar barTwoHeads = new Bar(bottomTwoHeads, leftTwoHeads, BAR_WIDTH, barHeightTwoHeads, scale, Color.RED, "Two Heads: " + simulator.getTwoHeads() + " (" + Math.round(twoHeadsRatio * 100) + "%)");
		Bar barHeadsAndTails = new Bar(bottomHeadsAndTails, leftHeadsAndTails, BAR_WIDTH, barHeightHeadsAndTails, scale, Color.GREEN, "A Head and a Tail: " + simulator.getHeadTails() + " (" + Math.round(headsAndTailsRatio * 100) + "%)");
		Bar barTwoTails = new Bar(bottomTwoTails, leftTwoTails, BAR_WIDTH, barHeightTwoTails, scale, Color.BLUE, "Two Tails: " + simulator.getTwoTails() + " (" + Math.round(twoTailsRatio * 100) + "%)");

		barTwoHeads.draw(g2);
 		barHeadsAndTails.draw(g2);
 		barTwoTails.draw(g2);
	}
}