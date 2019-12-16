import javafx.scene.image.Image;

public class Card implements Suits {

    private suits suitValue;
    private Rank cardRank;
    private Image cardImage;

    public Card (suits suits, Rank rank, Image cardFace){
        suitValue = suits;
        cardRank = rank;
        cardImage = cardFace;
    }
    public Rank getRank() {
        return cardRank;
    }

    public static String getFilename(Rank rank , suits suits ) {
        return "file:src/resources/cards/"+rank.getValue() + suits.name() + ".gif";
    }

    public int getValue() {
        String rank = cardRank.getValue();
        try{
           return Integer.parseInt(rank);
        } catch (Exception ex){
            if(rank.equals("e")){
                return 11;
            } else {
                return 10;
            }
        }
    }
    public Image getCardImage() {

        return cardImage;
    }

    @Override
    public String toString() {
        return cardRank.toString() + " of " + suitValue;
    }
}

