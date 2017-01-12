import cs1.Keyboard;

public class blackjack {

    //potVal
    Deck d;
    int playerMoney;

    public blackjack(int a) {
	d = new Deck();
	playerMoney = a;
    }

    public static int playGame() {
	Player P = new Player(playerMoney);
	Dealer D = new Dealer();

	String play = "play";
       
	while (play.equals("play")) { 
	P.playturn();
	D.playturn();

	System.out.println("Would you like to play another round \n" +
			   "enter play to play another round" +
			   "enter leave to leave game");
	
	play = Keyboard.readString();
	}
	
	return P.Mvalue();
    }
	
    
}
