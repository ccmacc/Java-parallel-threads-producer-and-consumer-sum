/*CLint McCarthy
 * ICS 462 Assignment #1
 * 5/26/18
 * 
 * This program contains a Producer thread which initiates a variable too 100 and then sets a variable equal to the count of the loop number as it 
 * goes through a loop 5 times. The Consumer thread reads the varible from the Producer in a loop 5 times, sums the total, and writes the total to a file.
 * Both the Producer and Consumer contain random sleeps in the for loops from 1 to 3 seconds
*/

import java.io.IOException;

public class Run {
	//main class to call the Producer and Consumer classes
	public static void main(String[] args) throws InterruptedException, IOException {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		producer.start();
		consumer.start();

	}
}
