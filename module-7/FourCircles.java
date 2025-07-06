// Austin Wiant
// July 5, 2025
// Module 7 Programming Assignment
// Purpose: Display four styled circles using an external CSS file.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FourCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create four circles
        Circle circle1 = new Circle(50);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);

        // Apply style class and IDs
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // Add to layout
        HBox root = new HBox(20); // space between circles
        root.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Create scene and apply CSS
        Scene scene = new Scene(root, 400, 120);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
