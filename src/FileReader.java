import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files

public class FileReader {
    public String ReadFile(String target) {
        File myObj = new File(target);
        StringBuilder ans = new StringBuilder();
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ans.append(data).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Couldn't read the document");
        }
        return ans.toString();
    }
}
