package SkillBuilders;

public class Circle
{
private static double PI = 3.14;
private double radius;



//Default constructor method
public Circle()
{
	radius = 1;
}

//overload the default constructor
public Circle(double r)
{
	radius = r;
}

public void setRadius(double newR)
{
	radius = newR;
}

public double getRadius() 
{
 	return radius;
}


public double area() 
{
	
 	double circleArea;
 	
 	circleArea = PI * radius * radius;
 	return(circleArea);
}

public boolean equals(Object obj) 
{
	Circle testObj = (Circle)obj;
	
 	if (testObj.getRadius() == radius) 
 	{
		return(true);
	} 
 	else 
 	{
		return(false);
	}
}

public String toString() 
{
	String circleString;

	circleString = "Circle has radius " + radius;
 	return(circleString);
}


}
