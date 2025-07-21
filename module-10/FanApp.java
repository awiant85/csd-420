// Name: Austin Wiant - July 20, 2025 - Assignment: Module 4 - Fan Info Viewer/Updater
// Purpose: A JavaFX app that displays and updates fan records in a MySQL database

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class FanApp extends Application {
    // Input fields for user interaction
    TextField idField = new TextField();
    TextField firstNameField = new TextField();
    TextField lastNameField = new TextField();
    TextField teamField = new TextField();
    Label messageLabel = new Label();

    // Database connection info
    final String URL = "jdbc:mysql://localhost:3306/databasedb";
    final String USER = "student1";
    final String PASS = "pass";

    public static void main(String[] args) {
        launch(args); // Start the JavaFX application
    }

    @Override
    public void start(Stage stage) {
        // Build UI layout using GridPane and VBox
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        // Add labels and text fields
        grid.add(new Label("ID:"), 0, 0); grid.add(idField, 1, 0);
        grid.add(new Label("First Name:"), 0, 1); grid.add(firstNameField, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2); grid.add(lastNameField, 1, 2);
        grid.add(new Label("Favorite Team:"), 0, 3); grid.add(teamField, 1, 3);

        // Create and add buttons
        Button displayBtn = new Button("Display");
        Button updateBtn = new Button("Update");
        HBox buttons = new HBox(10, displayBtn, updateBtn);

        // Set button actions
        displayBtn.setOnAction(e -> displayFan());
        updateBtn.setOnAction(e -> updateFan());

        // Wrap everything in a vertical layout and display it
        VBox root = new VBox(10, grid, buttons, messageLabel);
        stage.setScene(new Scene(root, 350, 250));
        stage.setTitle("Fan Info");
        stage.show();
    }

    // Display fan info by ID from the database
    void displayFan() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            int id = Integer.parseInt(idField.getText());

            // Prepare SQL query to retrieve fan by ID
            String sql = "SELECT * FROM fans WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // If fan exists, fill in the fields
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
                messageLabel.setText("Fan found.");
            } else {
                messageLabel.setText("No fan with ID " + id);
            }
        } catch (Exception ex) {
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }

    // Update fan record in the database
    void updateFan() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            int id = Integer.parseInt(idField.getText());

            // Prepare SQL statement to update fan data
            String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, teamField.getText());
            stmt.setInt(4, id);

            // Execute update and show result
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                messageLabel.setText("Update successful.");
            } else {
                messageLabel.setText("Update failed.");
            }
        } catch (Exception ex) {
            messageLabel.setText("Error: " + ex.getMessage());
        }
    }
}
