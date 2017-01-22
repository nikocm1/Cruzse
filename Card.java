public class Card{
    private int spades,clubs,hearts,diamonds;
    public int suit, value;
    
    
    public Card(int SUIT, int VALUE){
	suit = SUIT;
	value = VALUE;
    }
    
    public String returnSuit(){
	if(suit == 0){
	    return("hearts");
	}
	if(suit == 1){
	    return("diamonds");
	}
	if(suit == 2){
	    return("clubs");
	}
	if(suit == 3){
	    return("spades");
	}
	return "ERROR";
    }

    public String returnValue(){
	if(value == 1 || value == 11){
	    return("Ace");
	}
	if(value == 2){
	    return("Two");
	}
	if(value == 3){
	    return("Three");
	}
	if(value == 4){
	    return("Four");
	}
	if(value == 5){
	    return("Five");
	}
	if(value == 6){
	    return("Six");
	}
	if(value == 7){
	    return("Seven");
	}
	if(value == 8){
	    return("Eight");
	}
	if(value == 9){
	    return("Nine");
	}
	if(value == 10){
	    return("Ten");
	}
	if(value == 21){
	    return("Jack");
	}
	if(value == 22){
	    return("Queen");
	}
	if(value == 23){
	    return("King");
	}
	return "ERROR";
    }

    public int cardVal() {
	int ret = 0;
	
	if (value > 20) {
	    ret = 10;
	}

	else {
	    ret = value;
	}

	return ret;
    }

    public String cardToString() {
	String ret = "";

	if (value == 1 || value == 11) {
	    ret = "A";
	}

	if (value == 21) {
	    ret = "J";
	}

	if (value == 22) {
	    ret = "Q";
	}

	if (value == 23) {
	    ret = "K";
	}

	else {
	    ret = value;
	}

	return ret;
    }
    
    public String toString(){
	return (returnValue() + " of " + returnSuit());
    }

    public void lowAce() {
	value = 1;
    }
}
