/**********************************************
Workshop 4
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/20/2022
**********************************************/

package Task1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hangman {
	 public static void main(String[] args) throws Exception{
		 //initialization
		 Scanner input = new Scanner(System.in);
		 char go = 'y';
		 String tries;
		 char guess;
		 String hidden;
		 int misses;
		 Random RNG = new Random();
		//loads words from text
		 Scanner fileReader = new Scanner(new File("hangman.txt"));
		 ArrayList<String> words = new ArrayList<>();
		 while (fileReader.hasNextLine()) {
		     words.add(fileReader.nextLine().trim());
		 }
		 fileReader.close();
		 
		 while (go == 'Y' || go == 'y') {
			 //assign
			 tries = "";
			 hidden = "";
			 misses = 0;
			 
			 //picks a random word from the list
			 String answer = words.get(RNG.nextInt(words.size()));
			 for (int i = 0; i < answer.length(); i++) {
				 hidden += '*';
			 }
			 
			 //loops till the game is finished
			 while (!hidden.equals(answer)) {
				 System.out.print("(Guess) Enter a letter in word " + hidden + " > ");
				 guess = input.next().charAt(0);
				 //logic
				 if (tries.indexOf(guess) == -1) {
					 if (answer.indexOf(guess) == -1) {
						 System.out.print(" " + guess + " is not in the word\n");
						 misses++;
					 } else {
						 String temp = "";
						 for (int i = 0; i < answer.length(); i++) {
							 if (answer.charAt(i) == guess) {
								 temp += guess;
							 } else {
								 temp += hidden.charAt(i);
							 }
						 }
						 hidden = temp;
					 }
					 tries += guess;
				 } else {
					 if (hidden.indexOf(guess) == -1) {
						 System.out.print("You have already tried " + guess + ", try a new letter\n");
						 
					 } else {
						 System.out.print(" " + guess + " is already in the word\n");
					 }
				 }
			 }
			 //result
			 System.out.print("The word is " + answer + ". You missed " + misses + (misses == 1 ? " time" : " times"));
			 //add new word
			 System.out.print("\nEnter a new word to be added in the memory> ");
			 String newWord = input.next();
			 //checks in the new world is already in the list
			 if (words.contains(newWord)) {
				 System.out.print("Word already exists.\n");
			 } else {
				 //appends new word to text
				 try(BufferedWriter writer = new BufferedWriter(new FileWriter("hangman.txt", true))){
					    writer.write(newWord + "\n");
					    words.add(newWord);
					}
				 catch(IOException e){
						// handle the exception
					}
			 }
			 //safeguard
			 do {
				 System.out.print("Do you want to guess another word? Enter y or n> ");
				 go = input.next().charAt(0);
			 } while(go != 'Y' && go != 'y' && go != 'N' && go != 'n');
		 }
		 input.close();
	     System.out.println("It's finally over");
	 }
}
