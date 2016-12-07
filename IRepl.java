/**
 * Interface that declares functions for a program with a loop that displays a menu and responds to user
 * input until the user chooses to exit the loop
 * 
 * @author Elena Tsoi-A-Sue
 *         elenatsoi@gmail.com
 */
public interface IRepl {

	/**
	 * Contains the method calls and controls the loop
	 */
	void repl();
	
	/**
	 * Executes any actions needed to run the program
	 */
	void setup();
	
	/**
	 * Displays an opening message
	 */
	void hello();
	
	/**
	 * Displays the menu and asks for user input
	 */
	void listen();
	
	/**
	 * Responds to user input
	 */
	void respond();
	
	/**
	 * Retrieves user input and sets a boolean value that either continues or exits the loop
	 */
	void endchk();
	
	/**
	 * Executes any actions needed before exiting the program
	 */
	void cleanup();
}