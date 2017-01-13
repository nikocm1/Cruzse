import cs1.Keyboard;

public class Player extends Gambler {

    public Player() {
	super();
	System.out.println("What is your name?");
	name = Keyboard.readString();
	System.out.println();
    }

    public Player(int m) {
	this();
	money = m;
    }

    public String action() {
	String ret = "";
	
	System.out.println("Would you like to hit or stay?" +
			   "\nenter hit to hit" +
			   "\nenter stay to stay\n");
	
	ret = Keyboard.readString();
	System.out.println();
	return ret;
    }

}

