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
	Player P = new Player(playerMoney);
	Dealer D = new Dealer();

	System.out.println("You have " + playerMoney + "$");









	return P.mValue();
    }
    
}
