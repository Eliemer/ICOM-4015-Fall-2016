
public class Book implements GameThing, Readable, Openable{
	public boolean isOpen = false; //Starts closed
	
	public String getName(){
		return "A dusty old book";
	}
	
	public String getDescription(){
		if (isOpen){
			System.out.println("The book is currently open.");
		}
		else{
			System.out.println("The book is currently closed.");
		}
		return "This book appears to be old and dusty. It's also quite heavy.";
		
	}
	
	
	public void read(){
		if(isOpen){
			System.out.println("It seems to be written in some kind of elvish, you can't read it");
		} else {
			System.out.println("You can't read a closed book.");
		}
	}
	
	public void open(){
		if (!isOpen){
			System.out.println("A powerful smell of old pages fills you nostrils as you open the old book");
			isOpen = true;
		} else {
			System.out.println("The book is already open!");
		}
	}
	
	public void close(){
		if (isOpen){
			System.out.println("The book closes with a large thud sound");
			isOpen = false;
		}
		else {
			System.out.println("The book is already closed!");
		}
	}
}
