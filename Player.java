import cs1.Keyboard;

public class Player extends Gambler {

    public Player() {
	super();
	System.out.println();
    }

    public Player(String n, int m) {
	this();
	name = n;
	money = m;
    }

    protected boolean beginTurn(Card a, Card b, int m) {
	String split = "";
	boolean bool = false;
	deal(a, b);
	int val = calcHandVal();
	lowerAce();

	System.out.println(name + " received a " +
			   a + " and a " + b +
			   " for a hand value of " + val);
	System.out.println();

	if (a.equals(b) && m <= money) {
	    System.out.println("Would you like to split?" +
			       "\nenter s to split");
	    split = Keyboard.readString();

	    if (split.equals("s")) {
		bool = true;
	    }
	    System.out.println();
	}
	return bool;
    }    

    public String action() {
	String ret = "";

	System.out.println("Would you like to hit or stay?" +
			       "\nenter h to hit" +
			       "\nenter s to stay");

	ret = Keyboard.readString();
	System.out.println();
	return ret;
    }

    public int bet() {
	System.out.println("\nHow much would you like to bet?");
	int bet = Keyboard.readInt();

	while (bet > money || bet < 1) {
	    System.out.println("Your bet must be greater than 0 " +
			       "and less than your current balance" +
			       "\ncurrent balance: " + money);
	    bet = Keyboard.readInt();
	}
	money -= bet;
	System.out.println();
	return bet;
    }


}

