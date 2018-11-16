import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {
  public static void main(String[] args){
    //Complete this method.
    ServerSocket serverSocket = null;
    Scanner keyboard = new Scanner(System.in);
    try {
      serverSocket = new ServerSocket(16790);
      Socket clientSocket = null;
      clientSocket = serverSocket.accept();
      System.out.print("Server is ready\n ");
      System.out.print("Enter blue/green for a color ");
      String s = keyboard.nextLine();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      out.println("" + s);    
      System.out.print("Enter a message");
      String a = keyboard.nextLine();
      out.println("" + a);
      out.close();
      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }
  }
}
