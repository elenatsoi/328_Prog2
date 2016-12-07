public class Key {

	private String title;
	private String paragraph;
	private int next;
	
	public Key( String t, String p ) {
		
		title = t;
		paragraph = p;
		next = -1;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public void setTitle( String t ) {
		
		title = t;
	}
	
	public String getPara() {
		
		return paragraph;
	}
	
	public void setPara( String p ) {
		
		paragraph = p;
	}

	public int getNext() {
		
		return next;
	}

	public void setNext( int n ) {
		
		next = n;
	}
	
	public String toString() {
		
		return title + "\n" + paragraph + "\n" + next;
	}
}