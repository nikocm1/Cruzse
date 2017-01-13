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

    protected void beginTurn(Card a, Card b) {
	deal(a, b);
	int val = calcHandVal();

	System.out.println(name + " received a " +
			   a + " and a " + b +
			   " for a hand value of " + val);
	System.out.println();
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

