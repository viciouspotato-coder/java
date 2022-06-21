/**********************************************
Workshop 1
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 1/30/2022
**********************************************/

package Task2;

import java.util.Random;

public class Craps {

	public static void main(String[] args) {
		// instance of random class
		Random rand = new Random();

		// initialize and declare variables;
		int point = 0, dice1 = 0, dice2 = 0, sum = 0;
		boolean gameOver = false;

		// loop
		while (!gameOver) {
			// rolls
			dice1 = rand.nextInt(5) + 1;
			dice2 = rand.nextInt(5) + 1;
			sum = dice1 + dice2;

			// print
			System.out.print("You rolled " + dice1 + " + " + dice2 + " = " + sum + "\n");

			// calculating result
			if (sum == 2 || sum == 3 || sum == 12) {
				// announces result and breaks loop
				System.out.print("Craps, Better Luck Next Time, You lose\n");
				gameOver = true;
			} else if (sum == 7 || sum == 11 || sum == point) {
				// announces result and breaks loop
				System.out.print("Congratulations, You win\n");
				gameOver = true;
			} else {
				// assigning a value to point
				if (point == 0) {
					point = sum;
					System.out.print("Point is (established) set to " + point + "\n");
				}
			}
		}
	}

}
