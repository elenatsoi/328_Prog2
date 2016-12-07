import java.util.Scanner;

/**
 * Library of functions that validate int input entered by the user
 * 
 * @author Elena Tsoi-A-Sue
 * elenatsoi@gmail.com
 */
public class Validate {

	/**
	 * Verifies that user enters int input, and returns verified input
	 * @return		valid, an int value
	 */
	public static int checkInt() {
		
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validInt = 0;
		
		//Repeats until valid input is entered
		while ( !valid ) {
			
			//If input entered is an int value
			if ( in.hasNextInt() ) {
			
				//Assign int value to validInt
				validInt = in.nextInt();
				//Set valid to true to exit while loop
				valid = true;
			}
			else {
			
				//Displays error message
				System.out.println("Invalid input");
				
				//Clears in
				in.next();
			}
		}
		
		return validInt;
	}
	
	/**
	 * Verifies that user enters int input within a user specified range, and returns verified input
	 * @param low		int, the minimum valid value
	 * @param high		int, the maximum valid value
	 * @return		valid, and int value within specified range
	 */
	public static int checkInt( int low, int high ) {
		
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validInt = 0;
		
		//Repeats until valid input is entered
		while ( !valid ) {
			
			//If input entered is an int value
			if ( in.hasNextInt() ) {
			
				//Sets int value to validInt
				validInt = in.nextInt();
				
				//Checks to see if int is within range specified by user
				if ( validInt >= low && validInt <= high ) {
					
					//Sets valid to true to exit while loop
					valid = true;
				}
				else {
					
					//Prompts user to enter value within range
					System.out.println("Please enter a number between " + low + " and " + high);
				}
			}
			else {
			
				//Displays error message
				System.out.println("Invalid input");
				
				//Clears in
				in.next();
			}
		}
		
		return validInt;
	}
}
