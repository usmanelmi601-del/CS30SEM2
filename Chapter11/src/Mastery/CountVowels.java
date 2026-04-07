/*
Program: CountVowels.java          
Purpose: This Java program reads a file entered by the user and counts the number of vowels in its text.

Author: Usman Elmi, 
School: CHHS
Course: Computer Programming 30
 

*/


package Mastery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountVowels 
{

   public static void main(String[] args) 
   {
       File textFile;
       FileReader in;
       BufferedReader readFile;
       String fileName;
       String lineInFile, lowercaseText;
       int vowelSum = 0;

       /* prompt the user for the name of the file */
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the file name: ");
       fileName = scanner.nextLine();
       scanner.close();

       /* count the vowels in the file */
       try {
                // new File object
                textFile = new File(fileName);

                // new FileReader object
                in = new FileReader(textFile);

                // new BufferedReader object
                readFile = new BufferedReader(in);

                // read the lines from the file
                while ((lineInFile = readFile.readLine()) != null) 
                {
                    // convert to lower case
                    lowercaseText = lineInFile.toLowerCase();

                    // iterate through text
                    for (int i = 0; i < lowercaseText.length(); i++) 
                    {
                        char ch = lowercaseText.charAt(i);

                        // check if vowel
                        if ("aeiou".indexOf(ch) != -1) 
                        {
                            vowelSum++;
                        }
                    }
                }

                // output result
                System.out.println("Number of vowels: " + vowelSum);

                // close readers
                readFile.close();
                in.close();
       } 
       catch (IOException e) 
       {
           System.out.println("Error reading file: " + e.getMessage());
       } 
       catch (Exception e) 
       {
           System.out.println("An error occurred.");
       }
 
   }
}


/* Screen Dump
 * Enter the file name: ../Chapter11/src/Mastery/Vowels.txt
Number of vowels: 12

These are all the words:

Gravel
Luminous
Echo
Tangerine

*/