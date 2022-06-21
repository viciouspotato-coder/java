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

package Task1;

import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		// creates array
		System.out.print("Enter the number of rows and columns in the array: ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		double[][] array = new double[row][column];

		// fills array
		System.out.print("Enter the array:\n");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array[i][j] = input.nextDouble();
			}
		}

		// searches for the max
		double max = 0;
		int x = 0, y = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
					x = i;
					y = j;
				}
			}
		}

		// print result
		if ((int) max == max) {
			System.out.print("The location of the largest element is " + (int) max + " at (" + x + ", " + y + ")");
		} else {
			System.out.print("The location of the largest element is " + max + " at (" + x + ", " + y + ")");
		}
		input.close();
	}
}
