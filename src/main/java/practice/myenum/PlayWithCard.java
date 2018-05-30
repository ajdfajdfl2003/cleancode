package practice.myenum;

public class PlayWithCard {
    public static void main(String[] args) {
        Card heartsCard = new Card(CardValue.ACE, Suit.HEARTS);

        System.out.println(heartsCard.getCardValue().getCardValue());
        System.out.println(heartsCard.getSuit());
    }
}
