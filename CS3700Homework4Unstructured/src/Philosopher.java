import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock; 

/*
 * David Hau
 * CS3700
 * 10/15/2018
 */

public class Philosopher implements Runnable
{
	String name;
	ReentrantLock forkLeft = null;
	ReentrantLock forkRight = null;
	
	public Philosopher(String name, ReentrantLock forkLeft, ReentrantLock forkRight)
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
			System.out.println("Philosopher " + name + ": attempt to acquire fork to left");
			if(forkLeft.tryLock())
			{
				forkLeft.lock();
				System.out.println("Philosopher " + name + ": acquired left fork");
				System.out.println("Philosopher " + name + ": attempt to acquire fork to right");
				if(forkRight.tryLock())
				{
					forkRight.lock();
					System.out.println("Philosopher " + name + ": acquired right fork");
					long time = ThreadLocalRandom.current().nextLong(0, 10000);
					
					Thread.sleep(time);
					System.out.println("Philosopher " + name + ": Eating for " + (time / 1000) + " seconds");
				}
			}
			
		}
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
		finally
		{
			System.out.println("Philosopher " + name + ": releasing left fork");
			forkLeft.unlock();
			
			System.out.println("Philosopher " + name + ": releasing right fork");
			forkRight.unlock();
			
			think();
		}
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
