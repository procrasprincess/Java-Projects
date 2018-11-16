import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class MyClient {
    private static String HOST = "localhost";
    private static int PORT = 12345;

    public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
        VoteInterface voteI = (VoteInterface) Naming.lookup("rmi://" + HOST + ":" + PORT + "/vote");
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your vote?[yes|no] : ");
        String vote = scan.nextLine();
        if (vote.equals("yes")) {
            System.out.println(voteI.castVote('y'));
        } else if (vote.equals("no")) {
            System.out.println(voteI.castVote('n'));
        } else {
            System.out.println("Incorrect choice");
            System.out.println(voteI.castVote('w'));
        }

    }
}