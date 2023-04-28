import java.util.ArrayList;
import java.util.Collections;

public class Player 
{
    //Creating lists that will hold cards
    private ArrayList<Card> hand;
    private final static int deckSize = 52;
    private char buttonPress;
    private int numItems;
    private char addCardPress;

    //Constructor that initializes the player with a button press
    public Player(char buttonPress, char addCardPress)
    {
        this.hand = new ArrayList<Card>(deckSize/2);
        this.buttonPress = buttonPress;
        this.numItems = 0;
        this.addCardPress = addCardPress;
    }

    // Function to deal cards from the player's deck to the middle pile
    public Card dealCard()
    {
        this.numItems--;
        if(numItems == 0)
        {
            return null;
        }
        return hand.remove(0);
        
    }

    // Getter to get the hand of the player
    public ArrayList<Card> getHand()
    {
        return this.hand;
    }

    public String getAddCardPress(){
        String temp = "" + this.addCardPress;
        return temp;
    }
    
    // Getter to get number of items
    public int getNumItems(){
        return this.numItems;
    }
    // Getter to get the button press that the player has selected
    public String getButton()
    {
        String temp = "" + this.buttonPress;
        return temp;
    }

    // Check for win condition
    // public boolean isWin()
    // {
    //     return this.numItems == 52;
    // }
    
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

    //Places the top card
    public Card placeCard()
    {
        Card placedCard = this.hand.remove(this.numItems-1);
        numItems--;
        return placedCard;
    }
    
    //Shuffles the players hand
    public void shuffleHand()
    {
        Collections.shuffle(hand);
    }
}
