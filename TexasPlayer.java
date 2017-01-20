import cs1.Keyboard;
import java.util.ArrayList;


public class TexasPlayer extends Gambler{
    protected int money;

    public TexasPlayer() {
	super();
	System.out.println();
	money = 100;
    }


    public TexasPlayer(String n, int m){
	this();
	money = m;
	name = n;
    }

    protected ArrayList<Card> beginTurnTexas(Card a, Card b) {
	deal(a, b);
	int val = calcHandVal();

	System.out.println(name + " received a " +
			   a + " and a " + b 
			   );
	System.out.println();
	ArrayList<Card> ting = new ArrayList<Card>();
	ting.add(a);
	ting.add(b);
	return ting;
	
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

    public int bet() {
	System.out.println("\nHow much would you like to bet");
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
    
    public int playTurn(){
	int toDo = 10;
	System.out.println("What would you like to do? \n   1. Raise\n   2. Stay\n   3. Fold");
	toDo = Keyboard.readInt();
	if(toDo == 1){
	    System.out.println("How much would you like to bet");
	    int bet = 0;
	    bet = Keyboard.readInt();
	    return bet;
	}
	if(toDo == 2){
	    return 0;
	}
	if(toDo == 3){
	    return -1;
	}
	return 90210;
    }

    protected int mValue() {
	return money;
    }

}
