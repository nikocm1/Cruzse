import cs1.Keyboard;
import java.util.ArrayList;


public class Texas extends handEval{

    private Deck deck;
    private int playerMoney;
    private String playerName;
    
    public Texas(String b, int a){
	deck = new Deck();
	playerMoney = a;
	playerName = b;
    }

    public int playGame(){
	int bet;
	TexasPlayer P = new TexasPlayer(playerName, playerMoney);
	TexasDealer D = new TexasDealer();

	//Bridge B = new Bridge();
	
	System.out.println("You have " + playerMoney + "$");
	
	String play = "p";
		
	
	while(play.equals("p")){
	    //each time you play, buy in is 5$
	    System.out.println("The starting bet is 5$");
	    bet = 10;

	    //reset the deck and each player
	    deck.resetDrawNum();
	    P.reset();
	    D.reset();

	    
	    //shuffle 3 times, as is customary in poker
	    deck.shuffle();
	    deck.shuffle();
	    deck.shuffle();

	    //create arraylist to store players hand and begin players turn
	    ArrayList<Card> playerHand = new ArrayList<Card>();
	    playerHand = P.beginTurnTexas(deck.draw(),deck.draw());

	    //create arraylist to store dealers hand and begin players turn
	    ArrayList<Card> dealerHand = new ArrayList<Card>();
	    dealerHand = D.beginTurnTexas(deck.draw(),deck.draw());

	    //create bridge
	    ArrayList<Card> B = new ArrayList<Card>();
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());
	    B.add(deck.draw());


	    

	    int carryOverBet = 0;
	    
	
	    /*
	      FIRST TURN FOR PLAYER
	     */
	    int storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
			    P.remove(bet);

		break;	    
	    }
	    if(storage > 0){
		bet += storage;
		System.out.println("You raised by $" + storage);
		carryOverBet = storage;
	    }//end player turn

	    /*
	      FIRST TURN FOR COMPUTER
	     */

	    storage = 90210;
	    storage = D.playTurn(dealerHand, B, 0);

	    if (storage == -1){
		System.out.println("The computer folded and you won");
		P.add(bet * 2);
		break;	    
	    }
	    if (storage == 0){
		System.out.println("The computer called");
		bet += carryOverBet;	
	    }
	    if(storage > 0){
		bet += carryOverBet;	
		int raise = storage;
		System.out.println("The computer raised by " + raise + ". Would you like to match his bet?\n   1. Call\n   2. Fold");
		int check = 90210;
		check = Keyboard.readInt();
		if(check == 1){
		     bet += raise * 2;
		}
		else{
		    System.out.println("You folded and lost your bet");
		    	    P.remove(bet);

		    break;
		    }
	    }
	    System.out.println("The pot is now " + bet);
	    carryOverBet = 0;
	    //end computer turn

	   
	    
	    //show first three cards on bridge	    
	    System.out.println("The bridge currently has the " + B.get(0) + ", the " + B.get(1) + " and the " +  B.get(2));
	   


	    /*
	      SECOND TURN FOR PLAYER
	     */
	    storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
			    P.remove(bet);

		break;	    
	    }
	    if(storage > 0){
		bet += storage;
		System.out.println("You raised by $" + storage);
		carryOverBet = storage;
	    }//end player turn

	    /*
	      SECOND TURN FOR COMPUTER
	     */

	    storage = 90210;
	    storage = D.playTurn(dealerHand, B, 3);

	    if (storage == -1){
		System.out.println("The computer folded and you won");
		P.add(bet * 2);
		break;	    
	    }
	    if (storage == 0){
		System.out.println("The computer called");
		bet += carryOverBet;	
	    }
	    if(storage > 0){
		bet += carryOverBet;	
		int raise = storage;
		System.out.println("The computer raised by " + raise + ". Would you like to match his bet?\n   1. Call\n   2. Fold");
		int check = 90210;
		check = Keyboard.readInt();
		if(check == 1){
		     bet += raise * 2;
		}
		else{
		    System.out.println("You folded and lost your bet");
		    	    P.remove(bet);

		    break;
		    }
	    }
	    System.out.println("The pot is now " + bet);
	    carryOverBet = 0;
	    //end computer turn


	    
	        
	    /*
	      PRINT OUT BRIDGE AND REVEAL A CARD
	     */
	    System.out.println("The " + B.get(3) + " was shown on the bridge");
	    System.out.println("The bridge now has the " + B.get(0) + ", the " + B.get(1) + ", the " + B.get(2) + " and the " +  B.get(3));
	    


	    
	 /*
	      THIRD TURN FOR PLAYER
	     */
	    storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
			    P.remove(bet);

		break;	    
	    }
	    if(storage > 0){
		bet += storage;
		System.out.println("You raised by $" + storage);
		carryOverBet = storage;
	    }//end player turn

	    /*
	      THIRD TURN FOR COMPUTER
	     */

	    storage = 90210;
	    storage = D.playTurn(dealerHand, B, 4);

	    if (storage == -1){
		System.out.println("The computer folded and you won");
		P.add(bet * 2);
		break;	    
	    }
	    if (storage == 0){
		System.out.println("The computer called");
		bet += carryOverBet;	
	    }
	    if(storage > 0){
		bet += carryOverBet;	
		int raise = storage;
		System.out.println("The computer raised by " + raise + ". Would you like to match his bet?\n   1. Call\n   2. Fold");
		int check = 90210;
		check = Keyboard.readInt();
		if(check == 1){
		     bet += raise * 2;
		}
		else{
		    System.out.println("You folded and lost your bet");
		    	    P.remove(bet);

		    break;
		    }
	    }
	    System.out.println("The pot is now " + bet);
	    carryOverBet = 0;
	    //end computer turn



	        
	    /*
	      REVEAL BRIDGE
	     */
	    System.out.println("The " + B.get(4) + " was shown on the bridge");
	    System.out.println("The bridge now has the " + B.get(0) + ", the " + B.get(1) + ", the " + B.get(2)+  ", the " + B.get(3) + " and the " +  B.get(4));



	    /*
	      FOURTH TURN FOR PLAYER
	     */
	    storage = 90210;
	    storage = P.playTurn();

	    if (storage == -1){
		System.out.println("You folded and lost your bet");
			    P.remove(bet);

		break;	    
	    }
	    if(storage > 0){
		bet += storage;
		System.out.println("You raised by $" + storage);
		carryOverBet = storage;
	    }//end player turn

	    /*
	      FOURTH TURN FOR COMPUTER
	     */

	    storage = 90210;
	    storage = D.playTurn(dealerHand, B, 5);

	    if (storage == -1){
		System.out.println("The computer folded and you won");
		P.add(bet * 2);
		break;	    
	    }
	    if (storage == 0){
		System.out.println("The computer called");
		bet += carryOverBet;	
	    }
	    if(storage > 0){
		bet += carryOverBet;	
		int raise = storage;
		System.out.println("The computer raised by " + raise + ". Would you like to match his bet?\n   1. Call\n   2. Fold");
		int check = 90210;
		check = Keyboard.readInt();
		if(check == 1){
		     bet += raise * 2;
		}
		else{
		    System.out.println("You folded and lost your bet");
		    	    P.remove(bet);

		    break;
		    }
	    }
	    System.out.println("The pot is now " + bet);
	    //end computer turn
	    carryOverBet = 0;
	    //ENDED ROUND
	 



	    
	    /*
	      SHOW CARDS SO WE CAN CHECK IF EVERYTHING IS CORRECT
	     */
	    
	    //print out players cards
	    System.out.println("Your hand: ");
	    System.out.println(returnCard(playerHand.get(0)));
	    System.out.println(returnCard(playerHand.get(1)));

	    //print out dealers cards
	    System.out.println("The computer's hand");
	    System.out.println(returnCard(dealerHand.get(0)));
	    System.out.println(returnCard(dealerHand.get(1)));
	    
		
		
	
	if(handEvalTwoPlayer(playerHand, dealerHand, B) == "player"){//hand eval also needs to be added
	    System.out.println("You beat the computer");
	    P.add(bet);
	}
	
	else {
	    System.out.println("The computer won");
	    P.remove(bet);
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


    
   


    //prints out card for easier viewing
    public String returnCard(Card A){
	if(A.suit == 3){
	    return "- - - - - - - - -\n- S   " + A.cardToString() + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";
	}
	if(A.suit == 0){
	    return "- - - - - - - - -\n- H   " + A.cardToString() + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -"; 
	}
	if(A.suit == 2){
	    return "- - - - - - - - -\n- C   " + A.cardToString() + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";	    
	}
	if(A.suit == 1){
	    return "- - - - - - - - -\n- D   " + A.cardToString() + "         -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n-               -\n- - - - - - - - -";
	}
	return "ERROR 90210";
    }
    
}
