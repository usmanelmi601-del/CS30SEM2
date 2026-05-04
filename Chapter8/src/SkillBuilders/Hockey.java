package SkillBuilders;

public class Hockey 
{

	public static void main(String[] args) 
	{
		Puck yPuck = new Puck(4.1);
		
		Puck aPuck = new Puck(5.5);
		
		Circle c1 = new Circle(3.0);
		
		Circle c2 = new Circle(2.0);
		
		System.out.println(c1.equals(c2));
		
		System.out.println(yPuck.getDivision());
		
		System.out.println(aPuck.getDivision());


	}

}