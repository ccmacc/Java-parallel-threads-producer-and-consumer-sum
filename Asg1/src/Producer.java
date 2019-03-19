/*CLint McCarthy
 * ICS 462 Assignment #1
 * 5/26/18
 * 
 * This class writes a variable from a loop counter between 0 and 4
*/

import java.io.IOException;
import java.util.Random;

public class Producer {
	// private variable declarations
	private static final int MINTIME = 1000;
	private static final int MAXTIME = 3000;
	private static int counter = 0;
	private static Random random = new Random();
	static int variable = 100;

	// inner class to implement runnable
	public void start() {
		Runnable r = new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
		};
		// spin up new thread
		Thread t = new Thread(r);
		t.start();

	}

	public void producer() throws InterruptedException, IOException {
		// loop to increment counter with a 1 to 3 second sleep between passes through the loop
		for (int i = 0; i < 4; i++) {
			Thread.sleep(random.nextInt(MAXTIME - MINTIME + 1));
			counter++;
			variable = counter;
		}
	}

	// getter used by Consumer class
	public static int getVariable() {
		return variable;
	}

}
