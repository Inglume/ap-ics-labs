/**
 * This is a class that tests the Card class.
 */
public class CardTester {

  /**
   * The main method in this class checks the Card operations for consistency.
   * 
   * @param args is not used.
   */
  public static void main(String[] args) {
    Card aceOfSpades = new Card("Ace", "Spades", 1);

    System.out.println("Rank: " + aceOfSpades.rank());
    System.out.println("Suit: " + aceOfSpades.suit());
    System.out.println("Point Value: " + aceOfSpades.pointValue());
    System.out.println(aceOfSpades);

    Card tenOfClubs = new Card("Ten", "Clubs", 10);

    System.out.println("Rank: " + tenOfClubs.rank());
    System.out.println("Suit: " + tenOfClubs.suit());
    System.out.println("Point Value: " + tenOfClubs.pointValue());
    System.out.println(tenOfClubs);

    Card fourOfDiamonds = new Card("Four", "Diamonds", 4);

    System.out.println("Rank: " + fourOfDiamonds.rank());
    System.out.println("Suit: " + fourOfDiamonds.suit());
    System.out.println("Point Value: " + fourOfDiamonds.pointValue());
    System.out.println(fourOfDiamonds);

    if (aceOfSpades.matches(fourOfDiamonds)) {
      System.out.println(aceOfSpades + " matches " + fourOfDiamonds);
    } else {
      System.out.println(aceOfSpades + " does not match " + fourOfDiamonds);
    }
    if (fourOfDiamonds.matches(tenOfClubs)) {
      System.out.println(fourOfDiamonds + " matches " + tenOfClubs);
    } else {
      System.out.println(fourOfDiamonds + " does not match " + tenOfClubs);
    }
    if (tenOfClubs.matches(aceOfSpades)) {
      System.out.println(tenOfClubs + " matches " + aceOfSpades);
    } else {
      System.out.println(tenOfClubs + " does not match " + aceOfSpades);
    }
  }
}
