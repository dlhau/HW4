import java.util.concurrent.ThreadLocalRandom;

/*
 * David Hau
 * CS3700
 * 10/15/2018
 */

public class Philosopher implements Runnable
{
	String name;
	Fork forkLeft = null;
	Fork forkRight = null;
	
	public Philosopher(String name, Fork forkLeft, Fork forkRight)
	{
		this.name = name;
		this.forkLeft = forkLeft;
		this.forkRight = forkRight;
	}
	
	private void think()
	{
		try
		{
			long time = ThreadLocalRandom.current().nextLong(0, 10000);
			
			Thread.sleep(time);
			System.out.println("Philosopher " + name + ": Thinking for " + (time / 1000) + " seconds");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	private void eat()
	{
		try
		{
			if(!forkLeft.getUse() && !forkRight.getUse())
			{
				System.out.println("Philosopher " + name + ": attempt to acquire fork to left");
				forkLeft.acquire();
				System.out.println("Philosopher " + name + ": acquired left fork");
				System.out.println("Philosopher " + name + ": attempt to acquire fork to right");
				forkRight.acquire();
				System.out.println("Philosopher " + name + ": acquired right fork");
				
				long time = ThreadLocalRandom.current().nextLong(0, 10000);
				
				Thread.sleep(time);
				System.out.println("Philosopher " + name + ": Eating for " + (time / 1000) + " seconds");
				
				System.out.println("Philosopher " + name + ": releasing Fork " + forkLeft.getName());
				forkLeft.release();
				
				System.out.println("Philosopher " + name + ": releasing Fork " + forkRight.getName());
				forkRight.release();
			}
			
			think();
		} catch(Exception e) { think(); }
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				eat();
			}
			
		} catch(Exception e) {}
	}
	
	
}
