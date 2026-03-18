import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;             

/**
 * Utility class for reading text files.
 */
public class FileReader {

    /**
     * Reads a file and returns its content as a String.
     *
     * @param target file path
     * @return file content as a single string
     */
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