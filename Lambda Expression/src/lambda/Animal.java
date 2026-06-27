package lambda;


@FunctionalInterface
interface Cat
{
	public void sound(int a, int b);
}

public class Animal
{
	public static void main(String[] args)
	{
		Cat cat = (i,j) -> System.out.println("Meow : " + (i+j));
		cat.sound(5,4);
	}
}
