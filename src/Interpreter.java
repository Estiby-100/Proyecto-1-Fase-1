import java.util.List;

public class Interpreter {

    private Collection<String> stack;

    public Interpreter(Collection<String> stack) {
        this.stack = stack;
    }

    public boolean execute(List<Token> tokens) {

        for (Token token : tokens) {

            if (token.getType() == TokenType.DATA) {
                stack.push(token.getData());
            }

            else if (token.getType() == TokenType.OPCODE) {
                boolean ok = executeOpCode(token.getOpCode());
                if (!ok) {
                    return false; // falla inmediata
                }
            }
        }

        // criterio de éxito
        String result = stack.peek();
        return result != null && !result.equals("0");
    }

    private boolean executeOpCode(OpCode op) {

        switch (op) {

            case OP_0:  stack.push("0");  return true;
            case OP_1:  stack.push("1");  return true;
            case OP_2:  stack.push("2");  return true;
            case OP_3:  stack.push("3");  return true;
            case OP_4:  stack.push("4");  return true;
            case OP_5:  stack.push("5");  return true;
            case OP_6:  stack.push("6");  return true;
            case OP_7:  stack.push("7");  return true;
            case OP_8:  stack.push("8");  return true;
            case OP_9:  stack.push("9");  return true;
            case OP_10: stack.push("10"); return true;
            case OP_11: stack.push("11"); return true;
            case OP_12: stack.push("12"); return true;
            case OP_13: stack.push("13"); return true;
            case OP_14: stack.push("14"); return true;
            case OP_15: stack.push("15"); return true;
            case OP_16: stack.push("16"); return true;

            case OP_DROP:
                String dropped = stack.pop();
                return dropped != null;

            case OP_DUP:
                String top = stack.peek();
                if (top == null) return false;
                stack.push(top);
                return true;

            case OP_EQUAL:
                String a = stack.pop();
                String b = stack.pop();
                if (a == null || b == null) return false;
                stack.push(a.equals(b) ? "1" : "0");
                return true;

            case OP_EQUALVERIFY:
                String x = stack.pop();
                String y = stack.pop();
                if (x == null || y == null) return false;
                if (!x.equals(y)) {     //Por temas de interaccion al pushear resultado de EQUAL
                    return false;
                }
                return true;
            
                case OP_HASH160:
                // Not implemented yet
                throw new UnsupportedOperationException("OP_HASH160 not implemented yet");
            
                case OP_CHECKSIG:
                // Not implemented yet
                throw new UnsupportedOperationException("OP_CHECKSIG not implemented yet");
            
                default:
                return false;
        }
    }
}

