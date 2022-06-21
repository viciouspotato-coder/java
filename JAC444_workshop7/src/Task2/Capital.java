/**********************************************
Workshop 7
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 03/20/2022
**********************************************/

package Task2;

import java.util.HashMap;
import java.util.Scanner;

public class Capital {
	public static void main(String[] args) {
		HashMap<String, String> capital = new HashMap<String, String>();
		
        Scanner scanner = new Scanner(System.in);

        capital.put("Canada", "Ottawa");
        capital.put("United States", "Washington");
        capital.put("China", "Beijing");
        capital.put("Japan", "Tokyo");
        capital.put("France", "Paris");
        capital.put("India", "Delhi");
        capital.put("Indonesia", "Jakarta");
        capital.put("Pakistan", "Islamabad");
        capital.put("Brazil", "Brasília");
        capital.put("Nigeria", "Abuja");
        capital.put("Bangladesh", "Dhaka");
        capital.put("Russia", "Moscow");
        capital.put("Mexico", "Mexico City");
        capital.put("Ethiopia", "Addis Ababa");
        capital.put("Philippines", "Manila");
        capital.put("Egypt", "Cairo");
        capital.put("Vietnam", "Hanoi");
        capital.put("DR Congo", "Kinshasa");
        capital.put("Turkey", "Ankara");
        capital.put("Iran", "Tehran");
        capital.put("Germany", "Berlin");
        capital.put("Thailand", "Bangkok");
        capital.put("United Kingdom", "London");
        capital.put("Italy", "Rome");
        capital.put("Tanzania", "Dodoma");

        System.out.print("Enter the country: ");
        String country = scanner.next();

        if (capital.get(country) != null) {
            System.out.println(country + "'s captial is " + capital.get(country));
        } else {
            System.out.println("Country not in list");
        }

       scanner.close();
    }
}
