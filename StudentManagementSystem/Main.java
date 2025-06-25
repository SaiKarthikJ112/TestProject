package StudentManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		StudentManagementSys sms=new StudentManagementSys();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		while(choice<=5) {
		System.out.println("===================================");
		System.out.println("Welcome to Student Management App");
		System.out.println("===================================");
		System.out.println("1. Add a New Student\r\n"
				+ "2. Remove a Student\r\n"
				+ "3. Search for a Student\r\n"
				+ "4. Display All Students\r\n"
				+ "5. Exit");
		System.out.println("===================================");
		System.out.println("Please enter your choice (1-5): ");
		try {
		choice=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input! Choose from 1-5. "+e);
			break;
		}
		int enterRollNo;
		switch(choice) {
		case 1: 
			System.out.println("Enter Student's Name: ");
			System.out.print("> User Input: ");
			String sname=sc.next();
			System.out.println("Enter Student's RollNo: ");
			System.out.print("> User Input: ");
			int rollNo=sc.nextInt();
			System.out.println("Enter Student's Grade: ");
			System.out.print("> User Input: ");
			char grade=sc.next().charAt(0);
			if (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'F') {
			    System.out.println("[ERROR] Invalid grade! Please enter a valid grade (A, B, C, D, F).");
			}
			sms.addStudent(sname,rollNo,grade);
			System.out.println("[SUCCESS] Student added successfully! ");
			break;
		case 2:
		    System.out.println("Enter the roll number of the student to remove: ");
		    System.out.print("> User Input: ");
		    enterRollNo = sc.nextInt();
		    sms.removeStudent(enterRollNo);
		    break;

		case 3:
		    System.out.println("Enter the roll number to search for: ");
		    System.out.print("> User Input: ");
		    enterRollNo = sc.nextInt();
		    sms.searchStudent(enterRollNo);
		    break;

		case 4:
			sms.studDetails();
			System.out.println("-----------------------------------\n");
			break;
		case 5:
			System.out.println("Thank you for using the Student Management App. Goodbye!");
			break;
		}
	}
		sc.close();
	}
}
	
