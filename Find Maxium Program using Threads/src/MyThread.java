
public class MyThread extends Thread { // Complete this class and run method
	public int biggestInThread = 0;
	int[] array = null;

	public MyThread(int[] array) {
		this.array = array;
	}

	public void run() {
		biggestInThread = findLargest();
	}

	private int findLargest() {
		int n = this.array.length;
		int biggest = this.array[0];
		for (int i = 1; i < n; i++) {
			if (biggest < this.array[i])
				biggest = this.array[i];
		}
		return biggest;
	}
}
