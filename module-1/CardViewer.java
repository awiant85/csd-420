// Name: Austin Wiant | Date: June 1, 2025 | Assignment: Module 1 – JavaFX Card Viewer
// Purpose: Display four random playing cards from a set of 52 using JavaFX. Clicking "Refresh" loads new random cards.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class CardViewer extends Application {

    // Horizontal box to hold the card images
    private HBox cardDisplayBox = new HBox(10);

    @Override
    public void start(Stage stage) {
        // Align card display box to center
        cardDisplayBox.setStyle("-fx-alignment: center");

        // Create the refresh button with lambda to reload cards
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> showRandomCards());

        // Vertical layout to hold the card box and refresh button
        VBox layout = new VBox(20, cardDisplayBox, refreshButton);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20");

        // Display the first set of cards
        showRandomCards();

        // Create and show the scene
        Scene scene = new Scene(layout, 600, 350);
        stage.setTitle("Card Viewer");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Randomly selects 4 card images from the cards/ directory and displays them
     */
    private void showRandomCards() {
        // Clear any existing cards from the display box
        cardDisplayBox.getChildren().clear();

        // Create a list of card numbers 1 through 52
        ArrayList<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cardNumbers.add(i);
        }

        // Shuffle the list to randomize the card order
        Collections.shuffle(cardNumbers);

        // Load and display the first 4 shuffled cards
        for (int i = 0; i < 4; i++) {
            String imagePath = "cards/" + cardNumbers.get(i) + ".png";
            Image cardImage = new Image(imagePath);
            ImageView cardView = new ImageView(cardImage);
            cardView.setFitHeight(150);
            cardView.setPreserveRatio(true);
            cardDisplayBox.getChildren().add(cardView);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
