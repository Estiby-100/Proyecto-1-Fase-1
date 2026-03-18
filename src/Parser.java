import java.util.ArrayList;
import java.util.List;

/**
 * Parses script text into tokens.
 */
public class Parser {

    /** Converts full script text into a list of tokens */
    public List<Token> parse(String scriptText) {
        List<Token> tokens = new ArrayList<>();

        if (scriptText == null || scriptText.trim().isEmpty()) {
            return tokens;
        }

        String[] parts = scriptText.trim().split("\\s+");

        for (String part : parts) {
            tokens.add(parseWord(part));
        }

        return tokens;
    }

    /** Converts a single word into a token */
    private Token parseWord(String word) {

        if (word.startsWith("DATA:")) {
            String value = word.substring("DATA:".length());
            return Token.data(decimalToBytes(value));
        }

        try {
            OpCode op = OpCode.valueOf(word);
            return Token.opcode(op);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Unknown token: " + word);
        }
    }

    /** Converts a decimal string to a byte (0–255) */
    private byte[] decimalToBytes(String decimal) {
        int value = Integer.parseInt(decimal);

        if (value < 0 || value > 255) {
            throw new IllegalArgumentException("Decimal out of range (0-255)");
        }

        return new byte[]{ (byte) value };
    }
}