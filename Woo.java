import cs1.Keyboard;


public class Woo{
    private static int cash;
    private static int game; //blackjack == 1 ; holdem == 2 ; slots == 3
    private static int keepPlaying;


    public static void main(String[] args){
	cash = 100;
	System.out.println("Welcome to the Cruzse Casino! You currently have " + cash + "$ in your account");
	
	System.out.println("What is your name?");
	String name = Keyboard.readString();
	
	System.out.println("What game would you like to play? \n  1. Blackjack \n  2. Texas Hold'em Poker\n ");
	game = Keyboard.readInt();
	System.out.println();
	while(cash > 0 && keepPlaying == 0){
	    if (game == 1) {
		blackjack j = new blackjack(name, cash);
		cash = j.playGame();
	    }
	    if (game == 2) {
		Texas j = new Texas(cash);
		cash = j.playGame();
	    }
	    
	    System.out.println("Would you like to play a different game, or leave the casino?");
	    System.out.println("   0.) Play a different game \n   1.) Leave the casino\n\n");
	    keepPlaying = Keyboard.readInt();
	    if(keepPlaying == 0){
		System.out.println("What game would you like to play?\n   1.) Blackjack\n   2.) Texas Hold'em Poker");
		game = Keyboard.readInt();
	    }			       
	}
	
    }
}


