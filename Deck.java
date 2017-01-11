public class Deck{

    //every deck needs:
    //cards
    //shuffle ability
    //ability to add and remove cards

    //each suit will be represented as an int between 0 and 3
    //0 will represent hearts, 1 will represent diamonds, 2 will represent clubs, 3 will represent spades
    //each card will also get a value from 1 to 13, representing its face value
    //aces will be 1, numbers will be 2-10, jacks 11, queens 12, kings 13
    
    private int[] deck = new deck[52];

    public Deck(){
	int count = 0;
	for(int i = 0 ; i < =3 ; i++){
	    for(int c = 1 ; c <= 13 ; c++){
		deck[count] = c;
		count++;
	}
    }


    //to be used for swapping when deck is shuffled
    public void swapCards(int c1, int c2){      
        Card temp = cards[c1];
        cards[c1] = cards[c2];
        cards[c2] = temp;
    }

    
}
