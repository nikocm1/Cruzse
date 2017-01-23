import cs1.Keyboard;
//class Slots
//simulates a slot machine in your very own terminal

public class Slots {

    private static final String[] FRUITS = {
	"lime", "lime", "lime", 
	"lemon", "lemon", "lemon", 
	"cherry", "cherry", "cherry", 
	"orange", "orange", "orange", 
	"grapefruit", "grapefruit", "grapefruit", 
	"tangerine", "tangerine", "tangerine", 
	"ugli", "ugli", "ugli",
	"peach", "peach", "peach"
    };
    private String[] _fruits; //to be init'd by each instance
    private int playerMoney;


    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    public Slots(int cash) {

	//allocate memory for _fruits based on size of FRUITS
	_fruits = new String[FRUITS.length];//we all know the length is 24 but this makes for greater readability

	playerMoney = cash;

	//copy elements of FRUITS into _fruits
	int randomInt = (int) (Math.random() * 100);//spawn random int
	for (int x = 0; x < FRUITS.length; x += 1) {//will have x take on values 0-23 to fill _fruits
	    _fruits[x] = FRUITS[randomInt % 24];//mod randomInt by 24 so that we have an index within FRUITS and start filling _fruits from here
	    //this way not all _fruits will start alike, it doesn't matter but makes me feel better
	    randomInt += 1;//increment randomInt
	}
    }


    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString() {
	return _fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2];//toString is a method of Slots so just return that Slots' fruits at indices 0,1,2
    }


    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap( int i, int j ) {
	String r = _fruits[j];//hold place for _fruits[j]
	_fruits[j] = _fruits[i];//_fruits[j] becomes _fruits[i]
	_fruits[i] = r;//use place holder so _fruits[i] becomes _fruits[j]
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    public void spinOnce() {
	int a;//declare ints a & b outside of loop so no erros
	int b;
	for (int x = 0; x < 24; x += 1) {//will swap 24 times (length of _fruits)
	    a = (int) (Math.random() * 24);//a is [0,24)
	    b = (int) (Math.random() * 24);//so is b
	    swap(a,b);//swap em
	}//repeat
    }


    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    public boolean jackpot() {
	return (_fruits[0].equals(_fruits[1]) && _fruits[0].equals(_fruits[2]));
	//return 1st = 2nd & 1st = 3rd (all equal)
    }


    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct, 
      false otherwise
      =====================================*/
    public boolean miniWin() {
	return (jackpot() || !(_fruits[0].equals(_fruits[1]) ||  _fruits[0].equals(_fruits[2]) || _fruits[1].equals(_fruits[2])));
	//return jackpot() conditions or !(1st = 2nd or 1st = 3rd or 2nd = 3rd) (all are not equal)
    }


    //main() method for testing
    public int playGame() {
	String play = "p";
	Player P = new Player(playerMoney);
	int bet;
	System.out.println("It costs 1 dollar to play the slots" +
			   "\nIf you get 3 different fruits you will win 3 dollars" +
			   "\nIf you get 3 of the same fruit you will win 50 dollars");
	
	while (play.equals("p")) {
	    System.out.println();
	    P.add(-1);
	    System.out.println( "Slot machine initial state:\t" + this );

	    spinOnce();

	    System.out.println( "Your spin..." + "\t" + this );

	    if ( jackpot() ) {
		System.out.println( "JACKPOT!\n" );
		P.add(50);
	    }

	    else if ( miniWin() ) {
		System.out.println( "WIN\n" );
		P.add(3);
	    }

	    else {
		System.out.println("LOSE\n");
	    }

	    if (P.mValue() <= 0) {
		System.out.println("You have gone bankrupt");
		break;
	    }

	    System.out.println("You now have " + P.mValue());
	    System.out.println("Do you want to play again?" +
			       "\nenter p to play again" +
			       "\nenter l to leave");
	    
	    play = Keyboard.readString();
	    
	}
	return P.mValue();
    }
	    
}//end class Slots
