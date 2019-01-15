// Name: James Gibbons
// USC NetID: 2993752268
// CS 455 PA1
// Fall 2018

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

public class CoinTossSimulator {

	private Random generator;
	private int twoHeads;
	private int twoTails;
	private int headsAndTails;
	private int numOfTrials;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
		 generator = new Random();
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
		 
		 for (int i = numTrials; i > 0; i--) {
			 
			 int coin1 = generator.nextInt(2);
			 int coin2 = generator.nextInt(2);
			 //Tests to see if there are two heads (1), two tails (0), or one heads and one tails
			 
			 if (coin1 == 1 && coin1 == coin2) {
				 twoHeads++;
			 }
			 else if (coin1 == 0 && coin1 == coin2) {
				 twoTails++;
			 }
			 else {
				 headsAndTails++;
			 }
			 numOfTrials++;
		 }
   }


   /**
      Get number of trials performed since last reset.
		 @return the number of trials performed
   */
   public int getNumTrials() {
       return numOfTrials;
   }


   /**
      Get number of trials that came up two heads since last reset.
		 @return the number of two heads results for the amount of trials
   */
   public int getTwoHeads() {
       return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
		 @return the number of two tails results for the amount of trials
   */  
   public int getTwoTails() {
       return twoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
		 @return the number of one head and on tail results
   */
   public int getHeadTails() {
       return headsAndTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	 	twoHeads = 0;
	 	twoTails = 0;
	 	headsAndTails = 0;
	 	numOfTrials = 0;
   }

}
