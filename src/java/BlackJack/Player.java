package BlackJack;


public class Player {

    String name;
    Hand hand;
    int points;
    int bet;


    public Player(String name, int points){
        this.name = name;
        this.points = points;
    }
    // add methods to bet, add/remove points, hit, stay
    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void placeBet(int bet){
        //There must be a min and max bet, max should be their total points currently
        if (!(bet > 0) && (bet <= points)) {
            System.out.println("Enter a bet between 1 and your max number of points");

        }else{
            this.points = points - bet;
            displayPoints();
        }
    }
    public int getBet(){ return bet; }

    public void addPoints(int bet){
        this.points = points + bet;
    }
    public void removePoints(int bet){
        this.points = points-bet;
    }
    public void displayPoints(){
        System.out.println("Points: " + points);
    }

}
