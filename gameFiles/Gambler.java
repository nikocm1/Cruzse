import java.util.ArrayList;

public abstract class Gambler {

    protected int money;
    //will have cards attribute in future
    protected int handVal;
    protected ArrayList<Card> hand;
    protected String name;

    public Gambler() {
	money = 100;
	handVal = 0;
	hand = new ArrayList<Card>();
    }
    

    //bet() in future

    protected int hit(Card d) {
	hand.add(d);

	return calcHandVal();
    }

    protected void deal(Card a, Card b) {
	hand.add(a);
	hand.add(b);
    }

    protected int mValue() {
	return money;
    }

    protected boolean bust() {
	boolean bool =  handVal > 21;
	if (bool) {
	    handVal = 0;
	}

	return bool;
    }

    protected int calcHandVal() {
	int total = 0;

	for (int i = 0; i < hand.size(); i++) {
	    total += hand.get(i).cardVal();
	}

	handVal = total;

	return total;
    }

    protected void beginTurn(Card a, Card b) {
	deal(a, b);
	int val = calcHandVal();

	System.out.println(name + " received a " +
			   a + " and a " + b +
			   " for a hand value of " + val);
	System.out.println();
    }

    protected int handVal() {
	return handVal;
    }

    protected String name() {
	return name;
    }

    protected void reset() {
	while (hand.size() > 0) {
	    hand.remove(0);
	}
	calcHandVal();
    }
    
    abstract String action();
}
