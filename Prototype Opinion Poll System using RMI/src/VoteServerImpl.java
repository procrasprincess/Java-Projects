import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VoteServerImpl extends UnicastRemoteObject implements VoteInterface {

    private int yesVote;
    private int noVote;

    
    protected VoteServerImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public String castVote(char vote) throws RemoteException {
        
        if (vote == 'n') {
            noVote++;
        } else if (vote == 'y') {
            yesVote++;
        }
        return ("Yes = " + yesVote + "; No = " + noVote);
    }

}