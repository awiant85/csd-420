import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class AustinDataWriter {
    public static void main(String[] args) {
        Random rand = new Random();
        String filename = "Austin_datafile.dat";

        try (PrintWriter output = new PrintWriter(new FileWriter(filename, true))) {
            // Write 5 random integers
            output.print("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100); // Random int between 0-99
                output.print(randomInt + " ");
            }
            output.println();

            // Write 5 random doubles
            output.print("Doubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100; // Random double 0.0 to 99.9...
                output.printf("%.2f ", randomDouble);
            }
            output.println();
            output.println("-----");

            System.out.println("Data written to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
