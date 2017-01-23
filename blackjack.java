import cs1.Keyboard;

public class blackjack {

    //potVal
    private Deck deck;
    private int playerMoney;
    private String playerName;

    
    public blackjack(String b, int a) {
	deck = new Deck();
	playerMoney = a;
	playerName = b;
    }
    

    public void playTurn(Gambler g) {
	String act;
	Card c;

	while (!g.bust()) {
	    act = g.action();
	    
	    if (act.equals("h")) {
		c = deck.draw();
		System.out.println(g.name() + " was dealt a " +
				   c);

		g.hit(c);
		g.lowerAce();
		
		System.out.println(g.name() + " now has a hand value of " +
				   g.handVal());
		System.out.println();
	    }

	    else {
		break;
	    }

	    //System.out.println(g.bust());
	}
    }

    public String endTurn(Dealer a, Gambler b, int bet) {
	String ret = "";
	
	if (b.handVal() == 0) {
	    ret = b.name() + " busted and the dealer won";
	}

	else if ( a.handVal() == b.handVal() ) {
	    ret = b.name() + " and the dealer push";
	    b.add(bet);
	}

	else if (a.handVal() == 0) {
	    ret = "The dealer busted and " + b.name() + " won";
	    b.add(bet * 2);
	}

	else if ( a.handVal() > b.handVal() ) {
	    ret = "The dealer beat " + b.name();
	}

	else if ( a.handVal() < b.handVal() ) {
	    ret = b.name() + " beat the dealer";
	    b.add(bet * 2);
	}

	return ret;
    }


    public int playGame() {
	int bet;
	Player P = new Player(playerName, playerMoney);
	Jack J = new Jack();
	Dealer D = new Dealer();

	String play = "p";

	System.out.println("You have " + playerMoney + "$");
       
	while (play.equals("p")) {
	    P.reset();
	    J.reset();
	    D.reset();
	    deck.resetDrawNum();
 	    deck.shuffle();
	    bet = P.bet();
	    
	    P.beginTurn(deck.draw(), deck.draw());
	    D.beginTurn(deck.draw(), deck.draw());

	    playTurn(P);
	    playTurn(D);

	    /*	    if (P.handVal() > D.handVal()) {
		System.out.println("You beat the dealer's " +
				   D.handVal() + " with a hand value of " + P.handVal());
		P.add(bet * 2);
	    }

	    else {
		System.out.println("The dealer won with a hand value of " + D.handVal());
	    }
	    */
	    System.out.println(endTurn(D, P, bet));

	    System.out.println("Dealer's hand: " + D.hand() +
			       "\nYour hand: " + P.hand());
	    
	    System.out.println();

	    System.out.println("You now have " + P.mValue() + "$\n\n" +
			       "Would you like to play another round?\n" +
			   "enter p to play another round \n" +
			   "enter l to leave game or play a different game");

	    play = Keyboard.readString();
	    System.out.println();
	}
	
	return P.mValue();
    }
	
    
}
