import java.util.ArrayList;

public class Players 
{
    //Creating lists that will hold cards
    private ArrayList<Card> player1;
    private ArrayList<Card> player2;
    private DeckOfCards deck = new DeckOfCards();
    private final static int deckSize = 52;

    //Creating the deck and shuffling it
    public Players()
    {
        deck.shuffle();
        this.player1  = new ArrayList<Card>(deckSize/2);
        this.player2 = new ArrayList<Card>(deckSize/2);
    }

    public void players()
    {
        for(int counter = 0; counter < deckSize/2; counter ++)
        {
            if(counter < deckSize/2)
            {
                this.player1.add(deck.dealCard());
            }
        }
    }
    
}
