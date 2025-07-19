package NumberGuessingGame;
import java.util.Scanner;
public class NumberGuessingGame {
	public static void main(String[] args) {
		int randomNumber=(int)(Math.random()*100)+1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Number Guessing Game..!");
		System.out.println("Start Guessing the number between 1 to 100: ");
		int num;
		while(true) {
			num=sc.nextInt();
			if(num==randomNumber) {
				System.out.println("Got it! You are brilliant.");
				break;
			}
		    else if(num>randomNumber) {
				System.out.println("Sorry! The number is too high.Try again!");
			}else{
				System.out.println("Sorry! The number is too low.Try again!");
			}
		}
		sc.close();
	}

}
