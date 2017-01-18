import java.util.ArrayList;


public class Bridge extends Deck{
    protected ArrayList<Card> bridge;
    
    public Bridge(){
	bridge = new ArrayList<Card>();       
    }

    protected void reset() {
	while (bridge.size() > 0) {
	    bridge.remove(0);
	}
    }
    
    public String action(){
	return "";
    }

    
    
    
}
