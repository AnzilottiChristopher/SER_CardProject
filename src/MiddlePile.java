import java.util.ArrayList;


public class MiddlePile {
    // Instance data
    private Card[] pileArray;
    private Card thirdToLast;
    private Card secondToLast;
    private Card last;
    private int numItems;
    private boolean event;
    private boolean doubleEvent;
    private boolean sandwichEvent;


    // Constructor
    public MiddlePile(){
        this.pileArray = new Card[52];
        this.thirdToLast = null;
        this.secondToLast = null;
        this.last = null;
        this.numItems = 0;
        this.event = false;
        this.doubleEvent = false;
        this.sandwichEvent = false;
    }

    // Necessary getters. Setters are not needed here
    public Card[] getPileArray() {
        return this.pileArray;
    }

    public Card getThirdToLast() {
        return this.thirdToLast;
    }

    public Card getSecondToLast() {
        return this.secondToLast;
    }

    public Card getLast() {
        return this.last;
    }

    public int getNumItems() {
        return this.numItems;
    }

    public boolean isEvent(){
        return this.event;
    }

    public boolean isDoubleEvent(){
        return this.doubleEvent;
    }

    public boolean isSandwichEvent(){
        return this.sandwichEvent;
    }

    // Use the isEmpty function for a loop within main to add cards to someones deck when they lose.
    public boolean isEmpty(){
        return (numItems == 0);
    }

    // Adding a card to the pile as you play the game
    public void addCard(Card card){

        if (this.numItems == 0){
            this.pileArray[numItems] = card;
        }
        else if (this.numItems == 1){
            this.pileArray[numItems] =card;
            secondToLast = this.pileArray[numItems-1];
        }
        else {
            this.pileArray[numItems] =card;
            secondToLast = this.pileArray[numItems-1];
            thirdToLast = this.pileArray[numItems-2];
        }
        this.last = card;
        numItems++;
    }


    // Checks to see if there is an event, such as sandwich or double
    public boolean checkEvent(){
        this.event = false;
        this.doubleEvent = false;
        this.sandwichEvent = false;
        // Condition to check for a "double". If the face of the most recent and the second to most recent are the same.
        if (this.secondToLast.getFace().equals(this.last.getFace())){
            this.event = true;
            this.doubleEvent = true;
        }
        // Condition to check for a "sandwich". If the third to last card's face equals the last card's face. 
        else if (this.thirdToLast.getFace().equals(this.last.getFace())){
            this.event = true;
            this.sandwichEvent = false;
        }

        return this.event;
    }

    // This function uses the enum type to check whether there is an attack or not and to return which one it is
    public AttackType checkAttack(){
        if (this.last.getFace().equals("Jack")){
            return AttackType.JACK_ATTACK;
        }
        else if (this.last.getFace().equals("Queen")){
            return AttackType.QUEEN_ATTACK;
        }
        else if (this.last.getFace().equals("King")){
            return AttackType.KING_ATTACK;
        }
        else if (this.last.getFace().equals("Ace")){
            return AttackType.ACE_ATTACK;
        }
        else if (this.last.getFace().equals("Ten")){
            return AttackType.TEN_SAVE;
        }
        else{
            return AttackType.NO_ATTACK;
        }

    }



    // Need to add a function where cards are added to the player who wins
    public Card removeCard(){
        Card tempCard = pileArray[numItems-1];
        pileArray[numItems-1] = null; 
        numItems--;
        return tempCard;
    }
}
