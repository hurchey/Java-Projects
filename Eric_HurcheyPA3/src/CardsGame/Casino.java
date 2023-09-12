/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 10/14/2022
 * PA3
 * This part of the program runs the whole game from start to end while implementing the other java files. The game that is created 
 * here is like a basic casino game. You can choose how much money you want to start with and how much you want to initially wager. 
 * After every round you can either cashout the amount of money you have or you can go again and have a new wager if you would like.
 * The game does not end until you have either said you wished to exit or you have no more money left and you gambled it all away. It also
 * takes into account small errors such as if you were to wager more money than you have, wager a negative amount of money and input a 
 * money value that is not rational.
 * Known Bugs: The only known bug is that if you were to type a string but not and integer, the program will not run at all and say
 * that there is a error within the program. But other than that, no known bug. 
 */

package CardsGame;
import java.util.*;
public class Casino {

	static int Money;
	static int Wager;
	
	/**
	 * This method reads the game input of values and calculates what new values should be inputed next
	 * The method returns different values, if you wish to wish to exit the game, if you wish to wager more or less
	 * This method takes into account the possible outcomes if the card that you drew is bigger, smaller, or similar in value
	 */
	
	public static void game(Deck deck) {
		while (Money > 0 && Wager >= 1 ) {
			Scanner console = new Scanner(System.in);
			Card compCard = deck.drawNextCard();
			System.out.println("Computer starting card: " + compCard.toString());
			Card userCard = deck.drawNextCard();
			System.out.println("Your starting card: " + userCard.toString());
			if (userCard.Value > compCard.Value) {
				Money += Wager;
			}	else if (compCard.Value > userCard.Value) {
				Money -= Wager;
			}	else {
				System.out.println("There was a tie...");
			}
			System.out.println("Your new money value is: " + Money);
			System.out.println("Running the game back...");
			System.out.print("New wager?: ");
			Wager = console.nextInt();
		if (Money <= 0) {
			System.out.println("YOU LOSE! GAME OVER!");
		}
		if (Wager == 0) {
			System.out.println("GOOD GAME!");
			System.out.println("I hope you enjoyed Eric's Casino!");
			System.out.println("Your money value is: " + Money);
		}	else if (Wager <= -1){
			console = new Scanner(System.in);
			System.out.println("ERROR");
			System.out.println("You cannot have a negative wager...");
			System.out.println("Wager a positive number: ");
			Wager = console.nextInt();
		}	else if (Wager > Money) {
			console = new Scanner(System.in);
			System.out.println("ERROR");
			System.out.println("You cannot wager more money than you have...");
			System.out.print("Please input a reasonable wager: ");
			Wager = console.nextInt();
		}
		}
	}	
	
	/**
	 * This method is the main function that runs out the whole program from start to end. 
	 * It gives error messages when you give a wager higher than the money you wan to start with.
	 * It gives error messages when you give a wager or a money value that's not rational.
	 * This is where you can input the amount of money that you want to start with and your initial wager
	 */
	
	public static void main(String[] arg) {
		Scanner console = new Scanner (System.in);
		System.out.println("Welcome to Eric's Casino!");
		System.out.println("If you wish to cash out at any point in the game, wager 0");
		Deck deck = new Deck();
		System.out.print("How much money do you want to start with?: ");
		Money = console.nextInt();
		while(Money <= 0) {
			System.out.println("ERROR");
			System.out.println("You cannot start with no money...");
			System.out.print("Please input a positive starting amount: ");
			Money = console.nextInt();
		}
		System.out.print("How much money do you want to wager?: ");
		Wager = console.nextInt();
		if (Wager <= 0) {
			System.out.println("ERROR");
			System.out.println("You cannot wager that amount...");
			System.out.print("Please input a positive wager: ");
			Wager = console.nextInt();
		}
		while(Wager > Money) {
			System.out.println("ERROR");
			System.out.println("You cannot wager more money than you have...");
			System.out.print("Please input a reasonable wager: ");
			Wager = console.nextInt();
		}
		System.out.println("Time for the real game to start...");
		game(deck);
		
	}
}
