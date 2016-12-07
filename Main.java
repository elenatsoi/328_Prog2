import java.io.*;
import java.util.Scanner;

public class Main extends ARepl {

	protected Key[] articles;
	protected int userSelect;
	protected Scanner in;
	final int R = 37;

	public static void main(String[] args) {

		Main prog2 = new Main();

		prog2.repl();
	}

	@Override
	public void setup() {

		// Pull Key info from text file, and store in array
		retrieve();

		articles = new Key[300];
		
		in = new Scanner(System.in);
	}

	@Override
	public void hello() {

		System.out.println("Mini Wiki");
	}

	@Override
	public void listen() {

		menu();

		userSelect = Validate.checkInt(1, 5);
	}

	@Override
	public void respond() {

		switch (userSelect) {

		// Add
		case 1: add();
			break;

		// Delete
		case 2: delete();
			break;

		// Search
		case 3: search();
			break;
			
		//Exit
		case 4: done = true;
			break;
			
		case 5: print();
			break;
		}

	}

	@Override
	public void endchk() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cleanup() {

		writeToFile();
	}

	public void retrieve() {

		try {

			Scanner read = new Scanner( new File("articles.txt") );
			
			
		} 
		catch (FileNotFoundException fnf) {

		}
	}

	public void menu() {

		System.out.println("1) Add article\n" + "2) Delete article\n" + "3) Search for article\n" + "4) Print");
	}

	public void add() {

		System.out.print("Enter title: ");
		
		String title = in.nextLine();
		
		System.out.print("Enter info: ");
		
		String para = in.nextLine();
		
		add(title, para, hash(title));
 	}
	
	public void add( String title, String para, int hash ) {
		
		Key temp = articles[hash];
		int next = -1;
		
		if ( temp == null ) {
			
			articles[hash] = new Key(title, para);
		}
		else {
			
			
			while ( temp.getNext() != -1 ) {
				
				next = temp.getNext();
				temp = articles[next];
			}
						
			do {
				
				if ( next == -1 ) {
					
					next = hash;
				}
				
				next += 1;
			}
			while ( articles[next] != null );
			
			articles[next] = new Key(title, para);
			
			temp.setNext(next);
		}
	}

	public void delete() {

		System.out.print("Enter title: ");
		
		String title = in.nextLine();
		
		delete(title, hash(title));
	}
	
	public Key delete( String title, int hash ) {
		
		Key temp = articles[hash];
		Key prev = temp;
		
		if ( temp != null ) {
			
			boolean found = false;
				
			while ( !found ) {
					
				if ( temp.getTitle().equals(title) ) {
						
					prev.setNext(temp.getNext());
					
					return temp;
				}
				else if ( temp.getNext() == -1 ) {
					
					return null;
				}
					
				prev = temp;
				temp = articles[temp.getNext()];
			}
		}
		
		return null;
	}

	public void search() {

		System.out.print("Enter title: ");
		
		String title = in.nextLine();
		
		Key temp = search(title, hash(title));
		
		if ( temp != null ) {
			
			System.out.println(temp.getTitle());
			System.out.println(temp.getPara());
		}
		else {
			
			System.out.println("Article not found");
		}
	}
	
	public Key search( String title, int hash ) {
		
		Key temp = articles[hash];
		
		if ( temp != null ) {
			
			boolean found = false;
				
			while ( !found ) {
					
				if ( temp.getTitle().equals(title) ) {
						
					return temp;
				}
				else if ( temp.getNext() == -1 ) {
					
					return null;
				}
					
				temp = articles[temp.getNext()];
			}
		}
		
		return null;
	}

	public int hash( String title ) {
		
		//return mHash(title);
		return dHash(title);
	}
	
	public int mHash( String key ) {
		
		double hashKey = 0;
		int sum = 0;
		double keyP = 0;
		
		for ( int i = 0; i < 25; i++ ) {
			
			if ( i < key.length() ) {
				
				sum += ( (int)key.charAt(i) * Math.pow(R, i) );
				
			}
			//Add padding
			else {
				
				sum += ( 32 * Math.pow(R, i)  );
			}
		}
		
		keyP = (sum * Math.PI);
		hashKey = articles.length * (keyP - Math.floor(keyP));
		
		return (int)hashKey;
	}

	public int dHash(String key) {

		int sum = 0;
		int hashKey;

		for (int i = 0; i < 25; i++) {

			if (i < key.length()) {

				sum += ((int) key.charAt(i) * Math.pow(R, i));

			}
			// Add padding
			else {

				sum += (32 * Math.pow(R, i));
			}
		}
		hashKey = sum % articles.length;

		return hashKey;
	}
	
	public void print() {
		
		for ( int i = 0; i < articles.length; i++ ) {
			
			if ( articles[i] != null ) {
				
				System.out.println(articles[i]);
			}
		}
	}
}