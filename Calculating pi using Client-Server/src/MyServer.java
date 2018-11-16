import java.io.IOException;       
import java.net.ServerSocket;

public class MyServer {
  public static void main(String[] args) throws IOException {
    final int size = 3; //4, 5, 6, etc. The smaller this is made the sooner the average is calculated. 
    double sum = 0;
    final int PORT = 8906;
    ServerSocket serverSocket = null;
    MyThread[] a = new MyThread[size];
    Thread[] t = new Thread[size];

    try {    
      serverSocket = new ServerSocket(PORT);
      for (int i = 0; i < size; i++) {
          a[i] = new MyThread(serverSocket.accept());
          System.out.println("server is ready...");
          t[i] = new Thread(a[i]);
          t[i].start();
        }
      
      for (int i = 0; i < size; i++) {
          try {
            t[i].join();
          } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
          }
        }
      
      for (int i = 0; i < size; i++) {
          sum += a[i].getValue();
        }
        System.out.println("The average is: " + sum / size);
    
        serverSocket.close();
    } catch (Exception e) {  
      System.out.println("Error: " + e);
      System.exit(0);
    } 
  }
}