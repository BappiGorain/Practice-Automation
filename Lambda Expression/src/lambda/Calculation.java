package lambda;

interface Sum
{
	int add(int num1, int num2);
}


public class Calculation
{
	public static void main(String[] args) 
	{
		Sum s = (a,b) -> a+b;
		System.out.println(s.add(2,3));
	}	
}
