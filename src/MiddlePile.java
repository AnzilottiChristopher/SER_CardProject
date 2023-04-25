import java.util.ArrayList;

public class MiddlePile {
    // Instance data
    private ArrayList<Card> pileList;
    private Card thirdToLast;
    private Card secondToLast;
    private Card last;
    private int numItems;


    // Constructor
    public MiddlePile(){
        this.pileList = new ArrayList<Card>();
        this.thirdToLast = null;
        this.secondToLast = null;
        this.last = null;
        this.numItems = 0;
    }

    // Necessary getters. Setters are not needed here
    public ArrayList<Card> getPileList() {
        return pileList;
    }

    public Card getThirdToLast() {
        return thirdToLast;
    }

    public Card getSecondToLast() {
        return secondToLast;
    }

    public Card getLast() {
        return last;
    }

    public int getNumItems() {
        return numItems;
    }

    // Use the isEmpty function for a loop within main to add cards to someones deck when they lose.
    public boolean isEmpty(){
        return (numItems == 0);
    }

    // Adding a card to the pile as you play the game
    public void AddCard(Card card){
        // Needs to be implemented
    }

    // Need to add a function where cards are added to the player who loses
    public void cardsToPlayer(){
    
    }
}
