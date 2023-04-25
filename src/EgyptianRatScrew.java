import java.util.ArrayList;
import java.util.Scanner;

public class EgyptianRatScrew 
{    public static void main(String[] args) throws Exception 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the button player1 would like to press when you want to slap the deck. Only your first input will count.");
        char keyboardButton = scan.next().charAt(0);
        // Create player 1 like Player player1 = new Player(keyboardButton);
        System.out.println("Enter the button player2 would like to press when you want to slap the deck. Only your first input will count.");
        keyboardButton = scan.next().charAt(0);
        // Create player 2 like Player player2 = new Player(keyboardButton);

    scan.close();

}
}