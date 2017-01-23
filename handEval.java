import cs1.Keyboard;
import java.util.ArrayList;

public class handEval{
    public static String handEvalTwoPlayer(ArrayList<Card> playerHand, ArrayList<Card> dealerHand, ArrayList<Card> bridge){

	ArrayList<Card> hand1 = new ArrayList<Card>();
	hand1.add(playerHand.get(0));
	hand1.add(playerHand.get(1));
	for(int x = 0 ; x < 5 ; x ++){
	    hand1.add(bridge.get(x));
	}

	ArrayList<Card> hand2 = new ArrayList<Card>();
	hand2.add(dealerHand.get(0));
	hand2.add(dealerHand.get(1));
	for(int x = 0 ; x < 5 ; x ++){
	    hand2.add(bridge.get(x));
	}



    
	



	String handResult = "";
	/*
	//check for four of a kind
	if (handResult == ""){
	    handResult = evaluateFourOfAKind(hand1, hand2);
	}

	//check for full house
	if (handResult == ""){
	    handResult = evaluateFullHouse(hand1, hand2);
	}
	
	
	//check for flush
	if (handResult == ""){
	    handResult = evaluateFlush(hand1, hand2);
	}

	//check for straight
	if (handResult == ""){
	    handResult = evaluateStraight(hand1, hand2);
	}
	*/

	/*
	//check for three of a kind
	if (handResult == ""){
	    handResult = evaluateThreeOfAKind(hand1, hand2);
	}
	*/

	
	//check for two pair
	if (handResult == ""){
	    handResult = evaluateTwoPair(hand1, hand2);
	}
	
	//check for one pair
	if (handResult == ""){
	    handResult = evaluateOnePair(hand1, hand2);
	}
	

	
	//check for highCard
	if (handResult == ""){
	    handResult = evaluateHighCard(hand1, hand2);
	}


	return handResult;
    }

    /*
    public String evaluateFourOfAKind(ArrayList<Card> hand1, ArrayList<Card> hand2){
	for(int x = 0 ; x < 7 ; x++){
	    for(int i = 
	}
    }

    public String evaluateFullHouse(ArrayList<Card> hand1, ArrayList<Card> hand2){

    }
    */

    /*
    public String evaluateFlush(ArrayList<Card> hand1, ArrayList<Card> hand2){
	boolean pflush = false;
	boolean dflush = false;

	for(

    */
	
    
    /*
    public String evaluateStraight(ArrayList<Card> hand1, ArrayList<Card> hand2){
	
    }
    */
    /*
    public static String evaluateThreeOfAKind(ArrayList<Card> hand1, ArrayList<Card> hand2){
	boolean tp = false;
	int counter = 0;
	for(int x = 0; x < 7 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand1.get(x).value == hand1.get(i).value){
		    counter++;
		    if(counter > 2){
			tp = true;
		    }
		}
	    }
	    for(int i = x + 1; i > 0 ; i--){
		if(hand1.get(x).value == hand1.get(i).value){
		    counter++;
		    if(counter > 2){
			tp = true;
		    }
		}
	    }
	}

	boolean td = false;
	counter = 0;
	for(int x = 0; x < 7 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand2.get(x).value == hand2.get(i).value){
		    counter++;
		    if(counter > 2){
			td = true;
		    }
		}
	    }
	    for(int i = x + 1; i > 0 ; i--){
		if(hand1.get(x).value == hand1.get(i).value){
		    counter++;
		    if(counter > 2){
			tp = true;
		    }
		}
	    }
	}

	if(tp == true && td == false){
	    return "player";
	}
	if(tp == false && td == true){
	    return "dealer";
	}
	return "";
	
    }
    */









    
    //done
    public static String evaluateTwoPair(ArrayList<Card> hand1, ArrayList<Card> hand2){
	int pp = 0;
	for(int x = 0; x < 2 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand1.get(x).value == hand1.get(i).value){
		    pp++;
		}
	    }
	}
	System.out.println(pp);

	
	int dp = 0;
	for(int x = 0; x < 2 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand2.get(x).value == hand2.get(i).value){
		    dp++;
		}
	    }
	}
	System.out.println(dp);

	

	if(pp >= 2 && dp < 2){
	    return "player";
	}
	if(pp <= 2 && dp == 2){
	    return "dealer";
	}
	return "";
    }
    

    
    //done
    public static String evaluateOnePair(ArrayList<Card> hand1, ArrayList<Card> hand2){
	boolean pp = false;
	for(int x = 0; x < 2 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand1.get(x).value == hand1.get(i).value){
		    pp = true;
		    break;
		}
	    }
	}
	System.out.println(pp);

	boolean dp = false;
	for(int x = 0; x < 2 ; x++){
	    for(int i = x + 1; i < 7 ; i++){
		if(hand2.get(x).value == hand2.get(i).value){
		    dp = true;
		    break;
		}
	    }
	}
	System.out.println(dp);

	
	if(pp == true && dp == false){
	    return "player";
	}
	if(pp == false && dp == true){
	    return "dealer";
	}
	return "";
    }
    


    //done
    public static String evaluateHighCard(ArrayList<Card> hand1, ArrayList<Card> hand2){
	//get player high card
	int pHigh = 0;
	for(int x = 0 ; x < 7 ; x++){
	    if(hand1.get(x).value > pHigh){
		pHigh = hand1.get(x).value;
	    }
	}
	System.out.println(pHigh);


	//get dealer high card
	int dHigh = 0;
	for(int x = 0 ; x < 7 ; x++){
	    if(hand2.get(x).value > pHigh){
		dHigh = hand1.get(x).value;
	    }
	}
	System.out.println(dHigh);

	if(pHigh > dHigh){
	    return "player";
	}
	if(pHigh < dHigh){
	    return "dealer";
	}
	return "";
    }


    
}
