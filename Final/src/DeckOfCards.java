// Class 3/7
import java.util.ArrayList;
import static java.util.Collections.shuffle;

public class DeckOfCards {

        //attribute
        protected ArrayList<Card> deck = new ArrayList<>(); //the deck (useful in a card game)

        //creating a deck of cards (Notes : For this game I only need 32 cards and not 52)
        public DeckOfCards() {

                //Creating my 32 cards and adding them to the deck
                int i = 7;
                int p = 0;
                while (i <= 14) {
                        Card c = new Card(i, Card.Suit.Spades, p);
                        c.toString();
                        deck.add(c);
                        i++;
                        p++;
                }
                int j = 7;
                while (j <= 14) {
                        Card c = new Card(j, Card.Suit.Hearts, p);
                        c.toString();
                        deck.add(c);
                        j++;
                        p++;
                }
                int k = 7;
                while (k <= 14) {
                        Card c = new Card(k, Card.Suit.Diamonds, p);
                        c.toString();
                        deck.add(c);
                        k++;
                        p++;
                }
                int l = 7;
                while (l <= 14) {
                        Card c = new Card(l, Card.Suit.Clubs, p);
                        c.toString();
                        deck.add(c);
                        l++;
                        p++;
                }

                //printing my deck
                System.out.println("my deck is: " + deck);

                //now SHUFFLING my deck (really important to make each game different and enjoyable !)
                shuffle(deck);
        }

        public int getRankDeck(int rd){
                return deck.get(rd).getRank();
        }

        public Card.Suit getSuitDeck(int sd){
                return deck.get(sd).getSuit();
        }

        public int getImgDeck(int id){
                return deck.get(id).getImg();
        }

        public ArrayList<Card> toPrint(){
                return deck;
        }
}