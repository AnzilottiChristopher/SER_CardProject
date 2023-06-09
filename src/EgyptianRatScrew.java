/*
 * Chris Anzilotti, Peter Zegarek
 * SER 120
 * This is the driver class to run the game
 * Egyptian Rat-Screw
 */

import java.util.Scanner;

public class EgyptianRatScrew {
    public static void main(String[] args) throws Exception {
        DeckOfCards deck = new DeckOfCards();
        Scanner scan = new Scanner(System.in);

        // Players initialize the buttons they want to press.
        System.out.println(
                "Enter the button player1 would like to press when you want to slap the deck. Only your first input will count.");
        char keyboardButton = scan.next().charAt(0);
        System.out.println(
                "Enter the button player1 would like to press when you want to add a card to the deck. Only your first input will count.");
        char addCardButton = scan.next().charAt(0);
        Player player1 = new Player(keyboardButton, addCardButton);
        System.out.println(
                "Enter the button player2 would like to press when you want to slap the deck. Only your first input will count.");
        keyboardButton = scan.next().charAt(0);
        System.out.println(
                "Enter the button player2 would like to press when you want to add a card to the deck. Only your first input will count.");
        addCardButton = scan.next().charAt(0);
        Player player2 = new Player(keyboardButton, addCardButton);


        //Re-stating what buttons players use
        System.out.println("Player 1, you will press " + player1.getButton() + " to slap the deck and "
                + player1.getAddCardPress() + " to play a card.");
        System.out.println("Player 2, you will press " + player2.getButton() + " to slap the deck and "
                + player2.getAddCardPress() + " to play a card.");

        //Giving each player half the deck
        deck.shuffle();
        for (int cards = 0; cards < 52; cards++) {
            if (cards % 2 == 0) {
                player1.addCard(deck.dealCard());
            } else {
                player2.addCard(deck.dealCard());
            }
        }

        //Initiliazing the gui that intakes the inputs
        GUI_Input gui = new GUI_Input();
        MiddlePile middlePile = new MiddlePile();
        System.out.println();
        System.out.println("Player 1 begins:");


        //This boolean makes it so player 1 can only press once
        boolean player1CardPlace = true;


        // Game logic starts here
        while (true) {

            //This checks if player 1 can play a card and if the button was player 1's
            if(player1CardPlace && gui.handleInput().equalsIgnoreCase((player1.getAddCardPress())) )
            {
                //Calling player handler
                EgyptianRatScrew.playerHandler(gui, player1, player2, middlePile);

                //Switches boolean to false so player 1 can't press again until after player 2
                player1CardPlace = false;

            }

            //This checks if player 2 can play a card and if the button was player 2's
            if(!player1CardPlace && gui.handleInput().equalsIgnoreCase((player2.getAddCardPress())))
            {
                //Calling player handler
                EgyptianRatScrew.playerHandler(gui, player2, player1, middlePile);

                //Switches boolean to true so player 1 can press again and player 2 can't play until after player 1
                player1CardPlace = true;

            }
            
            //Calling attackhandler 
            EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
            //Calling gameEventHandler
            EgyptianRatScrew.gameEventHandler(middlePile, gui, player1, player2);
            
            //This checks if one player is out of cards then breaks the loop if so
            if(player1.getNumItems() == 0)
            {
                System.out.println("Player 2 wins!");
                break;
            }
            else if(player2.getNumItems() == 0)
            {
                System.out.println("Player 1 wins!");
                break;
            }

        }

        scan.close();

    }

    public static void playerHandler(GUI_Input gui, Player player, Player otherPlayer, MiddlePile middlePile) 
    {
         // Logic for when player1 places a card
         if (gui.handleInput().equalsIgnoreCase((player.getAddCardPress()))) {
            // Remove the card from the player and add it to middlePile
            middlePile.addCard(player.placeCard());
            // Here we call the print card function
            Card.printCard(middlePile.getLast());
            // Update who stacked the card and who stacked the second to last card
            middlePile.updateStackedLast(otherPlayer);
            middlePile.updateStackedRecent(player);

        }
    }

    public static void gameEventHandler(MiddlePile middlePile, GUI_Input gui, Player player1, Player player2) 
    {
        // Checking for an event (double or sandwich)
        // We only check for an event if there are at least 2 cards in the pile
        if (middlePile.getNumItems() > 1) {
            if (middlePile.checkEvent()) {
                System.out.println("SLAP!!!");
                // If there is a double or sandwich, players must slap, then they get the whole middle pile.
                while ((middlePile.isDoubleEvent()) || (middlePile.isSandwichEvent())) {
                    // If player 1 slaps, give cards to player 1
                    if (gui.handleInput().equalsIgnoreCase((player1.getButton()))) {
                        // while there are cards in the middle pile, remove them and give them to player1.
                        while (middlePile.getNumItems() > 0) {
                            player1.addCard(middlePile.removeCard());
                        }
                        //This shuffles player 1's hand
                        player1.shuffleHand();
                        // set event conditions to false and print out the number of cards player 1 has.
                        middlePile.setDoubleEvent(false);
                        middlePile.setSandwichEvent(false);

                        //Printing who slapped and how many cards each player has
                        System.out.println("Player 1 slapped!!!");
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");

                        //breaks out of the loop
                        break;
                    }
                    // If player 2 slaps, give cards to player 2
                    if (gui.handleInput().equalsIgnoreCase((player2.getButton()))) {
                        // while there are cards in the middle pile, remove them and give them to player2.
                        while (middlePile.getNumItems() > 0) {
                            player2.addCard(middlePile.removeCard());
                        }
                        //Shuffling player 2
                        player2.shuffleHand();
                        // set event conditions to false and print out the number of cards player 2 has.
                        middlePile.setDoubleEvent(false);
                        middlePile.setSandwichEvent(false);

                        //Printing who slapped and how many cards each player has
                        System.out.println("Player 2 slapped!!!");
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");

                        //Breaks out of the loop
                        break;
                    }

                }
            }

        }

        // Here we will print the status of the game if someone presses 0.
        if (gui.handleInput().equalsIgnoreCase(("0"))) {
            System.out.println("Player 1 has " + player1.getNumItems() + " cards");
            System.out.println("Player 2 has " + player2.getNumItems() + " cards");
            gui.clearText();

        }

    }

    public static void attackHandler(MiddlePile middlePile, GUI_Input gui, Player player1, Player player2){
        // Now we have to check to see if there is an attack
        if (middlePile.getNumItems() > 0){
            switch(middlePile.checkAttack()){
                // If no attack, nothing happens
                case NO_ATTACK:
                    break;

                // If there is a jack, make the other player place 1 card.
                case JACK_ATTACK:
                    System.out.println("There is a jack attack!");
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());
                    break;

                // If there is a queen, make the other player place 2 cards.
                case QUEEN_ATTACK:
                    System.out.println("There is a queen attack!");
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }
                    // If there is an attack, counterattack
                    if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());
                    break;

                // If there is a king, make the other player place 3 cards.
                case KING_ATTACK:
                    System.out.println("There is a king attack!");
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }

                     // If there is an attack, counterattack
                     if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }

                     // If there is an attack, counterattack
                     if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());
                    break;

                // If there is an ace, make the other player place 4 cards.
                case ACE_ATTACK:
                    System.out.println("There is an ace attack!");
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }

                     // If there is an attack, counterattack
                     if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }

                     // If there is an attack, counterattack
                     if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());

                    //Exception handling if a player has no more cards terminate the function
                    if (middlePile.getStackedLast().getNumItems() == 0){
                        return;
                    }
                    
                     // If there is an attack, counterattack
                     if (middlePile.checkAttack() != AttackType.NO_ATTACK){
                        System.out.println("COUNTERATTACK!!!");
                        middlePile.swapStackedLast();
                        EgyptianRatScrew.attackHandler(middlePile, gui, player1, player2);
                        return;
                    }
                    // If there is an event or a ten, cancel the attack.
                    if (middlePile.checkEvent() || middlePile.getLast().getFace().equals("Ten")){
                        System.out.println("Player 1 has " + player1.getNumItems() + " cards");
                        System.out.println("Player 2 has " + player2.getNumItems() + " cards");
                        return;
                    }
                    middlePile.addCard(middlePile.getStackedLast().dealCard());
                    Card.printCard(middlePile.getLast());
                    break;
                    

            }
        }
    }

}