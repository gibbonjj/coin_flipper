// Name: James Gibbons
// USC NetID: 2993752268
// CS 455 PA1
// Fall 2018

import java.util.Scanner;

/**
 * class CoinTossSimulatorTester
 * 
 * Unit tests for the proper operation of the CoinTossSimulator methods.
 */

class CoinTossSimulatorTester {
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		
		CoinTossSimulator simulator = new CoinTossSimulator();
		
		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(0, simulator));
		
		simulator.run(1);
		System.out.println("After run(1)");
		System.out.println("Number of trials [exp:1]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(1, simulator));
		
		simulator.run(10);
		System.out.println("After run(2)");
		System.out.println("Number of trials [exp:11]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(11, simulator));
		
		simulator.run(111);
		System.out.println("After run(3)");
		System.out.println("Number of trials [exp:122]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(122, simulator));
		
		simulator.run(1111);
		System.out.println("After run(4)");
		System.out.println("Number of trials [exp:1233]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(1233, simulator));
		
		simulator.run(11111);
		System.out.println("After run(5)");
		System.out.println("Number of trials [exp:12344]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(12344, simulator));
		
		simulator.reset();
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:0]: " + simulator.getNumTrials());
		System.out.println("Two-head tosses: " + simulator.getTwoHeads());
		System.out.println("Two-taill tosses: " + simulator.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUpTest(0, simulator));
		
		
		
		
	}
	/**
		Static method to ensure the number of trials adds up to the tested amount
		testing the getNumTrials() method for the CoinTossSimulator class
		@param numTrialTests the number of trial tests since last reset
		@param simulator the CoinTossSimulator object
		@return a boolean value if the given value eqauls the getNumTrials() value
	*/
	
	public static boolean addUpTest(int numTrialTests, CoinTossSimulator simulator) {
		if (numTrialTests == simulator.getNumTrials()) {
			return true;
		}
		else {
			return false;
		}
	}
}