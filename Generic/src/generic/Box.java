package generic;

public class Box<T>
{	
	T container;
	
	Box(T container)
	{
		this.container = container;
	}
	
	public T getValue()
	{
		return this.container;
	}	
}