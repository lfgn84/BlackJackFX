import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javax.annotation.security.RunAs;
import java.beans.EventHandler;
import java.io.File;
import java.util.List;

public class fxmlController {

    @FXML
    public Button Stay = new Button();
    @FXML
    public Button Hit = new Button();
    @FXML
    public Button Bet = new Button();
    @FXML
    public Button Reset = new Button();

    public boolean stayed = false;


    FlowPane playerSp = new FlowPane(Orientation.HORIZONTAL);

    FlowPane dealerSp = new FlowPane(Orientation.HORIZONTAL);
    @FXML
    GridPane Table = new GridPane();
    Label totalLabel = new Label();
    Label totalLabelDealer = new Label();

    Label dealerLbl = new Label("Dealer Hand");
    Label playerLbl = new Label("Your Hand");

    Model model;
    Deck deck;
    View view = new View();
    int dealerHandValue;
    int playerHandValue;


    public fxmlController(Model model, Deck deck) {
        this.model = model;
        this.deck = deck;
    }

    public void initialize() throws InterruptedException {

        Table.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        Table.setHgap(5.5);
        Table.setVgap(5.5);

        firstDrawFX();
        calculateDealerScore();
        calculatePlayerScore();


        System.out.println(playerHandValue);
        System.out.println(dealerHandValue);
        System.out.println(model.playerCards);

        if (playerHandValue == 21 || playerHandValue > 21) {
            Stay.setDisable(true);
            Hit.setDisable(true);
        }
        if (playerHandValue > dealerHandValue && playerHandValue <= 21 || dealerHandValue < 21) {

        }


    }


    public void firstDrawFX() {
        model.dealerCards.add(deck.drawCard());
        model.playerCards.add(deck.drawCard());
        model.playerCards.add(deck.drawCard());
        ImageView imgDealer = new ImageView(model.dealerCards.get(0).getCardImage());
        dealerSp.getChildren().add(imgDealer);
        ImageView imgPlayer1 = new ImageView(model.playerCards.get(0).getCardImage());
        playerSp.getChildren().add(imgPlayer1);
        ImageView imgPlayer2 = new ImageView(model.playerCards.get(1).getCardImage());
        playerSp.getChildren().add(imgPlayer2);

        Table.add(dealerSp, 1, 0);
        Table.add(playerSp, 0, 2, 1, 2);
    }

    public void hitButtonAction() {

        model.playerCards.add(deck.drawCard());

        ImageView imgPlayer = new ImageView(model.playerCards.get(model.playerCards.size() - 1).getCardImage());
        playerSp.getChildren().add(imgPlayer);
        Table.add(playerSp, model.playerCards.size() - 1, 2);

        calculatePlayerScore();
    }

    public void stayButtonAction() {
        Hit.setDisable(true);
        do {
            model.dealerCards.add(deck.drawCard());
            ImageView imgDealer = new ImageView(model.dealerCards.get(model.dealerCards.size() - 1).getCardImage());
            dealerSp.getChildren().add(imgDealer);
            Table.add(dealerSp, model.dealerCards.size() + 0, 0);
            calculateDealerScore();
        } while (dealerHandValue < 17);

        calculatePlayerScore();
    }

    public void resetGame() {
        playerHandValue = 0;
        dealerHandValue = 0;
        model.getDealerCards().clear();
        model.getPlayerCards().clear();
        deck.newDeck();
        Table.getChildren().clear();
        Hit.setDisable(false);
    }


    public int calculateTotal(List<Card> cardList, Card card) {
        int summa = 0;
        for (Card card1 : cardList) {
            summa = summa + card1.getValue();
        }
        return checkAce(summa, cardList);
    }

    public int checkAce(int total, List<Card> cardList) {

        for (Card card : cardList) {
            if (card.getRank() == Rank.ESS)
                if (total >= 21) {
                    total = total - 10;
                }
        }
        return total;
    }

    public void calculatePlayerScore() {
        playerHandValue = calculateTotal(model.getPlayerCards(), model.getPlayerCards().get(model.getPlayerCards().size() - 1));
    }

    public void calculateDealerScore() {
        dealerHandValue = calculateTotal(model.getDealerCards(), model.getDealerCards().get(model.getDealerCards().size() - 1));
    }


}
