import java.rmi.*;
import java.util.Scanner;

public class BankClient {
    public static void main(String args[]) {
        try {
            int port = 18726;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/banking";
            AccountInterface account = (AccountInterface) Naming.lookup(registryURL);
            System.out.println("Lookup has been completed ");
            
            int y = 0;
            do {
                System.out.println("Please type in your choice from the below options");
                System.out.println("Enter 1 to create an account, 2 to get the balance of an account, 3 to withdrawal, 4 to deposit, 5 to transfer, 6 to terminate");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                switch (x) {
                
                case 1:
                    System.out.println("Enter Client Name :");
                    sc.nextLine(); 
                    String createName = sc.nextLine();
                    System.out.println("Enter the amount of initial deposit: ");
                    float createAmt = sc.nextFloat();
                    String accountNumber = account.createAccount(createName, createAmt);
                     System.out.println(accountNumber);
                    break;
                
                case 2:
                    System.out.println("Enter Client Name :");
                    sc.nextLine();
                    String balName = sc.nextLine();
                    System.out.println("Enter the account number:  ");
                    int balAccountNo = sc.nextInt();
                    String bal = account.getBalance(balName, balAccountNo);
                    System.out.println(bal);
                    break;
                
                case 3:
                    System.out.println("Enter Client Name: ");
                    sc.nextLine();
                    String withdrawName = sc.nextLine();
                    System.out.println("Enter the amount to withdrawal: ");
                    float withdrawAmt = sc.nextFloat();
                    System.out.println("Enter the account number: ");
                    int withdrawAccountNo = sc.nextInt();
                    String bal1 = account.withdraw(withdrawName, withdrawAmt, withdrawAccountNo);
                    System.out.println(bal1);
                    break;
                
                case 4:
                    System.out.println("Enter Client Name: ");
                    sc.nextLine();
                    String depositName = sc.nextLine();
                    System.out.println("Enter the amount to deposit: ");
                    float depositAmt = sc.nextFloat();
                    System.out.println("Enter the account number: ");
                    int depositAccountNo = sc.nextInt();
                    String bal2 = account.deposit(depositName, depositAmt, depositAccountNo);
                    System.out.println(bal2);
                    break;
                
                case 5:
                    System.out.println("Enter the client name: ");
                    sc.nextLine();
                    String transfName = sc.nextLine();
                    System.out.println("Enter the amount to transfer: ");
                    float transfAmt = sc.nextFloat();
                    System.out.println("Enter the account number for the transfer from: ");
                    int fromAccount = sc.nextInt();
                    System.out.println("Enter the account number to transfer to: ");
                    int toAccount = sc.nextInt();
                    String msg = account.transfer(transfName, fromAccount, toAccount, transfAmt);
                    System.out.println(msg);
                    break;
                
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice");
                }
            } while (y != 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
