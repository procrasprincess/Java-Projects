import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountInterface  extends Remote {
public String createAccount(String name, float balance) throws RemoteException;  
public String getBalance(String name, int accountNo) throws RemoteException;
public String withdraw(String name, float amt,  int accountNo)throws RemoteException;
public String deposit(String name, float amt, int accountNo) throws RemoteException;
public String transfer(String name, int fromAccount,  int toAccount, float amt) throws RemoteException;
}
