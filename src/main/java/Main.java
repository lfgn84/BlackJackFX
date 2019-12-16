import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
   // public static void main(String[] args) throws InterruptedException {
       // Model model = new Model();
       // Deck deck = new Deck();
        //Controller controller = new Controller(model, deck);
       // controller.start();

    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Blackjack.fxml"));
        Model model = new Model();
        Deck deck = new Deck();
        loader.setControllerFactory(param -> new fxmlController(model,deck));
        Parent root = loader.load();

        fxmlController controller = loader.getController();

        primaryStage.setTitle(" Black Jack ");
        primaryStage.setScene(new Scene(root));

        primaryStage.sizeToScene();
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
