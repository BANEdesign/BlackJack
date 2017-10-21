package BlackJack;

public class Card {

    String value;


    final static String ACE = "A";
    final static String JACK = "J";
    final static String QUEEN = "Q";
    final static String KING = "K";

    //Constructor for face cards
    public Card(String value){this.value = value;}

    public int cardsToNumbers(String cardValue){
        //converts strings to numbers to that they can be calculated


            if  (cardValue.matches(JACK) || cardValue.matches(QUEEN) || cardValue.matches(KING)){
                return 10;
            }else if(cardValue.matches(ACE)){
                return 11;
            }else{
                return Integer.parseInt(cardValue);
            }
    }
    public String getValue(){return this.value;} //TODO might not need this

}
