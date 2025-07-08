package Grocery.ToDoList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class User {
	public static void main(String[] args) throws InputMismatchException{
		Groceries items=new Groceries();
		Scanner sc=new Scanner(System.in);
		int input=0;
		while(true) {
			System.out.println("---TO-DO LIST---");
			System.out.println("1. Add an Item\r\n"
					+ "2. View List\r\n"
					+ "3. Remove Item\r\n"
					+ "4. Exit");
			System.out.println("Choose an option: ");
			input =sc.nextInt();
			sc.nextLine();
			switch(input){
			case 1: 
				System.out.print("Enter item to add: ");
				String item=sc.nextLine();
				items.addItems(item);
				break;
			case 2:
				items.viewList();
				break;
			case 3:
				System.out.print("Enter item to remove: ");
				String remove=sc.nextLine();
				items.removeItems(remove);
				break;
			case 4:
				items.exit();
				break;
			 default:
                 System.out.println("Invalid input. Try again.");

			}
		}
	}

}
