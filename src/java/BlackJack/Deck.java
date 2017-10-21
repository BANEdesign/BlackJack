package BlackJack;

import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Deck {
    ArrayList<Card> cards;
    final static String[] cardValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"}; //TODO add face card values to Card

    public ArrayList createDeck(){

        cards = new ArrayList<Card>();

        for(int x = 0 ; x < 8 ; x++){   //This blackjack game will have 2 decks, thus 8, one for each suit

            for(String s : cardValues)

                cards.add(new Card(s));

        }
        shuffle(cards);

        return cards;
    }

    public Card dealCard(){
        if(cards.size() > 0){
            return cards.remove(0);
        }else{
            System.out.println("Deck is empty");
            return null;
        }
    }
    public Hand dealHand(int size){
        Hand hand = new Hand();

        for(int x = 0 ; x < size ; x++){
            hand.addCard(dealCard());
        }
        return hand;
    }

}
