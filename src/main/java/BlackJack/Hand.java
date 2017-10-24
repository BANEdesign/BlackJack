package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;

import static BlackJack.blackJack.dealer;
import static BlackJack.blackJack.player;

public class Hand {
    //add variables
    ArrayList<Card> cards;
    //constructor
    public Hand(){
        cards = new ArrayList<Card>();
    }
    //add methods
    //call check for face card if hasFaceCards(cardValue) call faceCardsToNumbers(String cardValue)
    // getHandNumbers
    // to get int value
    //add calculate hand

    public boolean isBust(int cardCount){
        if(cardCount > 21)
            return true;
        else
            return false;
    }

    public boolean isBlackJack(ArrayList<Card> cards) {
        boolean blackJack;
            if (cards.contains("A") && cards.contains("J") || cards.contains("Q") || cards.contains("K") || cards.contains("10")) {
                System.out.println("BlackJack");
                blackJack = true;
            } else {
                blackJack = false;
            }
        return blackJack;
    }

    public int countHand(ArrayList<Integer> intCards){

        int sum = 0;
        for(int card : intCards){
            sum += card;
        }
        return  sum;
    }

    public void displayHand(ArrayList<Card> cards){
        ArrayList<String> hand = new ArrayList<>();
        String str;
        for(Card c : cards) {
            str = c.value.toString();
            hand.add(str);
        }
        System.out.println(Arrays.toString(hand.toArray()));
        hand.clear();
    }

    public void addCard(Card card){

        cards.add(card);

    }
    public void hit(ArrayList<Card> cards){
        int cardCount;
        ArrayList<Integer> intCards = new ArrayList<>();

        for(Card card : cards){
            intCards.add(card.cardsToNumbers(card.value)); //changes cards in hand to numbers and adds them to intCards
        }
        cardCount = countHand(intCards);

        if(isBust(cardCount)){
            System.out.println("BUST! You lose");  //TODO add end of round
            dealer.addPoints(player.bet);
            player.displayPoints();

        }else{
            System.out.println("Player chooses to stay");
            displayHand(cards);
            dealer.dealerMoves();   //Becomes dealer's turn
        }
        intCards.clear();
    }
    public Card getCard(int index){
        return cards.get(index);
    }
    public void addAllCardstoList(ArrayList<Card> cardsToAdd){
        for(Card card : cardsToAdd){
            cards.add(card);
        }
    }
}
