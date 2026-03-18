import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class InterpreterPushTest {

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
    void op5_pushes5OntoStack() {
        Collection<byte[]> stack = runAndGetStack("OP_5");
        assertArrayEquals(new byte[]{5}, stack.peek());
    }

    @Test
    void op5_executeReturnsTrueWhenTopIsNonZero() {
        assertTrue(run("OP_5"));
    }
}