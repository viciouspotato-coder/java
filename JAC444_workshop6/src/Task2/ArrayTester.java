/**********************************************
Workshop 6
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 03/13/2022
**********************************************/

package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class ArrayTester {
    //minimum
    public static final ArrayProcessor min = (arr) -> {
    	double min = arr[0];
        for (double number : arr) {
            if (number < min) {
            	min = number;
            }
        }
        return min;
    };
    
    //maximum
    public static final ArrayProcessor max = (arr) -> {
    	double max = arr[0];
        for (double number : arr) {
            if (number > max) {
            	max = number;
            }
        }
        return max;
    };
    
    //sum
    public static final ArrayProcessor sum = (arr) -> {
        double sum = 0;
        for (double number : arr) {
            sum += number;
        }
        return sum;
    };
    
    //average
    public static final ArrayProcessor avg = (arr) -> {
        return (sum.apply(arr) / arr.length);
    };
    
    //count
    public static ArrayProcessor counter(double value) {
        ArrayProcessor counter = (arr) -> {
            int count = 0;
            for (double number : arr) {
                if (number == value) {
                    count++;
                }
            }
            return count;
        };
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("Enter a few numbers, enter 'done' when done");

        Vector<Double> values = new Vector<>();
        String input = null;
        
        while (!"done".equals(input)) {
            System.out.print("Number to add: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = br.readLine();
            } catch (IOException ioe) {
                System.out.println("IO error trying to read input!");
                System.exit(1);
            }
            if (!"done".equals(input) && !"".equals(input))
            	values.add(Double.parseDouble(input));
        }

        double[] arr = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            arr[i] = values.get(i);
        }
        
        System.out.println("The array of your numbers: " + values);
        System.out.println("maximum value: " + max.apply(arr));
        System.out.println("minimum value: " + min.apply(arr));
        System.out.println("sum of the values: " + sum.apply(arr));
        System.out.println("average of the values: " + avg.apply(arr));
        
        System.out.print("\nPlease enter the value from your array for counting it: ");
        Scanner scanner = new Scanner(System.in);
        ArrayProcessor lambda = counter(scanner.nextDouble());
        System.out.println("The number was entered " + lambda.apply(arr) + " times.\n");
        scanner.close();
    }
}