import cs1.Keyboard;


public class Woo{
    private static int cash;
    private static int game; //blackjack == 1 ; holdem == 2 ; slots == 3


    public static void main(String[] args){
	cash = 100;
	System.out.println("Welcome to the Cruzse Casino! You currently have " + cash + "$ in your account");
	System.out.println("What game would you like to play? \n  1. Blackjack ");
	game = Keyboard.readInt();
    }
    if(game == 1){
	blackjack();
    }
}