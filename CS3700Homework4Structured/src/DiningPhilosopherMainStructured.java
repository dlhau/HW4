/*
 * David Hau
 * CS3700
 * 10/15/2018
 */

public class DiningPhilosopherMainStructured
{
	private static final Fork FORK_ONE = new Fork("One");
	private static final Fork FORK_TWO = new Fork("Two");
	private static final Fork FORK_THREE = new Fork("Three");
	private static final Fork FORK_FOUR = new Fork("Four");
	private static final Fork FORK_FIVE = new Fork("Five");
	
	
	public static void main(String[] args)
	{
		Thread philosopherA = new Thread(new Philosopher("A", FORK_FIVE, FORK_ONE));
		Thread philosopherB = new Thread(new Philosopher("B", FORK_ONE, FORK_TWO));
		Thread philosopherC = new Thread(new Philosopher("C", FORK_TWO, FORK_THREE));
		Thread philosopherD = new Thread(new Philosopher("D", FORK_THREE, FORK_FOUR));
		Thread philosopherE = new Thread(new Philosopher("E", FORK_FOUR, FORK_FIVE));
		
		philosopherA.start();
		philosopherB.start();
		philosopherC.start();
		philosopherD.start();
		philosopherE.start();
	}
}
