public class Deck{

    //every deck needs:
    //cards
    //shuffle ability
    //ability to add and remove cards

    //each suit will be represented as an int between 0 and 3
    //0 will represent hearts, 1 will represent diamonds, 2 will represent clubs, 3 will represent spades
    //each card will also get a value from 1 to 13, representing its face value
    //aces will be 1, numbers will be 2-10, jacks 11, queens 12, kings 13
    
    private Card[] deck;

    public Deck(){
	int count = 0;
	for(int suit = 0 ; suit <= 3 ; suit++){
	    for(int value = 1 ; value <= 13 ; value++){
		deck[count] = new Card(suit,value);
		count++;
	    }
	}
    }
    
    public void shuffle(){
	//completely reset deck
        for (int i = deck.length - 1 ; i > 0 ; i-- )
        {
            int rand = (int)(Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }
    
}
