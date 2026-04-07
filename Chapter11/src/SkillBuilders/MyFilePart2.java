package SkillBuilders;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFilePart2 
{

	public static void main(String[] args) 
	{
		File textFile;
		try (Scanner input = new Scanner(System.in)) {
			String response;
			
			textFile = new File("../Chapter11/src/SkillBuilders/Test2.txt");
			
			if(textFile.exists())
			{
				System.out.println("Test2.txt file exists.");
			}
			else
			{
				try
				{
					textFile.createNewFile();
					System.out.println("Test2.txt file has been created.");
				}
				catch (IOException e                                                       ) 
				{
					System.out.println("File could not be created.");
					System.out.println("IOException: " + e.getMessage());
				}
			}
			
			//Delete if user chooses to do so, Keep if user chooses to do so
			System.out.println("Would you like to (K)eep or (D)elete the file?");
			response = input.next();
			
			if(response.equalsIgnoreCase("D"))
			{
				if(textFile.delete())
				{
					System.out.println("File has been deleted.");
				}
			}
			else
			{
				System.out.println("File is kept and stays the same");
			}
		}

	}

}