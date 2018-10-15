/*
 * David Hau
 * CS3700
 * 10/15/2018
 */

public class Fork
{
	private boolean inUse;
	private String name;
	
	public Fork(String name)
	{
		this.name = name;
	}
	
	public synchronized void acquire()
	{
		System.out.println("Fork " + name + " Used.");
		this.inUse = true;
	}
	
	public synchronized void release()
	{
		System.out.println("Fork " + name + " Released.");
		this.inUse = false;
	}
	
	public boolean getUse() { return inUse; }
	public String getName() { return name; }
}
