import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VoteInterface extends Remote {
    public String castVote(char vote) throws RemoteException;

}