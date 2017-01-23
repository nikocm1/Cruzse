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
    protected void deal(Card a){
	hand.add(a);
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
	lowerAce();

	System.out.println(name + " received a " + a);
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

    protected String hand() {
	return hand.toString();
    }

    protected int findAce() {
	int ret = -1;
	for (int i = 0; i < hand.size(); i++) {
	    if (hand.get(i).cardVal() == 11) {
		ret = i;
	    }
	}
	return ret;
    }
    
    protected void lowerAce() {
	if (handVal > 21) {
	    int n = findAce();
	    if (n != -1) {
		hand.get(n).reduceAce();
	    }
	    calcHandVal();
	}
    }

    protected void add(int i) {
	money += i;
    }    	
    
    abstract String action();
    
}
