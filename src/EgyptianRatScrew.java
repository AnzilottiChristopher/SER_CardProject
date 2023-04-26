import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;

import javax.swing.SwingUtilities;

public class EgyptianRatScrew 
{    public static void main(String[] args) throws Exception 
    {
        DeckOfCards deck = new DeckOfCards();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the button player1 would like to press when you want to slap the deck. Only your first input will count.");
        char keyboardButton = scan.next().charAt(0);
        Player player1 = new Player(keyboardButton);
        System.out.println("Enter the button player2 would like to press when you want to slap the deck. Only your first input will count.");
        keyboardButton = scan.next().charAt(0);
        Player player2 = new Player(keyboardButton);

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

       System.out.println(player1.getHand() + ""+ player1.getNumItems()+ "\n");
       System.out.println(player2.getHand()+ ""+ player2.getNumItems());


       //SwingUtilities.invokeLater(readConsoleTest::new);

        boolean event = true;
        GUI_Input gui = new GUI_Input();
        while(event)
        {
            if(gui.handleInput().equalsIgnoreCase("a"))
            {
                System.out.println("Hello");
                break;
            }
        }

        scan.close();

    }



    
}