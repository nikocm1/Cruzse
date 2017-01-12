public class Deck{

    //every deck needs:
    //cards
    //shuffle ability
    //ability to add and remove cards

    //each suit will be represented as an int between 0 and 3
    //0 will represent hearts, 1 will represent diamonds, 2 will represent clubs, 3 will represent spades
    //each card will also get a value from 1 to 13, representing its face value
    //aces will be 1, numbers will be 2-10, jacks 11, queens 12, kings 13
    
    private Card[] deck = new Card[52];
    private int drawNum = 0;

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

    //return card at index i of deck
    public Card get(int i) {
	return deck[i];
    }

    //take a card off of the "top" of the deck
    public Card draw() {
	Card ret;
	ret = deck[drawNum];
	drawNum++;
	return ret;
    }

    //reset "top card"
    //can probably incorporate this
    //into shuffle
    public void resetDrawNum() {
	drawNum = 0;
    }

    //prints all cards "under" top
    //card and the top card
    public String toString() {
	String ret = "";
	for (int i = drawNum; i < 52; i++) {
	    ret += get(i) + "\n";
	}
	return ret;
    }

    /*       
    public static void main( String[] args ) {
	Deck d = new Deck();
	System.out.println(d);

	d.shuffle();
	System.out.println(d);
    }
    */
    
}
