import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random(System.currentTimeMillis());
		int n = 400;
		int numberOfThreads = Math.abs(r.nextInt()) % 10 + 4; // Number of threads
		while (n % numberOfThreads != 0)
			n++; // To make n divisible by numberOfThreads
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt();
		}

		int segment = arr.length / numberOfThreads;

	
		int biggest = arr[0];
		for (int i = 1; i < n; i++)
			if (biggest < arr[i])
				biggest = arr[i];

		System.out.println("The biggest number of the entire array before creating threads is: " + biggest);


		MyThread[] threads = new MyThread[numberOfThreads]; // Create a number of threads
		
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < numberOfThreads; i++) {
			endIndex = endIndex + segment;
					
			
			threads[i] = new MyThread(Arrays.copyOfRange(arr, startIndex, endIndex));
			startIndex = endIndex;
		}

		for (int i = 0; i < numberOfThreads; i++) {
			threads[i].start();
		}

		for (int i = 0; i < numberOfThreads; i++) {
			threads[i].join();
		}
		int[] biggestInThreadArray = new int[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			biggestInThreadArray[i] = threads[i].biggestInThread;
		}

		int length = biggestInThreadArray.length;
		biggest = biggestInThreadArray[0];
		for (int i = 1; i < length; i++) {
			if (biggest < biggestInThreadArray[i])
				biggest = biggestInThreadArray[i];
		}

		System.out.println("The biggest number of these " + numberOfThreads + " threads is: " + biggest);
	}
}
