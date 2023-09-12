/**
 * Eric Hurchey
 * erichurchey@brandeis.edu
 * 10/14/2022
 * PA3
 * This part of the whole java program should be checking the deck and shuffle them and putting the pulled card into a discard pile,
 * drawing a random card from the deck, having a random deck every time, and sets up a discard pile for the card that you drew or
 * the computer drew to be put into.
 * Known Bugs: There are no known bugs with this part of the PA. All of the methods in this part of this program work as intended.
 */

package CardsGame;
import java.util.*;

public class Deck {
//	Global variables for this class
	Card[] deck;
	Card[] discard;
	int count;
	
	/**
	 * This method creates a deck and shuffles it when there are no cards left
	 * @param it has no parameters
	 * @return this method returns the deck when it has been shuffled and no cards are left in the deck
	 */
	
	public Deck(){
		this.deck = new Card[52];
		int index = 0;
		for (int i = 1; i < 14; i++) {
			deck[index] = new Card (i, "Hearts");
			index++;
		}
		for (int i = 1; i < 14; i++) {
			deck[index] = new Card (i, "Spades");
			index++;
		}
		for (int i = 1; i < 14; i++) {
			deck[index] = new Card (i, "Clubs");
			index++;
		}
		for (int i = 1; i < 14; i++) {
			deck[index] = new Card (i, "Diamonds");
			index++;
		}
		shuffle();
		this.discard = new Card[52];
		this.count = 0;
	}
	/**
	 * This method creates a way to shuffle all of the cards in the deck a creates a completely new random deck.
	 */
	public void shuffle(){
		int max = deck.length - 1;
		Random ran = new Random();
		int n = 0;
		for (int i = max; i > 0; i--) {
			n = ran.nextInt(max);
			Card temp = deck[n];
			deck[n] = deck[i];
			deck[i] = temp;
			max--;
		}
	}
/**
 * This method draws the next card in a random deck
 * @return it returns the new card that is drawn from the deck at that moment
 */
	public Card drawNextCard(){
		Card rightnow = deck[count];
		discard(rightnow);
		if (count == 51){
			deck = discard.clone();
			this.discard = new Card[52];
			shuffle();
			count = 0;
			return rightnow;
		}
		else {
			count++;
			return rightnow;
		}
	}
	
//	This just creates a discard method
	public void discard(Card c){
		this.discard[count] = c;
	}
}
