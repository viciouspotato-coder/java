/**********************************************
Workshop 10
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 04/10/2022
**********************************************/

package Task2;

import java.util.Scanner;

public class Bank {
	static double[][] asset;

	public static boolean[] checking(double[][] list, double limit) {
		boolean[] unsafeBank = new boolean[list.length];
		double total;
		boolean safe = false;
		while (!safe) {
			safe = true;
			for (int banks = 0; banks < list.length; banks++) {
				total = list[banks][0];
				for (int bankB = 1; bankB < list[banks].length; bankB += 2) {
					int ind = (int) list[banks][bankB];
					if (!unsafeBank[ind])
						total += list[banks][bankB + 1];
				}
				if (total < limit && !unsafeBank[banks]) {
					unsafeBank[banks] = true;
					safe = false;
				}
			}
		}
		return unsafeBank;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of banks: ");
		asset = new double[scanner.nextInt()][];
		System.out.print("Minimum asset limit: ");
		double minimum = scanner.nextDouble();

		// record bank info
		for (int i = 0; i < asset.length; i++) {
			System.out.println("For Bank # " + i);
			System.out.print("\tBalance: ");
			double balance = scanner.nextDouble();
			System.out.print("\tNumber of banks Loaned: ");
			int numBanks = scanner.nextInt();

			asset[i] = new double[numBanks * 2 + 1];
			asset[i][0] = balance;
			for (int j = 1; j < asset[i].length; j += 2) {
				System.out.print("\t\tBank ID who gets the loan: ");
				asset[i][j] = scanner.nextInt();
				System.out.print("\t\tLoaned Amount: ");
				asset[i][j + 1] = scanner.nextDouble();
			}
		}
		scanner.close();

		// check bank safety
		double total = 0;
		boolean[] safe = new boolean[asset.length];
		boolean restSafe = false;
		while (!restSafe) {
			restSafe = true;
			for (int bankA = 0; bankA < asset.length; bankA++) {
				total = asset[bankA][0];
				for (int bankB = 1; bankB < asset[bankA].length; bankB += 2) {
					if (!safe[(int) asset[bankA][bankB]]) {
						total += asset[bankA][bankB + 1];
					}
				}
				if (total < minimum && !safe[bankA]) {
					safe[bankA] = true;
					restSafe = false;
				}
			}
		}
		String string = "";
		for (int i = 0; i < safe.length; i++) {
			if (safe[i])
				string += " Bank " + i;
		}
		System.out.print("Unsafe banks are" + string + "\n");
	}
}
