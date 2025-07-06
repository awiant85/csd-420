// Name: Austin Wiant
// Date: July 6, 2025
// Assignment: Module 5 – ThreeThreads Multithreading Program

// Purpose: This program uses three separate threads to output 10,000 random letters,
// digits, and special characters to a JavaFX TextArea.

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class AustinThreeThreads extends Application {

    // Constant for number of characters each thread should generate
    private static final int CHARACTER_COUNT = 10000;

    // TextArea to display all output
    private final TextArea outputArea = new TextArea();

    @Override
    public void start(Stage stage) {
        // Setup UI
        outputArea.setWrapText(true);

        VBox root = new VBox(outputArea);
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Three Threads Output");
        stage.setScene(scene);
        stage.show();

        // Start all character output threads
        new Thread(new RandomLetterTask()).start();
        new Thread(new RandomDigitTask()).start();
        new Thread(new RandomSymbolTask()).start();
    }

    // Thread 1: Generates random lowercase letters
    class RandomLetterTask implements Runnable {
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char letter = (char) ('a' + random.nextInt(26));
                appendCharacterToUI(letter);
            }
        }
    }

    // Thread 2: Generates random digits from 0–9
    class RandomDigitTask implements Runnable {
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char digit = (char) ('0' + random.nextInt(10));
                appendCharacterToUI(digit);
            }
        }
    }

    // Thread 3: Generates random symbols from a preset list
    class RandomSymbolTask implements Runnable {
        private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};

        public void run() {
            Random random = new Random();
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char symbol = symbols[random.nextInt(symbols.length)];
                appendCharacterToUI(symbol);
            }
        }
    }

    // This method safely appends a character to the TextArea using the JavaFX thread
    private void appendCharacterToUI(char character) {
        Platform.runLater(() -> outputArea.appendText(String.valueOf(character)));
    }

    public static void main(String[] args) {
        launch(args);  // Launch JavaFX application
    }
}
