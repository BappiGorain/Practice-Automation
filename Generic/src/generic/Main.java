package generic;

public class Main 
{
	public static void main(String[] args) 
	{
		Box<Integer> box1 = new Box<Integer>(10);
		System.out.println(box1.getValue());
		
		
		
		Box<String> box2 = new Box<String>("Hello world");
		System.out.println(box2.getValue());
	}
}
