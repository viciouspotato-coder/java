/**********************************************
Workshop 3
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/13/2022
**********************************************/

package Task1;

import java.util.Scanner;

public class TestClass {
	
    public static void main(String[] args) {
    	System.out.print("Enter the triangle sides: ");
        double[] sides = new double[3];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            sides[i] = input.nextDouble();
        }

      //safeguard
        while (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0) {
        	System.out.print("\nInvalid input\n");
        	System.out.print("\nEnter the triangle sides: ");
        	for (int i = 0; i < 3; i++) {
                sides[i] = input.nextDouble();
            }
        }
        //creates triangle
        Triangle t1 = new Triangle(sides[0], sides[1], sides[2]);
	    System.out.print("Enter color: ");
	    t1.setColor(input.next());
	    System.out.print("Enter filled status: ");
	    String userInput = input.next();
	    if (userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("t")) {
	    	t1.setFilled(true);
	    }
	    System.out.print(t1.toString());
        
        input.close();
    }
}