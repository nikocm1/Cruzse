import cs1.Keyboard;
import java.util.ArrayList;


public class TexasDealer extends Gambler{
    public TexasDealer() {
	super();
	name = "The computer";
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

    protected ArrayList<Card> beginTurnTexas(Card a, Card b) {
	deal(a, b);
	int val = calcHandVal();


	ArrayList<Card> ting = new ArrayList<Card>();
	ting.add(a);
	ting.add(b);
	return ting;
	
    }    
    

    public int playTurn(ArrayList<Card> hand, ArrayList<Card> bridge, int numBridge){
	ArrayList<Card> analyze = new ArrayList<Card>();
	analyze.add(hand.get(0));
	analyze.add(hand.get(1));
	for(int x = 0 ; x < numBridge ; x ++){
	    analyze.add(bridge.get(x));
	}
	int whatToDo = 90210; //will return 2 when betting, 0 when calling, and -1 when folding
	int sameSuit = 1; //how many cards of the same suit
	boolean twoPair = false;
	boolean handSucks = false;;
	boolean goodHand = false;

	System.out.println(analyze.get(0));	
	System.out.println(analyze.get(1));
	


	//sameSuit checking
	for(int x = 0 ; x < analyze.size() ; x++){
	    for(int i = x + 1 ; i < analyze.size() ; i++){
		int counter = 1;
		if(analyze.get(x).suit == analyze.get(i).suit){
		    counter++;
		}
		if(counter > sameSuit){
		    sameSuit = counter;
		}
	    }
	}
	
	//sameValue checking
	for(int x = 0 ; x < 2 ; x++){
	    for(int i = 2 ; i < numBridge ; i++){
		if(analyze.get(x).value == analyze.get(i).value){
		    twoPair = true;
		    break;
		}
	    }
	}
	
	if((hand.get(0).value < 9) && (hand.get(1).value < 9)){
	    handSucks = true;
	}

	if(hand.get(0).value > 9 && hand.get(1).value > 9){
	    goodHand = true;
	}

	
	//dealer is going to have a very simple AI, only hit if it has a double, high cards or potential for a flush
	
	if(sameSuit == 5 || twoPair || (goodHand && numBridge == 0) || (sameSuit == 4 && numBridge == 4)){ 
	    return 3;
	}
	if(handSucks){
	    return -1;
	}
	
	return 0; //if hand is average
    }

    
}
