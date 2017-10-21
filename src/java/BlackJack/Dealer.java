package BlackJack;

import java.util.ArrayList;

import static BlackJack.blackJack.dealer;
import static BlackJack.blackJack.player;

public class Dealer extends Player {

    public Dealer(String name, int points) {
        super(name, points);
    }
    //dealerMoves makes hit/stay decisions for dealer(Computer)
    //display hand

    //count hand
    //if yes, dealer stands ( compare hands to see who wins )
    //if no, dealer hits (re-use hit() method, change sout) if dealer looses, give player points
    //make compare hands method check to see who wins round

    public void dealerMoves() {
        ArrayList<Integer> tempList = new ArrayList<>();


        this.hand.displayHand(hand.cards);
        for (Card card : hand.cards) {
            tempList.add(card.cardsToNumbers(card.value)); //turn string cards to int
        }
        int handCount = this.hand.countHand(tempList);
        while (handCount <= 21)
            if (handCount > 17) {
                //add method to compare hands to see who wins
                break;
            } else if (handCount == 21) {
                System.out.println("Dealer wins!" + "\n" + "Dealer takes bet");
                int playersBet = player.getBet();
                player.removePoints(playersBet);
                this.addPoints(playersBet);
                break;
            } else {
                this.hand.hit();
            }
        tempList.clear();
    }

    public void compareHands() {
        ArrayList<Integer> dealerHand = new ArrayList<>(); //TODO add method somewhere that does this function
        ArrayList<Integer> playerHand = new ArrayList<>();

        this.hand.displayHand(hand.cards);

        for (Card card : hand.cards) {
            dealerHand.add(card.cardsToNumbers(card.value)); //turn string cards to int
        }
        int dealerHandCount = this.hand.countHand(dealerHand);

        player.hand.displayHand(hand.cards);

        for (Card c : hand.cards) {
            playerHand.add(c.cardsToNumbers(c.value));
        }
        int playerHandCount = player.hand.countHand(playerHand);

        if (playerHandCount > dealerHandCount) {
            System.out.println(player.name + " Wins " + player.bet);
            player.addPoints(player.bet);

        } else if (playerHandCount < dealerHandCount) {                 //TODO prompt end of round ask user playAnotherHand?
            System.out.println("Dealer Wins " + player.bet);
            player.removePoints(player.bet);  //TODO check to see if this is necessary, doesn't bet get removed once placed?
            dealer.addPoints(player.bet);

        } else {
            System.out.println("Dealer's hand is equal to " + player.name + "'s hand " + "\n" + "SPLIT!");
            int pot = player.bet / 2;
            player.addPoints(pot);       //split the pot
            dealer.addPoints(pot);
        }
    }

    public String dealersFaceUpCard(ArrayList<Card> cards) {
        ArrayList<String> hand = new ArrayList<>(); //TODO this could be made in a more simple way
        String str;
        for (Card c : cards) {
            str = c.value.toString();
            hand.add(str);
        }
        return hand.get(0);
    }
}
