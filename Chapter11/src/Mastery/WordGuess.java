/*
Program: WordGuess.java          
Purpose: This Java program reads words from a file, randomly selects one, and lets the user guess it letter by letter until it is solved or the user quits.


Author: Usman Elmi, 
School: CHHS
Course: Computer Programming 30
 

*/


package Mastery;

import java.io.*;
import java.util.*;

public class WordGuess 
{

	public static void main(String[] args) 
	{
		final String FLAG = "!";

		// Create a File object with the name of your file as the parameter
		File wordFile;

		// Declare a File reader object
		FileReader in;

		// Declare a BufferedReader object
		BufferedReader readFile;

		// Create a random number object
		Random rand = new Random();

		int numWords = 0, wordToGuess;
		String secretWord = "";
		String wordSoFar = "", updatedWord = "";
		String letterGuess, wordGuess = "";
		int numGuesses = 0;	

		Scanner input = new Scanner(System.in);
		String fileName;

		/* select secret word */
		try {
				// prompt user for file name
				System.out.print("Enter the name of the word file: ");
				fileName = input.nextLine();

				// initialize the file reader object to name of the file object
				wordFile = new File(fileName);
				in = new FileReader(wordFile);

                // initialize the BufferedReader object
				readFile = new BufferedReader(in);

				ArrayList<String> wordList = new ArrayList<>();
				String line;

				// Get the number of words in the file
				while ((line = readFile.readLine()) != null) 
				{
					wordList.add(line.toLowerCase());
				}

				numWords = wordList.size();

                // update the word to guess randomly
				wordToGuess = rand.nextInt(numWords);

                // iterate to get the secret word
				secretWord = wordList.get(wordToGuess);

                // close readers
				readFile.close();
				in.close();

    	} catch (FileNotFoundException e) 
        {
			System.out.println("File not found.");
			return;
		} catch (IOException e) 
        {
			System.out.println("Error reading file.");
			return;
    	}

		/* begin the game */
		System.out.println("WordGuess game.\n");

        // create dashed word
		for (int i = 0; i < secretWord.length(); i++) 
		{
			wordSoFar += "-";
		}

        // output dashed word
		System.out.println("Secret word: " + wordSoFar);

		/* allow player to make guesses*/
		do {
			// prompt for a letter
			System.out.print("Guess a letter (or ! to quit): ");
			letterGuess = input.nextLine().toLowerCase();

			if (letterGuess.equals(FLAG)) 
			{
				break;
			}

			/* increment number of guesses */
			numGuesses++;

			/* update word */
			StringBuilder temp = new StringBuilder(wordSoFar);

			for (int i = 0; i < secretWord.length(); i++) 
			{
				if (secretWord.charAt(i) == letterGuess.charAt(0)) 
				{
					temp.setCharAt(i, letterGuess.charAt(0));
				}
			}

			wordSoFar = temp.toString();

			/* display guessed letter instead of dash */
			System.out.println("Secret word: " + wordSoFar);

		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(secretWord));

		/* finish game and display message and number of guesses */
		if (wordSoFar.equals(secretWord)) 
		{
			System.out.println("Congratulations! You guessed it!");
		} 
		else 
		{
			System.out.println("Quitter! The word was: " + secretWord);
		}

		System.out.println("Number of guesses: " + numGuesses);

		input.close();
	}
}


/* Screen Dump
 * Enter the name of the word file: ../Chapter11/src/Mastery/Words.txt

WordGuess Game

Secret word: -----
Guess a letter (or ! to quit): a
Secret word: a----
Guess a letter (or ! to quit): j
Secret word: a----
Guess a letter (or ! to quit): p
Secret word: app--
Guess a letter (or ! to quit): e
Secret word: app-e
Guess a letter (or ! to quit): l
Secret word: apple
Congratulations! You guessed it!
Number of guesses: 5

*/

