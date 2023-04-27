import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;
import javax.swing.SwingUtilities;

public class EgyptianRatScrew 
{    public static void main(String[] args) throws Exception 
    {
        DeckOfCards deck = new DeckOfCards();
        Scanner scan = new Scanner(System.in);

        // Players initialize the buttons they want to press.
        System.out.println("Enter the button player1 would like to press when you want to slap the deck. Only your first input will count.");
        char keyboardButton = scan.next().charAt(0);
        System.out.println("Enter the button player1 would like to press when you want to add a card to the deck. Only your first input will count.");
        char addCardButton = scan.next().charAt(0);
        Player player1 = new Player(keyboardButton, addCardButton);
        System.out.println("Enter the button player2 would like to press when you want to slap the deck. Only your first input will count.");
        keyboardButton = scan.next().charAt(0);
        System.out.println("Enter the button player2 would like to press when you want to add a card to the deck. Only your first input will count.");
        addCardButton = scan.next().charAt(0);
        Player player2 = new Player(keyboardButton, addCardButton);

        System.out.println("Player 1, you will press " + player1.getButton() + " to slap the deck and " + player1.getAddCardPress() + " to play a card.");
        System.out.println("Player 2, you will press " + player2.getButton() + " to slap the deck and " + player2.getAddCardPress() + " to play a card.");
       

        deck.shuffle();
       for (int cards = 0; cards < 52; cards++)
       {
        if (cards%2 == 0)
        {
            player1.addCard(deck.dealCard());
        }
        else
        {
            player2.addCard(deck.dealCard());
        }
       }

       GUI_Input gui = new GUI_Input();
       MiddlePile middlePile = new MiddlePile();
       /* 
        boolean event = true;
        
        while(event)
        {
            if(gui.handleInput().equalsIgnoreCase("a"))
            {
                System.out.println("Hello");
                break;
            }
        }
        */

        // Game logic starts here
        while (!player1.isWin() && !player2.isWin()){

            // Logic for when player1 places a card
            if(gui.handleInput().equalsIgnoreCase((player1.getAddCardPress()))){
                // We may have to include logic that does not allow this when player 1 has no cards.
                middlePile.addCard(player1.placeCard());
                // For now, print statement
                System.out.println("Player 1 placed " + middlePile.getLast());
                // Here we call the print card function

                // Then program sleeps for a bit, so it doesnt register the input again
                Thread.sleep(300);
            }

            // Logic for when player2 places a card
            if(gui.handleInput().equalsIgnoreCase((player2.getAddCardPress()))){
                // We may have to include logic that does not allow this when player 2 has no cards.
                middlePile.addCard(player2.placeCard());
                // For now, print statement
                System.out.println("Player 2 placed " + middlePile.getLast());
                // Here we call the print card function

                // Then program sleeps for a bit, so it doesnt register the input again
                Thread.sleep(300);
            }
            
            // Every time a player places a card, we must check for an attack, event, or if someone has won

            // Checking for an event (double or sandwich)
            if (middlePile.checkEvent()){

                // If there is a double or sandwich, players must slap, then they get the whole middle pile.
                while ((middlePile.isDoubleEvent()) || (middlePile.isSandwichEvent())){
                    // If player 1 slaps, give cards to player 1
                    if(gui.handleInput().equalsIgnoreCase((player1.getButton()))){
                        while (middlePile.getNumItems() > 0){
                            player1.addCard(middlePile.removeCard());
                        }
                        middlePile.setDoubleEvent(false);
                        middlePile.setSandwichEvent(false);
                        break;
                    }
                    // If player 2 slaps, give cards to player 2
                    if(gui.handleInput().equalsIgnoreCase((player2.getButton()))){
                        while (middlePile.getNumItems() > 0){
                            player2.addCard(middlePile.removeCard());
                        }
                        middlePile.setDoubleEvent(false);
                        middlePile.setSandwichEvent(false);
                        break;
                    }

                }
            }





        }

        if (player1.isWin()){
            System.out.println("Player 1 wins!");
        }
        else {
            System.out.println("Player 2 wins!");
        }


        scan.close();

    }



    
}