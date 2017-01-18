import cs1.Keyboard;

public class TexasPlayer extends Gambler{
     public TexasPlayer() {
	super();
	System.out.println("What is your name?");
	name = Keyboard.readString();
	System.out.println();
    }


    public TexasPlayer(int m){
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
			   "\nenter h to hit" +
			   "\nenter s to stay");
	
	ret = Keyboard.readString();
	System.out.println();
	return ret;
    }

    public void add(int i) {
	money += i;
    }
    
}
