import cs1.Keyboard;
import java.util.ArrayList;


public class Texas{

    private Deck deck;
    private int playerMoney;
    
    public Texas(int a){
	deck = new Deck();
	playerMoney = a;
    }

    public int playGame(){
	int bet;
	TexasPlayer P = new TexasPlayer(playerMoney);
	TexasDealer D = new TexasDealer();

	//Bridge B = new Bridge();
	
	System.out.println("You have " + playerMoney + "$");
	
	String play = "p";
		
	
	while(play.equals("p")){
	    System.out.println("The starting bet is 5$");
	    bet = 5;


	    deck.resetDrawNum();
	    P.reset();
	    D.reset();

	    
	    
	    deck.shuffle();
	    deck.shuffle();
	    deck.shuffle();

	    //create arraylist to store players hand and begin players turn
	    ArrayList<Card> playerHand = new ArrayList<Card>();
	    playerHand = P.beginTurnTexas(deck.draw(),deck.draw());

	    //deal to the dealer
	    D.deal(deck.draw(),deck.draw());

	    //print out players cards
	    System.out.println(returnCard(playerHand.get(0)));
	    System.out.println(returnCard(playerHand.get(1)));

	    
	    //create bridge
	    ArrayList<Card> B = new ArrayList<Card>();
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());


	    
	    
	    //add cards to bridge
	    
	    
	    System.out.println("The bridge currently has the " + B.get(0) + ", the " + B.get(1) + " and the " +  B.get(2));
	    System.out.println(returnCard(B.get(0)));
	    System.out.println(returnCard(B.get(1)));
	    System.out.println(returnCard(B.get(2)));
	    
	    //first turn
	    int storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
		break;	    
	    }
	    if(storage > 0){
		bet += storage;
	    }

	    System.out.println("The " + B.get(3) + " was shown on the bridge");
	    System.out.println("The bridge now has the " + B.get(0) + ", the " + B.get(1) + ", the " + B.get(2) + " and the " +  B.get(3));

	    
	    //second turn
	    storage = 90210;
	    storage = P.playTurn();
	    
	    if (storage == -1){
		System.out.println("You folded and lost your bet");
		break;	    
	    }
	    if(storage > 0){
		bet += storage;
	    }

	    //third turn
	    storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
		break;	    
	    }
	    if(storage > 0){
		bet += storage;
	    }
	    
	    
	    
	    
		
		

	    if(handEval(P, D) == "player"){//hand eval also needs to be added
		System.out.println("You beat the dealer's " +
				   D.handVal() + " with a hand value of " + P.handVal());
		P.add(bet * 2);
	    }
		
	    else {
		System.out.println("The dealer won with a hand value of " + D.handVal());
	    }
	    System.out.println("You now have " + P.mValue() + "$\n" +
			       "Would you like to play another round?\n" +
			       "enter p to play another round \n" +
			       "enter l to leave game or play a different game");
	    
	    play = Keyboard.readString();
	    System.out.println();
	    
	    
	}
	
	
	return P.mValue();
    }


    public String handEval(TexasPlayer P , TexasDealer D){
	return "player";
	
    }
    
    public String returnCard(Card A){
	if(A.suit == 3){
	    return "- - - - - - - - -\n- S   " + A.value + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";
	}
	if(A.suit == 0){
	    return "- - - - - - - - -\n- H   " + A.value + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -"; 
	}
	if(A.suit == 2){
	    return "- - - - - - - - -\n- C   " + A.value + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";	    
	}
	if(A.suit == 1){
	    return "- - - - - - - - -\n- D   " + A.value + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";
	}
	return "ERROR 90210";
    }
    
}
