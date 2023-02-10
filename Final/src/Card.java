// Class 2/7
public class Card {

    //attributes
    private final int rank; //rank of a card
    private final Suit suit; //suit of a card
    private String realrank; //Jacket = 11, Queen = 12, etc...
    private final int img; //number of a card (only way that I found to associate an image to a card)
    public enum Suit { Spades, Hearts, Diamonds, Clubs } //the Suits


    //creating a card
    public Card(int rank, Suit suit, int img) {
        if(rank < 7 || rank > 14) {
            System.out.println("rank has to be between 7 and 14");
        }
        this.rank = rank;
        this.suit = suit;
        this.img = img;
    }

    //getters
    public int getRank(){
        return rank;
    }
    public Suit getSuit(){
        return suit;
    }
    public String getRealrank(){
        return realrank;
    }
    public int getImg(){
        return img;
    }

    //setters (I deleted the setters that I don't need)
    public void setRealrank(){
        if (rank == 7){
            this.realrank = "7";
        } else if (rank == 8){
            this.realrank = "8";
        } else if (rank == 9){
            this.realrank = "9";
        } else if (rank == 10){
            this.realrank = "10";
        } else if (rank == 11){
            this.realrank = "Jack";
        } else if (rank == 12){
            this.realrank = "Queen";
        } else if (rank == 13){
            this.realrank = "King";
        } else if (rank == 14){
            this.realrank = "Ace";
        }
    }

    //to String
    public String toString(){
        this.setRealrank();
        return (realrank + " of " + suit + " (" + img + ") ");
    }
}