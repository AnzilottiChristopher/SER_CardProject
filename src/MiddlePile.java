/*
 * Chris Anzilotti, Peter Zegarek
 * SER 120
 * This is the class that defines the middle pile
 * Egyptian Rat-Screw
 */


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
    // Stacked last will contain the player who placed the second to last card down (so they can be attacked)
    private Player stackedLast;
    // stackedRecent contains the player who placed the most recent card (to be counterattacked)
    private Player stackedRecent;


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
        this.stackedLast = null;
        this.stackedRecent = null;
    }

    // Necessary getters and setters
    public Card[] getPileArray() {
        return this.pileArray;
    }

    //Getting the third to last card played
    public Card getThirdToLast() {
        return this.thirdToLast;
    }

    //Getting the second to last card played
    public Card getSecondToLast() {
        return this.secondToLast;
    }
    
    //Getting the last card played
    public Card getLast() {
        return this.last;
    }

    //Getting the amount of items in middlePile
    public int getNumItems() {
        return this.numItems;
    }

    //Checking if there's an event
    public boolean isEvent(){
        return this.event;
    }

    //Checking if there is a "double" event
    public boolean isDoubleEvent(){
        return this.doubleEvent;
    }

    //Checking if there is a "sandwich" event
    public boolean isSandwichEvent(){
        return this.sandwichEvent;
    }

    // Setter for "double" event
    public void setDoubleEvent(boolean event){
        this.doubleEvent = event;
    }

    // Setter for "sandwich" event
    public void setSandwichEvent(boolean event){
        this.sandwichEvent = event;
    }

    // Use the isEmpty function for a loop within main to add cards to someone's deck when they lose.
    // public boolean isEmpty(){
    //     return (numItems == 0);
    // }

    // This function will update with whoever 2nd most recently stacked a card
    public void updateStackedLast(Player player){
        this.stackedLast = player;

    }

    //Get the player who had just placed a card
    public Player getStackedRecent(){
        return this.stackedRecent;
    }

    // This function will update with whoever most recently placed a card
    public void updateStackedRecent(Player player){
        this.stackedRecent = player;

    }

    //Returns who put the second to last card
    public Player getStackedLast(){
        return this.stackedLast;
    }

    //Swaps which player who put the recent card with who put the second most recent card. Neccessary for counter-attacking
    public void swapStackedLast(){
        Player temp = this.stackedLast;
        this.stackedLast = this.stackedRecent;
        this.stackedRecent = temp;

    }
    // Adding a card to the pile as you play the game
    public void addCard(Card card){

        // If there are no items, only set this.last
        if (this.numItems == 0){
            this.pileArray[numItems] = card;
        }
        // If there is one item, only set this.last and this.secondToLast
        else if (this.numItems == 1){
            this.pileArray[numItems] =card;
           this.secondToLast = this.pileArray[numItems-1];
        }
        // Else set this.last, this.secondToLast, this.thirdToLast
        else {
            this.pileArray[numItems] =card;
            this.secondToLast = this.pileArray[numItems-1];
            this.thirdToLast = this.pileArray[numItems-2];
        }
        this.last = card;
        numItems++;
    }


    // Checks to see if there is an event, such as sandwich or double
    public boolean checkEvent(){
        // Error handling
        if(this.last == null)
        {
            return false;
        }
        // Setting all events to false, so we can check for them
        this.event = false;
        this.doubleEvent = false;
        this.sandwichEvent = false;
        // Condition to check for a "double". If the face of the most recent and the second to most recent are the same.
        if (this.secondToLast.getFace().equals(this.last.getFace())){
            this.event = true;
            this.doubleEvent = true;
        }
        // Condition to check for a "sandwich". If the third to last card's face equals the last card's face. 
        if (this.getNumItems() > 2){
            if (this.thirdToLast.getFace().equals(this.last.getFace())){
                this.event = true;
                this.sandwichEvent = true;
            }
        }

        return this.event;
    }

    // This function uses the enum type to check whether there is an attack or not and to return which one it is
    public AttackType checkAttack(){
        //Exception handling
        if(this.last == null)
        {
            return AttackType.NO_ATTACK;
        }
        //Checking the last card placed if it's a face card
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
        else{
            return AttackType.NO_ATTACK;
        }

    }

    


    // Remove card from the middlePile (to be added to player)
    public Card removeCard(){
        Card tempCard = pileArray[numItems-1];
        pileArray[numItems-1] = null; 
        numItems--;
        return tempCard;
    }
}
