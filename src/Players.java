import java.util.ArrayList;

public class Players 
{
    //Creating lists that will hold cards
    private ArrayList<Card> hand;
    private final static int deckSize = 52;
    private char buttonPress;

    //Constructor that initializes the player with a button press
    public Players(char buttonPress)
    {
        this.hand = new ArrayList<Card>(deckSize/2);
        this.buttonPress = buttonPress;
    }


    //Setter and getter
    public Card dealCard()
    {
        return hand.remove(0);
    }

    public char getButton()
    {
        return buttonPress;
    }
    public void setButton(char buttonPress)
    {
        this.buttonPress = buttonPress;
    }

    public void addCard(Card card)
    {
        hand.add(card);
    }
    
}
