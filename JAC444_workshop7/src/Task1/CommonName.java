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

package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CommonName {
    public static void main(String[] args) {
    	ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> girls = new ArrayList<>();
        ArrayList<String> matches = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String filename = scanner.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] arr = line.split("\t");
                for (String item : arr) {
                    item.trim();
                }
                boys.add(arr[1]);
                girls.add(arr[3].substring(0, arr[3].length() - 1));
            }

            for (String boy : boys) {
                for (String girl : girls) {
                    if (boy.equals(girl)) matches.add(boy);
                }
            }
            
            for (String name : matches) {
            	boys.remove(name);
            	girls.remove(name);
            }
            
            Collections.sort(boys);
            Collections.sort(girls);

            System.out.println(matches.size() + " names used for both genders");
            System.out.print("They are ");
            for (String name : matches) {
                System.out.print(name + " ");
            }
            System.out.println("\n");

            System.out.println(boys.size() + " names used for boys");
            System.out.print("They are ");
            for (String name : boys) {
                System.out.print(name + " ");
            }
            System.out.println("\n");
            
            System.out.println(girls.size() + " names used for girls");
            System.out.print("They are ");
            for (String name : girls) {
                System.out.print(name + " ");
            }
        } catch (Exception error) {
        	System.out.println("File not found");
        } 
        scanner.close();
    }
}
