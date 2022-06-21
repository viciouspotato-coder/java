/**********************************************
Workshop 2
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/06/2022
**********************************************/

package Task1;

import java.util.Scanner;

public class TestClass {
	//the two following arrays are used to construct the tax2001 class
    public static int[][] intervals2001 = {
            {27050, 65550, 136750, 297350},
            {45200, 109250, 166500, 297350},
            {22600, 54625, 83250, 148675},
            {36250, 93650, 151650, 297350}
    };

    public static double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

    public static void main(String[] args) {
    	//uses above variables to create the IncomeTax for 2001, status and taxableIncome can be replaced later
    	IncomeTax tax2001 = new IncomeTax(0, intervals2001, rates2001, 0);
    	//initialize default IncomeTax which is 2009, status and taxableIncome can be replaced later
    	IncomeTax tax2009 = new IncomeTax();
    	//initialize the variables
    	int option = -1;
    	int status = 0;
    	double income = 0;
    	double incomeStart = 0;
    	double incomeEnd = 0;
    	//creates scanner for input
    	Scanner input = new Scanner(System.in);
    	//the program will loop till 0 is entered, option is initialized at -1 so the program will at least run it once
    	while (option != 0) {
    		//prompts for user option
    		System.out.print("\nMenu:\n"
    				+ "1 - Compute personal income Tax\n"
    				+ "2 - Print the tax tables for taxable incomes (with range)\n"
    				+ "0 - Exit\n\n");
            option = input.nextInt();
    		switch(option) {
    		//option 0 will break both the switch case and while loop
    		case 0:
    			break;
    		case 1:
    			System.out.print("\nIncome Tax Calculator:\n"
    					+ "0—single filer\n"
    					+ "1—married filing jointly or qualifying widow(er)\n"
    					+ "2—married filing separately\n"
    					+ "3—head of household\n"
    					+ "\nEnter the filing status: ");
    			status = input.nextInt();
    			//safeguard
    			while (status < 0 || status > 3) {
    				System.out.print("\nInvalid input\n"
    						+ "\nEnter the filing status: ");
    				status = input.nextInt();
    			}
    			//changes status to the one user entered
    			tax2009.setFilingStatus(status);
    			System.out.print("\nEnter the Taxable Income: $");
    			income = input.nextDouble();
    			//safeguard
    			while (income < 0) {
    				System.out.print("\nInvalid input\n"
    						+ "\nEnter the Taxable Income: $");
    				income = input.nextDouble();
    			}
    			//changes taxableIncome to the one user entered
    			tax2009.setTaxableIncome(income);
    			//calculates tax and print
    			System.out.printf("\nTax is: $%.2f\n", tax2009.getIncomeTax());
    			break;
    		case 2:
    			//prompts for start and end
    			System.out.print("\nEnter the amount From: $");
    			incomeStart = input.nextDouble();
    			System.out.print("\nEnter the amount From: $");
    			incomeEnd = input.nextDouble();
    			//checks if the range is too small and more safeguard
    			while ((incomeEnd - incomeStart) / 1000 < 1) {
    				System.out.print("\nRange too small\n");
    				System.out.print("\nEnter the amount From: $");
        			incomeStart = input.nextDouble();
        			System.out.print("\nEnter the amount From: $");
        			incomeEnd = input.nextDouble();
    			}
    			//header
    			System.out.printf("\n2001 tax tables for taxable income from $%.0f to $%.0f\n", incomeStart, incomeEnd);
    			//calls print function below
                print(tax2001, incomeStart, incomeEnd);
                //header
                System.out.printf("\n2009 tax tables for taxable income from $%.0f to $%.0f\n", incomeStart, incomeEnd);
                //calls print function below
                print(tax2009, incomeStart, incomeEnd);
    			break;
    		default:
    			System.out.print("\nInvalid input\n");
    			break;
    		}
    	}
    	input.close();
    	System.out.print("\nEXIT PROGRAM\n");
    }

    //print function to prevent the main from being too cluttered
    public static void print(IncomeTax incomeTax, double fromIncome, double toIncome) {
    	//header
        System.out.print("---------------------------------------------------------------------------------\n"
        		+ "Taxable     Single      Married Joint     Married        Head of\n"
        		+ "Income                  or Qualifying     Separate       a house\n"
        		+ "                         Widow(er)\n"
        		+ "---------------------------------------------------------------------------------\n");
        //loop every 1000 difference
        for (double taxableIncome = fromIncome; taxableIncome <= toIncome; taxableIncome += 1000) {
        	//set taxableIncome to input variable the first time, it will increase by 1000 with every loop
            incomeTax.setTaxableIncome(taxableIncome);
            System.out.printf("%-12.0f", taxableIncome);
            //set filingStatus to 0
            incomeTax.setFilingStatus(0);
            //result
            System.out.printf("%-12.2f", incomeTax.getIncomeTax());
            //set filingStatus to 1
            incomeTax.setFilingStatus(1);
            //result
            System.out.printf("%-18.2f", incomeTax.getIncomeTax());
            //set filingStatus to 2
            incomeTax.setFilingStatus(2);
            //result
            System.out.printf("%-15.2f", incomeTax.getIncomeTax());
            //set filingStatus to 3
            incomeTax.setFilingStatus(3);
            //result
            System.out.printf("%-12.2f\n", incomeTax.getIncomeTax());
        }
    }
}