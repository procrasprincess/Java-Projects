import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class BankServer{
  public static void main(String args[]){
    try{     
      int port = 18726; 
      String host = "localhost";
      AccountInterfaceImpl exportedObj = new AccountInterfaceImpl();
      LocateRegistry.createRegistry(port);
      String registryURL = "rmi://" + host + ":" + port + "/banking";
      Naming.rebind(registryURL, exportedObj);
      System.out.println("The Bank Server is ready...");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
