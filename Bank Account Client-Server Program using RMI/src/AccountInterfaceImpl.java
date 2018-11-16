	import java.rmi.RemoteException;
	import java.rmi.server.*;
	import java.util.*;
	public class AccountInterfaceImpl extends UnicastRemoteObject implements
	        AccountInterface {
	    private static final long serialVersionUID = 1L;
	    private Vector<Account> aList;
	    private int accountNo = 100;
	    public AccountInterfaceImpl() throws RemoteException {
	        super();
	        aList = new Vector<Account>();
	    }
	    
	    public  String createAccount(String name, float balance) throws RemoteException {
	        accountNo++;
	        Account acc = new Account(name,accountNo, balance);
	        aList.add(acc);
	        return name+" your account number is:  "+accountNo;
	    }
	    
	    public   String withdraw(String name, float amt, int accountNo) throws RemoteException {
	        String message="";
	        if(aList.size() > 0){
	            if(accountPresent(name, accountNo)){
	                for (int i = 0; i < aList.size(); i++){
	                      Account account =
	                        (Account)aList.elementAt(i);
	                      if(account.accountNo == accountNo && account.name.equals(name)){
	                          float currentBalance = account.balance;
	                          if(amt > currentBalance){
	                            message = " You do not have enough funds to withdrawal";
	                          }else{
	                              currentBalance = currentBalance - amt;
	                              account.balance = currentBalance;
	                              message = " Your Balance after the withdrawl is : "+ account.balance;
	                          }
	                          break;
	                      }
	                    }
	            }else{
	                message = " No account exists with the details";
	            }
	            
	        }else{
	            message = "No accounts exists, Please create an account";
	        }
	        
	        return name+ message;
	    }
	    
	    public String getBalance(String name, int accountNo) throws RemoteException {
	        String message = "";
	        float currentBalance = 0;
	            if(aList.size() > 0){
	            if(accountPresent(name, accountNo)){
	                for (int i = 0; i < aList.size(); i++){
	                      Account account =
	                        (Account)aList.elementAt(i);
	                      if(account.accountNo == accountNo && account.name.equals(name)){
	                          currentBalance = account.balance;
	                          message = " Your balance is:  "+currentBalance;
	                          break;
	                      }
	                    }
	            }else{
	                message = " No account exists with the details";
	            }
	        }else{
	            message = " No accounts exists, Please create an account";
	        }
	        return name+ message;
	    }
	        
	    public  String deposit(String name, float amt, int accountNo) throws RemoteException {
	        String message = "";
	        
	        if(aList.size() > 0){
	            if(accountPresent(name, accountNo)){
	                for (int i = 0; i < aList.size(); i++){
	                      Account account =
	                        (Account)aList.elementAt(i);
	                      if(account.accountNo == accountNo && account.name.equals(name)){
	                          float currentBalance = account.balance;
	                              currentBalance = currentBalance + amt;
	                              account.balance = currentBalance;
	                              message = "New Balance is: "+ account.balance;
	                          	                          break;
	                      }
	                    }
	            }else{
	                message = "No account exists with the details";
	            }
	        }else{
	            message = "No accounts exists, Please create an account";
	        }
	            return name+message;
	    }
	    
	    public  String transfer(String name, int fromAccount, int toAccount, float amt) throws RemoteException {
	        String message = "";
	        if(aList.size() == 0){
	            message = "No accounts exists, Please create an account";
	        }else{
	            if(accountPresent(name,fromAccount ) && accountPresent(name,toAccount )){
	                Account fromAcc = accountDetails(name, fromAccount);
	                Account toAcc = accountDetails(name, toAccount);
	                if(amt > fromAcc.balance){
	                      message = " You don not have enough funds in to account for transfer";
	                  }else{
	                      fromAcc.balance = fromAcc.balance - amt;
	                      toAcc.balance = toAcc.balance + amt;
	                      message = " Account "+ toAccount+ "credited with amount of "+ amt+ ". Balance is : "+ toAcc.balance;
	                  }
	            }else{
	                message = " Accounts with same name not present.";
	            }
	        }
	         return name+ message;
	    }
	      private boolean accountPresent(String name, int accountNumber){
	        boolean accPresent = false;
	        for (int i = 0; i < aList.size(); i++){
	            Account accountDtls = (Account)aList.elementAt(i);
	            if(accountDtls.accountNo == accountNumber && accountDtls.name.equals(name)){
	                accPresent = true;
	                break;
	            }
	        }
	        return accPresent;
	    }
	    
	    private Account accountDetails(String name, int accountNumber){
	        Account account = null;
	        for (int i = 0; i < aList.size(); i++){
	            Account accountDtls = (Account)aList.elementAt(i);
	            if(accountDtls.accountNo == accountNumber && accountDtls.name.equals(name)){
	                account = accountDtls;
	                break;
	            }
	        }
	        return account;
	        
	    }
	}
