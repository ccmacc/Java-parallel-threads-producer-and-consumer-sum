
/*CLint McCarthy
 * ICS 462 Assignment #1
 * 5/26/18
 * 
 * This class writes a reads the variable created by the Producer class, sums up the values, and writes the sum to a file
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Consumer {
	// private variable declarations
	private static Random random = new Random();
	private static final int MINTIME = 1000;
	private static final int MAXTIME = 3000;
	private static String sumString;
	private static int sum;
	private static int value;

	// inner class to implement runnable
	public void start() {
		Runnable r = new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException | IOException e) {

					e.printStackTrace();
				}
			}
		};
		// spin up new thread
		Thread t = new Thread(r);
		t.start();

	}

	private void consumer() throws InterruptedException, IOException {

		// get variable from Producer and sum the values with a 1 to 3 second
		// sleep between passes through the loop
		for (int i = 0; i < 5; i++) {
			Thread.sleep(random.nextInt(MAXTIME - MINTIME + 1));
			value = Producer.getVariable();
			sum = sum + value;

		}

		// write sum to a file
		BufferedWriter bw = new BufferedWriter(new FileWriter("Asg1Test2.txt"));
		bw.write("Clint McCarthy");
		bw.newLine();
		bw.write("ICS 462 Assignment #1");
		bw.newLine();
		bw.write("The sum is: " + sum);

		bw.flush();
		bw.close();

	}

}
