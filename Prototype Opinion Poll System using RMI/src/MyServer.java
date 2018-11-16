import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class MyServer {
    
    private static String HOST= "localhost";
    private static int PORT = 12345;
    public static void main(String args[]) throws RemoteException, MalformedURLException {
        VoteServerImpl voteServer = new VoteServerImpl();
        LocateRegistry.createRegistry(PORT);
        Naming.rebind("rmi://" + HOST + ":" + PORT + "/vote", voteServer);
        System.out.println("Start server at: " + HOST + ":" + PORT);
    }
}