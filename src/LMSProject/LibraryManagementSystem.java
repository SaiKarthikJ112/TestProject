package LMSProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class LibraryManagementSystem {

	private static final String url="jdbc:mysql://localhost:3306/librarydb";
	private static final String username="root";
	private static final String password="Karthik@123";
	
	
	
	public static void main(String[] args) {
		
		Book b1=new Book();
		
		Scanner sc=new Scanner(System.in);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection con=DriverManager.getConnection(url,username,password);
			while(true) {
				System.out.println();
				System.out.println("===========================================");
				System.out.println(" WELCOME TO LIBRARY MANAGEMENT SYSTEM");
				System.out.println("===========================================");
				System.out.println("Please select an option: ");
				System.out.println("1.Add Book \n"+"2.View Available Books \n"+"3.Borrow Book \n"+"4.Return Book \n"+"5.Remove old books \n"+"0.Exit");
				System.out.print("Enter your choice: ");
				
				int choice=sc.nextInt();
				
				switch(choice) {
				case 1:
					b1.addBook(con,sc);
					break;
				case 2:
					b1.availableBooks(con,sc);
					break;
				case 3:
					b1.borrowBook(con,sc);
					break;
				case 4:
					b1.returnBook(con,sc);
					break;
				case 5:
					b1.removeOldBooks(con,sc);
					break;
				case 0:
					b1.exit();
					break;
					
				default:
					System.out.println("Invalid input. Select a number between (0 and 5).");
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
