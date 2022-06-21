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

package Task2;

import java.util.Scanner;

public class TestThrowable {
	
	public static void main(String[] args) {
    	int option = 1;
    	double[] sides = new double[3];
    	Scanner input = new Scanner(System.in);
    	while (true) {
    		System.out.print("\nMenu:\n"
    				+ "0 - Exit\n"
    				+ "Any other number - Calculate new triangle\n\n");
    		option = input.nextInt();
    		if (option == 0) {
    			break;
    		}
    		
        	System.out.print("\nEnter the triangle sides: ");
            for (int i = 0; i < 3; i++) {
                sides[i] = input.nextDouble();
            }
            try {
            	TriangleThrowable t1 = new TriangleThrowable(sides[0], sides[1], sides[2]);
            	System.out.print("\n" + t1.toString() + "\n");
            } catch(TriangleException error) {
            	System.out.println("\n" + error.getMessage());
            }
    	}        
        input.close();
    }
}