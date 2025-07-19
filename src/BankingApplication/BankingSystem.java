package BankingApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingSystem {	
	
	private static final String url="jdbc:mysql://localhost:3306/banksystemdb";
	private static final String username="root";
	private static final String password="Karthik@123";
	
	public static void main(String[] args) {
		SimpleATMSimulation sas=new SimpleATMSimulation();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			Scanner sc=new Scanner(System.in);
			
			while(true) {
			       System.out.println("====Welcome to Simple ATM System====");
			       System.out.println("1. Create Account \n"+"2. Deposit \n"+"3. Withdraw \n"+"4. Check Balance \n"+"5. Delete Account \n"+"6. Exit");
			       System.out.print("Enter your choice: ");
			      int input= sc.nextInt();
			       
			       switch(input) {
			       case 1:
			    	   sas.createAccount(conn,sc);
			    	   break;
			       case 2:
			    	   sas.deposit(conn,sc);
			    	   break;
			       case 3:
			    	   sas.withdraw(conn,sc);
			    	   break;
			       case 4:
			    	   sas.checkBalance(conn,sc);
			    	   break;
			       case 5:
			    	   sas.deleteAccount(conn,sc);
			    	   break;
			       case 6:
			    	   sas.exit();
			    	   break;
			       default:
			    		System.out.println("Enter a number b/w (1-6).");   
			       }
			
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
