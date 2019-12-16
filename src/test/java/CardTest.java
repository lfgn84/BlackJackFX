import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class CardTest {
    private Card card;

   // @Test
    void testRank(){
        card = new Card(Suits.suits.HEARTS, Rank.ESS,  new Image(Card.getFilename(Rank.ESS, Suits.suits.HEARTS)));
        System.out.println(card);
    }
}
