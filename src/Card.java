// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card {
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
 
   // two-argument constructor initializes card's face and suit
   public Card(String cardFace, String cardSuit) {
      this.face = cardFace; // initialize face of card
      this.suit = cardSuit; // initialize suit of card
   } 
 
   public String getFace(){
   return this.face;
   }
   public String getSuit(){
   return this.suit;
   }
    
   // return String representation of Card
   public String toString() {             
      return face + " of " + suit;        
   }    
    
   //This function prints the card
   public static void printCard(Card card)
   {
      //exception handling
      if(card == null)
      {
         return;
      }

      String suit = null;
      //checking what the suit is 
      if(card.getSuit().equalsIgnoreCase("diamonds"))
      {
         suit = "D";
      }
      else if(card.getSuit().equalsIgnoreCase("spades"))
      {
         suit = "S";
      }
      else if(card.getSuit().equalsIgnoreCase("hearts"))
      {
         suit = "H";
      }
      else if(card.getSuit().equalsIgnoreCase("clubs"))
      {
         suit = "C";
      }

      //Printing cards based on value, word length so it prints correctly
      if(card.getFace().length() == 3)
      {
         System.out.println("┌─────────┐");

         // print the card rank and suit
         System.out.printf("│%s        │\n", suit);
         System.out.printf("│         │\n");
         System.out.printf("│ %s     │\n", card.getFace());
         System.out.printf("│         │\n");
         System.out.printf("│        %s│\n", suit);

         // print the bottom line of the card
         System.out.println("└─────────┘");
      }
      else if(card.getFace().length() == 4)
      {
         System.out.println("┌─────────┐");

         // print the card rank and suit
         System.out.printf("│%s        │\n", suit);
         System.out.printf("│         │\n");
         System.out.printf("│ %s    │\n", card.getFace());
         System.out.printf("│         │\n");
         System.out.printf("│        %s│\n", suit);

         // print the bottom line of the card
         System.out.println("└─────────┘");
      }
      else if (card.getFace().length() == 5) 
      {
         System.out.println("┌─────────┐");

         // print the card rank and suit
         System.out.printf("│%s        │\n", suit);
         System.out.printf("│         │\n");
         System.out.printf("│ %s   │\n", card.getFace());
         System.out.printf("│         │\n");
         System.out.printf("│        %s│\n", suit);

         // print the bottom line of the card
         System.out.println("└─────────┘");
      }
      
      

   }
 } 
 
 
 
 /**************************************************************************
  * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
  * Pearson Education, Inc. All Rights Reserved.                           *
  *                                                                        *
  * DISCLAIMER: The authors and publisher of this book have used their     *
  * best efforts in preparing the book. These efforts include the          *
  * development, research, and testing of the theories and programs        *
  * to determine their effectiveness. The authors and publisher make       *
  * no warranty of any kind, expressed or implied, with regard to these    *
  * programs or to the documentation contained in these books. The authors *
  * and publisher shall not be liable in any event for incidental or       *
  * consequential damages in connection with, or arising out of, the       *
  * furnishing, performance, or use of these programs.                     *
  *************************************************************************/