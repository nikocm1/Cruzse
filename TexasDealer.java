import cs1.Keyboard;

public class TexasDealer extends Gambler{
    public TexasDealer() {
	super();
	name = "The dealer";
    }

    public String action() {
	String ret = "";
	
	System.out.println("Would you like to hit or stay?" +
			   "\nenter h to hit" +
			   "\nenter s to stay");
	
	ret = Keyboard.readString();
	System.out.println();
	return ret;
    }

    
}
