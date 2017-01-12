import java.util.ArrayList;

public class Gambler {

    protected int money;
    //will have cards attribute in future
    protected int handVal;
    protected ArrayList<Card> hand;

    public Gambler() {
	money = 100;
	handVal = 0;
	hand = new ArrayList<Card>();
    }
    

    //bet() in future

    protected void hit(Card d) {
	hand.add(d);
    }

    protected void deal(Card a, Card b) {
	hand.add(a);
	hand.add(b);
    }

}
