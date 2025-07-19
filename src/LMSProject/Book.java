package LMSProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Book {

	public  void addBook(Connection con,Scanner scan) {
		
		System.out.println("Enter Book ID: ");
		int bookID=scan.nextInt();
		scan.nextLine(); //clear buffer
		System.out.print("Enter Book Tile: ");
		String bookTitle=scan.nextLine();
		System.out.print("Enter Author Name: ");
		String authorName=scan.nextLine();
		System.out.print("Enter Genre Name: ");
		String genre=scan.nextLine();
		
		String add="INSERT INTO librarysystem(bookid,bookname,authorname,genre)VALUES(?,?,?,?)";
		
		try(PreparedStatement pstmt=con.prepareStatement(add)){
			
			pstmt.setInt(1, bookID);
			pstmt.setString(2, bookTitle);
			pstmt.setString(3, authorName);
			pstmt.setString(4, genre);
			
			int updatedRows=pstmt.executeUpdate();
			if(updatedRows>0) {
				System.out.println("Book Added Successfully!");
			}else {
				System.err.println("Unable to add the book.");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void availableBooks(Connection con,Scanner scan) {
		
		String viewBook="Select bookid,bookname from librarysystem";
		
		try {
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(viewBook);
			
			System.out.println("+----------------+----------------------+");
			System.out.println("| Book ID        | Title                |");
			System.out.println("+----------------+----------------------+");
			
			while(rs.next()) {
				int bookID=rs.getInt("bookid");
				String bookName=rs.getString("bookname");
				
				System.out.printf("| %-14d | %-20s |\n", bookID, bookName);
				
			}
			
			System.out.println("+----------------+----------------------+");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void borrowBook(Connection con,Scanner scan) {
		
		scan.nextLine();
		System.out.println("Enter book name to borrow: ");
		String bookTitle=scan.nextLine();
		System.out.println("Enter book ID: ");
		int bookID=scan.nextInt();
		
		String borrow="DELETE FROM librarysystem where bookname = ? AND bookid = ?";
		
		try(PreparedStatement pstmt=con.prepareStatement(borrow)){
			
			pstmt.setString(1, bookTitle);
			pstmt.setInt(2, bookID);
			int updatedRows=pstmt.executeUpdate();
			if(updatedRows>0) {
				System.out.println("Book borrowed successfully!");
			}else {
				System.err.println("You have entered a wrong book title/ID.");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}


	public void returnBook(Connection con, Scanner scan) {
		    scan.nextLine(); // clear buffer
		    System.out.println("Returning a book...");

		    System.out.print("Enter Book ID: ");
		    int bookID = scan.nextInt();
		    scan.nextLine();

		    System.out.print("Enter Book Title: ");
		    String bookTitle = scan.nextLine();

		    System.out.print("Enter Author Name: ");
		    String authorName = scan.nextLine();

		    System.out.print("Enter Genre: ");
		    String genre = scan.nextLine();

		    String sql = "INSERT INTO librarysystem (bookid, bookname, authorname, genre) VALUES (?, ?, ?, ?)";

		    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
		        pstmt.setInt(1, bookID);
		        pstmt.setString(2, bookTitle);
		        pstmt.setString(3, authorName);
		        pstmt.setString(4, genre);

		        int rows = pstmt.executeUpdate();
		        if (rows > 0) {
		            System.out.println("Book returned successfully!");
		        } else {
		            System.err.println("Failed to return book.");
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
	}


	public void removeOldBooks(Connection con,Scanner scan) {
		String truncate="truncate table librarysystem";
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate(truncate);
				System.out.println("Removed old books successfully!");
			
		} catch (SQLException e) {
		    System.out.println("Failed to remove old books: "+e.getMessage());
		}
		
	}


	public void exit() {
		
		System.out.println("Exiting the LMS...\n"+"Bye....");
		System.exit(0);
	}
	}	

