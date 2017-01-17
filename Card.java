public class Card{
    private int spades,clubs,hearts,diamonds;
    private int suit, value;
    
    
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
	if(value == 1){
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
	if(value == 11){
	    return("Jack");
	}
	if(value == 12){
	    return("Queen");
	}
	if(value == 13){
	    return("King");
	}
	return "ERROR";
    }

    public int cardVal() {
	int ret = 0;
	
	if (value > 10) {
	    ret = 10;
	}

	else {
	    ret = value;
	}

	return ret;
    }
    
    public String toString(){
	return (returnValue() + " of " + returnSuit());
    }
}
