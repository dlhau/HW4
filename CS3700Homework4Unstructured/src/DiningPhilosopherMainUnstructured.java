import java.util.concurrent.locks.ReentrantLock; 

/*
 * David Hau
 * CS3700
 * 10/15/2018
 */

public class DiningPhilosopherMainUnstructured
{
	private static final ReentrantLock FORK_ONE = new ReentrantLock();
	private static final ReentrantLock FORK_TWO = new ReentrantLock();
	private static final ReentrantLock FORK_THREE = new ReentrantLock();
	private static final ReentrantLock FORK_FOUR = new ReentrantLock();
	private static final ReentrantLock FORK_FIVE = new ReentrantLock();
	
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
