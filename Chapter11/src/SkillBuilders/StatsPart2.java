package SkillBuilders;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;


public class StatsPart2 
{

	public static void main(String[] args) 
	{
		File dataFile;
		FileReader in;
		BufferedReader readFile;
		FileWriter out;
		BufferedWriter writeFile;
		
		try (Scanner input = new Scanner(System.in)) {
			String fileName;
			int numStud;
			
			String stuName, score;
			
			double scoreValue;
			double lowScore = 100;
			double highScore = 0;
			double avgScore;
			double totalScore = 0;
			int numScores = 0;
			
			
			System.out.println("Enter file name: ");
			fileName = input.next();
			
			System.out.println("How many students? ");
			numStud = input.nextInt();
			
			//Write data to file
			try
			{
				dataFile = new File(fileName);
				out = new FileWriter(dataFile);
				writeFile = new BufferedWriter(out);
				
				for(int i=0; i < numStud; i++)
				{
					System.out.println("Enter student name: ");
					stuName = input.next();
					
					System.out.println("Enter test scores: ");
					score = input.next();
					
					writeFile.write(stuName);
					writeFile.newLine();
					writeFile.write(score);
					writeFile.newLine();
				}
				
				writeFile.close();
				out.close();
				System.out.println("Data written to file");
				
			}
			catch (IOException e) 
			{   
				System.out.println("Problem writing to file.");   System.err.println("IOException: " + e.getMessage());  
			}
			
			
			//Read from the file to get the data
			try
			{
				dataFile = new File(fileName);
				in = new FileReader(dataFile);
				readFile = new BufferedReader(in);
				
				while((stuName = readFile.readLine()) != null)
				{
					score = readFile.readLine();
					System.out.println(stuName + " "+ score);
					
					numScores += 1;
					
					scoreValue = Double.parseDouble(score);
					totalScore += scoreValue;
					
					if(scoreValue < lowScore)
						lowScore = scoreValue;
					
					if(scoreValue > highScore)
						highScore = scoreValue;
					
				}
				avgScore = totalScore / numScores;
				
				NumberFormat percent = NumberFormat.getPercentInstance();

				
				System.out.println("Low score = "
								+ percent.format(lowScore/100));
				
				System.out.println("High score = "
						+ percent.format(highScore/100));
				
				System.out.println("Average =" 
						+ percent.format(avgScore/100));
				
				readFile.close();
				in.close();			
			}
			catch (FileNotFoundException e) 
			{    
				System.out.println("File could not be found.");      System.err.println("FileNotFoundException: "             + e.getMessage());
			}
			catch (IOException e) 
			{   
				System.out.println("Problem writing to file.");   System.err.println("IOException: " + e.getMessage());  
			}
		} catch (NumberFormatException e) {
			
		}
		
	}

}