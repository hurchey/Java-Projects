/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 10/14/2022
 * PA3
 * This part of the whole java program should be checking the cards and it's values and suits.
 * Known Bugs: There are no known bugs with this part of the PA. All of the methods in this part of this program work as intended.
 */

package CardsGame;
public class Card {
//	Global variables for this class
	int Value;
	String Suit;

	public Card (int Value, String Suit) {
		this.Value = Value;
		this.Suit = Suit;
	}
	public int getValue() {
		return Value;
	}
	public String getColor() {
		String color = "";
		if (Suit.equals("Hearts") || Suit.equals("Diamonds")) {
			color += "Red";
		}
		else if (Suit.equals("Spades") || Suit.equals("Clubs")) {
			color += "Black";
		}
		return color;
	}
	public String getSuit() {
		return this.Suit;
	}
	public String toString() {
		String answer = "";
		if (Value == 1) {
			answer += "Ace of " + Suit;
		} else if (Value == 13) {
			answer += "Kings of " + Suit;
		} else if (Value == 12) {
			answer += "Queens of " + Suit;
		} else if (Value == 11) {
			answer += "Jack of " + Suit;
		} else {
			answer += Value + " of " + Suit;
		}
		return answer;
	}
}
