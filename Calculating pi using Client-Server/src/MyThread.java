import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread implements Runnable {
  private double value = 0;
  public double getValue() {
    return value;
  }

  Socket socket;
  MyThread(Socket socket) {
    this.socket = socket;
  }
  public void run() {
    try {
      String message = null;
      BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while ((message = buff.readLine()) != null) {
        System.out.println("Incoming client message: " + message);
        value = Double.parseDouble(message);
      }
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}