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

package Task1;

import java.util.Calendar;
import java.util.Scanner;

public class Time implements Comparable<Time>, Cloneable {
	int hour, minute, second, elapsed;

	public Time() {
		Calendar current = Calendar.getInstance();
		this.hour = current.get(Calendar.HOUR);
		this.minute = current.get(Calendar.MINUTE);
		this.second = current.get(Calendar.SECOND);
	}

	public Time(int hour, int minute, int second) {
		this.elapsed = (hour * 3600) + (minute * 60) + second;
		getHour();
		getMinute();
		getSecond();
	}

	public Time(int elapsed) {
		this.elapsed = elapsed;
		getHour();
		getMinute();
		getSecond();
	}

	public int getHour() {
		this.hour = (int) this.elapsed / 3600 % 24;
		return this.hour;
	}

	public int getMinute() {
		this.minute = (int) this.elapsed / 60 % 60;
		return this.minute;
	}

	public int getSecond() {
		this.second = (int) this.elapsed % 60;
		return this.second;
	}

	public int getSeconds() {
		return this.elapsed;
	}

	public String toString() {
		return this.hour + (this.hour == 1 ? " hour " : " hours ") + this.minute
				+ (this.minute == 1 ? " minute " : " minutes ") + this.second
				+ (this.second == 1 ? " second " : " seconds ");
	}

	@Override
	public int compareTo(Time time) {
		return this.elapsed - time.elapsed;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hour, minute, second, elapsedTime;
		System.out.print("Enter time1 (hour minute second): ");
		hour = scanner.nextInt();
		minute = scanner.nextInt();
		second = scanner.nextInt();
		Time time1 = new Time(hour, minute, second);
		System.out.println(time1.toString());
		System.out.println("Elapsed seconds in time1: " + time1.getSeconds() + "\n");

		System.out.print("Enter time2 (elapsed time in seconds): ");
		elapsedTime = scanner.nextInt();
		Time time2 = new Time(elapsedTime);
		System.out.println(time2.toString());
		System.out.println("Elapsed seconds in time2: " + time2.getSeconds() + "\n");
		System.out.println("time1.compareTo(time2)? " + time1.compareTo(time2) + "\n");

		System.out.println("time3 is created as a clone of time1");
		try {
			Time time3 = (Time) time1.clone();
			System.out.println("time1.compareTo(time3)? " + time1.compareTo(time3));
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		scanner.close();
	}
}
