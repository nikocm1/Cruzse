import cs1.Keyboard;

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

	System.out.println("You have " + playerMoney + "$");

	String play = "p";
		
	
	while(play.equals("p")){
		P.reset();
		D.reset();
		deck.resetDrawNum();


		deck.shuffle();
		deck.shuffle();
		deck.shuffle();

		P.beginTurn(deck.draw(),deck.draw());
		D.beginTurn(deck.draw(),deck.draw());

		P.playTurn(); //third card, also playTurn() needs to be implemented
		D.playTurn();


		P.playTurn(); //fourth card
		D.playTurn();


		P.playTurn(); //fifth card
		D.playTurn(); 
		
		
		//bet = P.bet();

		
		

		if(P.handEval() > D.handEval()){//hand eval also needs to be added
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
    
}
