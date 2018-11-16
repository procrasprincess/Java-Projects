import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class MyClient {
  public static void main(String[] args) throws IOException, IOException {
    try{
	Socket socket = new Socket("localhost", 8906);
    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
    printWriter.println(pi());
    socket.close();
    printWriter.close();
    } catch (IOException f) {
		
		f.printStackTrace();
	}
  }
    
   private static double pi(){
    long toss, number_of_tosses, number_in_circle = 0;
    double x, y, distance_squared, pi_estimate;
    Random generator = new Random();
    number_of_tosses = generator.nextInt(5000) + 5000;
    for (toss = 0; toss < number_of_tosses; toss++) {
      x = 2 * Math.random() - 1;
      y = 2 * Math.random() - 1;
      distance_squared = x * x + y * y;
      if (distance_squared <= 1) number_in_circle++;
    }
    pi_estimate = 4 * number_in_circle / ((double) number_of_tosses);
    return pi_estimate;
  }
}