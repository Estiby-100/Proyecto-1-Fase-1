import java.util.Arrays;

/**
 * Represents a script token (either data or opcode).
 */
public class Token {

    private final TokenType type;
    private final OpCode opCode;   
    private final byte[] data;     

    /** Private constructor */
    private Token(TokenType type, OpCode opCode, byte[] data) {
        this.type = type;
        this.opCode = opCode;
        this.data = data;
    }

    /** Creates an opcode token */
    public static Token opcode(OpCode op) {
        return new Token(TokenType.OPCODE, op, null);
    }

    /** Creates a data token */
    public static Token data(byte[] data) {
        return new Token(TokenType.DATA, null, data);
    }

    public TokenType getType() {
        return type;
    }

    public OpCode getOpCode() {
        return opCode;
    }

    public byte[] getData() {
        return data;
    }

    /** String representation of the token */
    @Override
    public String toString() {
        return (type == TokenType.DATA) ? "DATA(" + Arrays.toString(data) + ")" : opCode.name();
    }
}