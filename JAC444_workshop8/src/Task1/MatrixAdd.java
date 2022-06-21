/**********************************************
 Workshop # 8
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    05-04-2021
 **********************************************/

package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Arrays;

public class MatrixAdd implements Runnable {
	private double[][] a;
	private double[][] b;

	MatrixAdd(double[][] a, double[][] b) {
		this.a = a;
		this.b = b;
	}

	public void run() {
		double[][] c = new double[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
	}
}

class Main {
	static double[][] res;

	public static double[][] parallelAddMatrix(double[][] a, double[][] b) {
		double[][] result = new double[a.length][a[0].length];
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(
				new MatrixAdd(Arrays.copyOfRange(a, 0, a.length / 4), Arrays.copyOfRange(b, 0, a[0].length / 4)));
		executorService.execute(new MatrixAdd(Arrays.copyOfRange(a, a.length / 4 + 1, a.length / 4 * 2),
				Arrays.copyOfRange(b, a[0].length / 4 + 1, a[0].length / 4 * 2)));
		executorService.execute(new MatrixAdd(Arrays.copyOfRange(a, a.length / 4 * 2 + 1, a.length / 4 * 3),
				Arrays.copyOfRange(b, a[0].length / 4 + 1, a[0].length / 4 * 2)));
		executorService.execute(new MatrixAdd(Arrays.copyOfRange(a, a.length / 4 * 3 + 1, a.length / 4 * 4),
				Arrays.copyOfRange(b, a[0].length / 4 + 1, a[0].length / 4 * 2)));
		executorService.shutdown();
		return result;
	}

	public static double[][] sequentialAddMatrix(double[][] a, double[][] b) {
		double[][] result = new double[a.length][a.length];
		double[][] res = new double[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				res[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		long start, end;

		double[][] a = new double[2000][2000];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = Math.random();
			}
		}

		double[][] b = new double[2000][2000];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = Math.random();
			}
		}

		// parallel addition
		System.out.println("Parallel Test:");
		start = System.currentTimeMillis(); // test begins
		res = parallelAddMatrix(a, b);
		end = System.currentTimeMillis();
		System.out.println("Parallel matrix addition used " + (end - start) + " milliseconds\n");

		System.out.println("Sequential Test:");
		start = System.currentTimeMillis();
		res = sequentialAddMatrix(a, b);
		end = System.currentTimeMillis();
		System.out.println("Sequential matrix addition used " + (end - start) + " milliseconds\n");
	}
}