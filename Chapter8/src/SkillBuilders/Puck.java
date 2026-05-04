package SkillBuilders;

public class Puck extends Disk implements Comparable {

	
	
		private double weight;
		private boolean standard, youth;
		
		double MIN_STD_W = 5;
		double MAX_STD_W = 5.5;
		double MIN_YTH_W = 4;
		double MAX_YTH_W = 4.5;
		
		//Overload Constructor method
		
		public Puck(double w)
		{
			super(1.5, 1);
			weight = w;
			
			if(weight >= MIN_STD_W && weight <= MAX_STD_W)
			{
				standard = true;
				youth = false;
			}
			else
			{
				standard = false;
				youth = true;
		}
	
}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public String getDivision()
		{
			String div;
			
			if(standard)
			{
				div = "Puck is standard";
			}
			else
			{
				div = "Puck is youth";
			}
			
			return(div);
		}
		public double getWeight()
		{
			return weight;
		}

		public boolean equals(Object obj) 
		{
			Puck testObj = (Puck)obj;
			
		 	if (testObj.getDivision() == getDivision()) 
		 	{
				return true;
			} 
		 	else 
		 	{
				return false;
			}
		}
		
		public String toString() 
		{
			String PuckString;

			PuckString = "The puck has a weight " + getWeight()
						+ " and division "+ getDivision();
		 	return(PuckString);
		}
		
		public int compareTo1(Object p)
		{
			Puck testPuck = (Puck)p;
			
			if(weight < testPuck.getWeight())
			{
				return(-1);
			}
			else if(weight == testPuck.getWeight())
			{
				return(0);
			}
			else
			{
				return(1);
			}
		}
		
}