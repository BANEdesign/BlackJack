package BlackJack;
import java.util.ArrayList;

import static input.InputUtils.*;

public class blackJack {
    static Player player;
    static Dealer dealer;
    static Deck deck;
    static Card card;
    static int handSize = 2;

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.createDeck();

        String playerName = stringInput("Enter your name"); //ask for name
        Player p = new Player(playerName, 300); //give points
        p.setHand(deck.dealHand(handSize));

        Dealer d = new Dealer("Dealer", 0);
        d.setHand(deck.dealHand(handSize));

        gamePlay(p, d);
    }
        //gamePlay should be while statement with boolean playAnotherHand yes/no input
        public static void gamePlay(Player p, Dealer d){
                                                                    //TODO sort out ace 1 or 11
        while(playAnotherHand()){
            System.out.println("Your points: " );
            p.displayPoints();
            int bet = intInput("Place your bet, enter number of points you wish to bet.");
            p.placeBet(bet);


            //Display cards, only show one card from dealer's hand
            System.out.println(String.format("%s 's cards are :",p.name));
            p.hand.displayHand(p.hand.cards);
            System.out.println("Dealer's 'face-up' card is: ");
            System.out.println(d.dealersFaceUpCard(d.hand.cards));

            //when player and dealer receive cards
            //check for blackJack boolean isBlackJack
            ArrayList<Integer> intCards = new ArrayList<>();
            if(!(p.hand.isBlackJack(p.hand.cards) && !(d.hand.isBlackJack(d.hand.cards)))){
                if(wantsToHit()){
                    p.hand.hit();
                    for(Card c : p.hand.cards){ //TODO this really needs to be a method in a class
                        intCards.add(c.cardsToNumbers(c.value));
                        p.hand.countHand(intCards);
                        dealer.compareHands();
                    }
                }else{
                    d.dealerMoves();
                    dealer.compareHands();
                }

            }else if(p.hand.isBlackJack(p.hand.cards)){
                p.addPoints(p.bet);
                p.displayPoints();
            }else if(d.hand.isBlackJack(d.hand.cards)){
                d.addPoints(p.bet);
                d.displayPoints();
            }else{
                playAnotherHand(); //TODO this needed?
            }


        }
    }







        //get total of cards in hand ( cardsToNumbers(card), countHand(arrayList intcards)
        //ask player for hit boolean hit yes/noInput
        //check for bust boolean bust (check for bust after each hit(method hit() has check built-in), not necessary for initial deal) int cardCount = coundHand(hand)


        //when user stays make dealer turn:
        //display dealer hand
        //get total of cards in hand ( cardsToNumbers(card), countHand(arrayList intcards)

        //make method that checks if dealer hand >17
        //if yes, dealer stands ( compare hands to see who wins )
        //if no, dealer hits (re-use hit() method, change sout) if dealer looses, give player points
        //make compare hands method check to see who wins round
    public static boolean wantsToHit(){ return yesNoInput("Would you like to hit?"); }

    public static boolean playAnotherHand(){return yesNoInput("Would you like to play another Hand?");}
}
