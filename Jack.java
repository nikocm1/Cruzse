public class Jack extends Gambler {

    public Jack() {
	super();
	name = "Jack";
    }

    public String action() {
	return "s";
    }

    public String action(Card faceCard) {
	if (handVal < 12) {
	    return "h";
	}

	if (faceCard.cardVal() + 10 > 15 && faceCard.cardVal() + 10 > handVal) {
	    return "h";
	}

	return "s";
    }
}
