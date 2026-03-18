import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class InterpreterStackTest {

    private boolean run(String script) {
        Collection<byte[]> stack = new PilaArrayList<>();
        Interpreter interp = new Interpreter(stack, false);
        return interp.execute(new Parser().parse(script));
    }

    private Collection<byte[]> runAndGetStack(String script) {
        Collection<byte[]> stack = new PilaArrayList<>();
        Interpreter interp = new Interpreter(stack, false);
        interp.execute(new Parser().parse(script));
        return stack;
    }

    @Test
    void opDup_duplicatesTop() {
        Collection<byte[]> stack = runAndGetStack("DATA:5 OP_DUP");
        assertArrayEquals(new byte[]{5}, stack.peek());
        stack.pop();
        assertArrayEquals(new byte[]{5}, stack.peek());
    }

    @Test
    void opDup_emptyStack_returnsFalse() {
        assertFalse(run("OP_DUP"));
    }

    @Test
    void opDrop_removesTop() {
        Collection<byte[]> stack = runAndGetStack("DATA:5 DATA:3 OP_DROP");
        assertArrayEquals(new byte[]{5}, stack.peek());
    }

    @Test
    void opSwap_swapsTopTwoElements() {
        Collection<byte[]> stack = runAndGetStack("DATA:2 DATA:1 OP_SWAP");
        assertArrayEquals(new byte[]{2}, stack.peek());
        stack.pop();
        assertArrayEquals(new byte[]{1}, stack.peek());
    }

    @Test
    void opOver_copiesSecondElementToTop() {
        Collection<byte[]> stack = runAndGetStack("DATA:1 DATA:2 OP_OVER");
        assertArrayEquals(new byte[]{1}, stack.peek());
    }
}