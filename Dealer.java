public class Dealer extends Gambler {

    public Dealer() {
	super();
	name = "The dealer";
    }

    public String action() {
	String ret = "";

	if (handVal < 16) {
	    ret = "h";
	}

	else {
	    ret = "s";
	}
	
	return ret;
    }

}
