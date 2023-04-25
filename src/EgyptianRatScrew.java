import java.util.ArrayList;

public class EgyptianRatScrew 
{    public static void main(String[] args) throws Exception 
    {
        //Creating lists that will hold cards
        ArrayList<Card> player1 = new ArrayList<Card>();
        ArrayList<Card> player2 = new ArrayList<Card>();
        ArrayList<Card> middlePile = new ArrayList<Card>();

        //Deck Size
        final int deckSize = 52;

        //Creating the deck and shuffling it
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        for(int counter = 0; counter < deckSize; counter ++)
        {
            if(counter < deckSize/2)
            {
                player1.add(deck.dealCard());
            }
            else
            {
                player2.add(deck.dealCard());
            }
        }
    }
}
