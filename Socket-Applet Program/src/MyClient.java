import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient extends Applet {
  private String s;
  private String a;
	
  public void init(){
    //Complete this method.
    setSize(400, 400);
    try{
      InetAddress host = InetAddress.getByName("localhost");
      Scanner keyboard = new Scanner(System.in);
      Socket clientSocket = new Socket(host, 16790);
     //You may need to call the method: repaint();
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      s = in.readLine();
      a = in.readLine();
    }catch(Exception e){
      System.out.println("Error: " + e);
      System.exit(0);
    }
  }

  public void paint(Graphics page){
	 if(s.equals("green")) {
	 setBackground(Color.GREEN);
	   page.drawString(a, 20, 20);
	 }else {
		 if(s.equals("blue")) {
			 setBackground(Color.BLUE);
			   page.drawString(a, 20, 20);

  }else {
	  page.drawString(a, 20, 20);
  }
	 }
  }
  

}
