import java.util.ArrayList;

public class Players 
{
    //Creating lists that will hold cards
    ArrayList<Card> player1 = new ArrayList<Card>();
    ArrayList<Card> player2 = new ArrayList<Card>();
    ArrayList<Card> middlePile = new ArrayList<Card>();

    //Deck Size
    final int deckSize = 52;

    //Creating the deck and shuffling it
    DeckOfCards deck = new DeckOfCards();

    public Players()
    {

    }

    public Players(ArrayList<Card> player1, ArrayList<Card> player2, ArrayList<Card> middlePile)
    {


    }
      
    
}
