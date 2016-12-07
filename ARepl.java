/**
 * Defines the repl method from the IRepl interface
 * 
 * @author Elena Tsoi-A-Sue
 *         elenatsoi@gmail.com
 */
public abstract class ARepl implements IRepl {

	/** Controls the while loop **/
	protected boolean done;
	
	/**
	 * Controls the progam running order
	 */
	public void repl() {
		
		//Performs initial tasks
		setup();
		
		//Displays initial information
		hello();
		
		//Repeats until done is true
		while ( !done ) {
			
			//Collects user input
			listen();
			
			//Responds to user input
			respond();
			
			//Controls the value of done data member
			endchk();
		}
		
		//Performs closing tasks
		cleanup();
	}
}