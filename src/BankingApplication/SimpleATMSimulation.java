package BankingApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SimpleATMSimulation {

	public void createAccount(Connection conn, Scanner scan) {
		System.out.print("Enter account number: ");
		int accno=scan.nextInt();
		scan.nextLine(); //Clear buffer
		System.out.print("Enter Name: ");
		String name=scan.nextLine();
		System.out.print("Enter Initial Balance: ");
		int initialBal=scan.nextInt();
		scan.nextLine();
		System.out.println("Set a 4-digit PIN: ");
		int pin=scan.nextInt();
		while(pin<1000 || pin > 9999) {
			System.out.println("Please, enter a 4-Digit PIN between (1000 and 9999).");
			pin=scan.nextInt();
		}
		
		String sql="INSERT INTO bank(account_no,customer_name,account_balance,account_pin)Values(?,?,?,?)";
		try(PreparedStatement pstmt=conn.prepareStatement(sql)){
			
			pstmt.setInt(1, accno);
			pstmt.setString(2,name);
			pstmt.setInt(3,initialBal);
			pstmt.setInt(4,pin);
			
			int rowUpdated=pstmt.executeUpdate();
			if(rowUpdated>0) {
				System.out.println("Account created successfully!");
			}else {
				System.out.println("Sorry, you are unable to create an account at this moment. Try again later!");
			}
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		
	}

	public void deposit(Connection conn, Scanner scan) {
		scan.nextLine();
		
		System.out.print("Enter Account number: ");
		int accno=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter PIN number: ");
		int pin=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Amount to Deposit: ");
		int addMoney=scan.nextInt();
		scan.nextLine();
		String amountDeposited="UPDATE bank set account_balance = account_balance + ? where account_no=? AND account_pin=?";
		
		try(PreparedStatement pstmt=conn.prepareStatement(amountDeposited)){
			
			pstmt.setInt(1, addMoney);
			pstmt.setInt(2, accno);
			pstmt.setInt(3, pin);
			
			int updatedRows=pstmt.executeUpdate();
			
			if(updatedRows>0) {
				System.out.println("Deposit successful!");
			}			
		} catch (SQLException e) {
			System.err.println("Unable to deposit."+e.getMessage());
		}		
	}

	public void withdraw(Connection conn, Scanner scan) {
        scan.nextLine();
		
		System.out.print("Enter Account number: ");
		int accno=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter PIN number: ");
		int pin=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Amount to Withdraw: ");
		int withdrawMoney=scan.nextInt();
		scan.nextLine();
		
		String checkBalanceSql = "SELECT account_balance FROM bank WHERE account_no = ? AND account_pin = ?";
		String amountWithdrawn="UPDATE bank set account_balance = account_balance - ? where account_no = ? AND account_pin = ?";
        try(PreparedStatement pstmtCheck=conn.prepareStatement(checkBalanceSql)){
			
        	pstmtCheck.setInt(1, accno);
            pstmtCheck.setInt(2, pin);
            ResultSet rs = pstmtCheck.executeQuery();
            
            if (rs.next()) {
                int currentBalance = rs.getInt("account_balance");
                if (currentBalance >= withdrawMoney) {
                	 try (PreparedStatement pstmtWithdraw = conn.prepareStatement(amountWithdrawn)) {
                		 pstmtWithdraw.setInt(1, withdrawMoney);
                         pstmtWithdraw.setInt(2, accno);
                         pstmtWithdraw.setInt(3, pin);
                         int updatedRows = pstmtWithdraw.executeUpdate();
                         if (updatedRows > 0) {
                             System.out.println("Withdrawal successful!");
                         }
                	 }
                }else {
                    System.out.println("Insufficient balance to withdraw " + withdrawMoney);
                }   
            } else {
                System.err.println("Account not found or incorrect PIN.");
            }
        }catch (SQLException e) {
			System.err.println("Unable to withdrawn. "+e.getMessage());
		}
	}
	public void checkBalance(Connection conn, Scanner scan) {
        scan.nextLine();
		
		System.out.print("Enter Account number: ");
		int accno=scan.nextInt();
		scan.nextLine();
		System.out.print("Enter PIN number: ");
		int pin=scan.nextInt();
		scan.nextLine();
		
		String checkBal="Select account_balance from bank where account_no = ? AND account_pin = ?";
		
		try(PreparedStatement pstmt=conn.prepareStatement(checkBal)){
			
			pstmt.setInt(1, accno);
			pstmt.setInt(2, pin);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int balance=rs.getInt("account_balance");
				System.out.println("Current Balance: "+balance);
			}else {
				System.err.println("No customer found with the provided Account Number and PIN.");
			}
			
		} catch (SQLException e) {
			System.err.println("Unable to check balance."+e.getMessage());
		}
		
	}

	public void deleteAccount(Connection conn, Scanner scan) {
		// TODO Auto-generated method stub
		 scan.nextLine();
			
			System.out.print("Enter Account number: ");
			int accno=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter PIN number: ");
			int pin=scan.nextInt();
			scan.nextLine();
			
			String delAcc="DELETE from bank where account_no = ? AND account_pin = ?";
			try(PreparedStatement pstmt=conn.prepareStatement(delAcc)){
				pstmt.setInt(1, accno);
				pstmt.setInt(2, pin);
				
				int rowsUpdated=pstmt.executeUpdate();
				if(rowsUpdated>0) {
					System.out.println("Account deleted successfully!");
				}
				
			}catch(SQLException e) {
				System.err.println("Unable to delete your account. "+e.getMessage());
			}
		
	}

	public void exit() {
		System.out.println("Thank you for using Simple ATM. Goodbye!");
		System.exit(0);
	}

}
