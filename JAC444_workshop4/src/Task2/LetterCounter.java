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

package Task2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterCounter {
	 public static void main(String[] args) throws Exception {
		 //initialization
        char[] letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
        int[] count = new int[letters.length];
        Scanner scan = new Scanner(System.in);
        int current;
        //reads user input for filename
        System.out.print("Enter a filename: ");
        try(BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))){
	          while ((current = reader.read()) != -1) {
		          for (int i = 0; i < letters.length; i++) {
		              if (current == letters[i]) {
		                  count[i]++;
		              }
		          }
		      }
        }
        catch(IOException e){
            // handle the exception
        }
        for (int i = 0; i < letters.length; i++) {
        	System.out.print("Number of " + letters[i] + "'s: " + count[i] + "\n");
        }
        scan.close();
    }
}
