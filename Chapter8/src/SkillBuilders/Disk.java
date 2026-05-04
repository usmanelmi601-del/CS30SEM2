package SkillBuilders;

public class Disk extends Circle
{
	private double thickness;
	
	//Overload Constructor method
	public Disk(double r, double t)
	{
		super(r);
		thickness = t;
	}
	
	public void setThickness(double newT)
	{
		thickness = newT;
	}
	
	public double gethickness()
	{
		return thickness;
	}
	
	public double volume()
	{
		double v;
		
		v = super.area() * thickness;
		
		return v;
	}
	
	public boolean equals(Object obj) 
	{
		Disk testObj = (Disk)obj;
		
	 	if (testObj.getRadius() == super.getRadius() && testObj.gethickness() == thickness)
	 			  
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
		String DiskString;

	DiskString = "The disk has radius " 
		+ super.getRadius()
		+ " and thickness "
		+ thickness + ".";
	 	
	return DiskString;
	}
	
	
}
