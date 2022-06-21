/**********************************************
Workshop 8
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 03/27/2022
**********************************************/

package Task2;

public class ReverseThread extends Thread {
	static int numOfThread = 50;

	@Override
	public void run() {
		try {
			ReverseThread.numOfThread--; // sort the threads in the reverse
			if (ReverseThread.numOfThread < 0) {
				return;
			}
			ReverseThread t = new ReverseThread();
			t.start();
			t.join();
			System.out.println("Hello from Thread!" + this.getName()); // output for each thread
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		ReverseThread thread = new ReverseThread();
		thread.start();
	}
}
