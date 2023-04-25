import java.util.ArrayList;

public class Player 
{
    //Creating lists that will hold cards
    private ArrayList<Card> hand;
    private final static int deckSize = 52;
    private char buttonPress;
    private int numItems;

    //Constructor that initializes the player with a button press
    public Player(char buttonPress)
    {
        this.hand = new ArrayList<Card>(deckSize/2);
        this.buttonPress = buttonPress;
        this.numItems = 0;
    }


    // Function to deal cards from the player's deck to the middle pile
    public Card dealCard()
    {
        this.numItems--;
        return hand.remove(0);
        
    }

    // Getter to get the hand of the player
    public ArrayList<Card> getHand()
    {
        return this.hand;
    }
    
    // Getter to get number of items
    public int getNumItems(){
        return this.numItems;
    }
    // Getter to get the button press that the player has selected
    public char getButton()
    {
        return this.buttonPress;
    }
    
    // Setter to potentially change the button press for the player
    public void setButton(char buttonPress)
    {
        this.buttonPress = buttonPress;
    }

    // Function to add cards to the hand. These cards will be added to the bottom of the hand.
    public void addCard(Card card)
    {
        this.hand.add(card);
        this.numItems++;
    }
    
}
