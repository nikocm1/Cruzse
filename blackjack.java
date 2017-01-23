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

	    /*	    if (act.equals("sp")) {
		if (hand.size() == 2 && hand.get(0).equals(hand.get(1))) {
	    */		    
		

	    else {
		break;
	    }

	    //System.out.println(g.bust());
	}
    }

    public int endTurn(Dealer a, Gambler b, int bet) {
	int ret = 0;
	
	if (b.handVal() == 0) {
	    System.out.println(b.name() + " busted and the dealer won");
	}

	else if ( a.handVal() == b.handVal() ) {
	    System.out.println(b.name() + " and the dealer push");
	    b.add(bet);
	    ret = bet;
	}

	else if (a.handVal() == 0) {
	    System.out.println("The dealer busted and " + b.name() + " won");
	    b.add(bet * 2);
	    ret = bet * 2;
	}

	else if ( a.handVal() > b.handVal() ) {
	    System.out.println("The dealer beat " + b.name());
	}

	else if ( a.handVal() < b.handVal() ) {
	    System.out.println(b.name() + " beat the dealer");
	    b.add(bet * 2);
	    ret = bet * 2;
	}

	return ret;
    }


    public int playGame() {
	int bet;
	Player P = new Player(playerName, playerMoney);
	Player temp = new Player(playerName, playerMoney);
	Jack J = new Jack();
	Dealer D = new Dealer();
	boolean split;
	int bonus;

	String play = "p";

	System.out.println("You have " + playerMoney + "$");
       
	while (play.equals("p")) {
	    split = false;
	    P.reset();
	    J.reset();
	    D.reset();
	    temp.reset();
	    deck.resetDrawNum();
      	    deck.shuffle();
	    bet = P.bet();
	    
	    D.beginTurn(deck.draw(), deck.draw());
	    split = P.beginTurn(deck.draw(), deck.draw(), bet);

	    if (split) {
		P.splitCards(temp);
		P.add(bet * -1);
		System.out.println("Hand One\n");
		playTurn(temp);
		System.out.println("Hand Two\n");
	    }
	    
	    playTurn(P);
	    
	    D.revealCard();
	    playTurn(D);

	    if (split) {
		bonus = endTurn(D, temp, bet);
		P.add(bonus);
	    }		

	    endTurn(D, P, bet);

	    System.out.println();
	    
	    if (P.mValue() == 0) {
		System.out.println("You have bankrupted");
		break;
	    }	    	    

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
