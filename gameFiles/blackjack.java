import cs1.Keyboard;

public class blackjack {

    //potVal
    private Deck deck;
    private int playerMoney;

    public blackjack(int a) {
	deck = new Deck();
	playerMoney = a;
    }
    /*
    public int playerMoney() {
	return playerMoney;
    }
    */
    

    public void playTurn(Gambler g) {
	String act;
	Card c;

	while (!g.bust()) {
	    act = g.action();
	    
	    if (act.equals("hit")) {
		c = deck.draw();
		System.out.println(g.name() + " was dealt a " +
				   c);
		g.hit(c);
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
	
	

    public int playGame() {
	Player P = new Player(playerMoney);
	Dealer D = new Dealer();

	String play = "play";
       
	while (play.equals("play")) {
	    P.reset();
	    D.reset();
	    deck.resetDrawNum();
	    deck.shuffle();
	    P.beginTurn(deck.draw(), deck.draw());
	    D.beginTurn(deck.draw(), deck.draw());

	    playTurn(P);
	    playTurn(D);

	    if (P.handVal() > D.handVal()) {
		System.out.println("You won");
	    }

	    else {
		System.out.println("The dealer won");
	    }

	    System.out.println("Would you like to play another round \n" +
			   "enter play to play another round \n" +
			   "enter leave to leave game");

	    play = Keyboard.readString();
	}
	
	return P.mValue();
    }
	
    
}
