import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AustinDataReader {
    public static void main(String[] args) {
        String filename = "Austin_datafile.dat";

        try (Scanner input = new Scanner(new File(filename))) {
            System.out.println("Reading data from " + filename + ":");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + filename + " was not found.");
            e.printStackTrace();
        }
    }
}
