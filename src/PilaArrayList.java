import java.util.ArrayList;

/**
 * Stack implementation using an ArrayList.
 *
 * @param <T> type of stored elements
 */
public class PilaArrayList<T> implements Collection<T> {

    private ArrayList<T> elements;

    /** Initializes the stack */
    public PilaArrayList() {
        this.elements = new ArrayList<>();
    }

    /** Pushes an element onto the stack */
    @Override
    public void push(T element) {
        elements.add(element);
    }

    /** Removes and returns the last element */
    @Override
    public T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    /** Returns the last element without removing it */
    @Override
    public T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }

    /** Checks if the stack is empty */
    @Override
    public boolean isEmpty(){
        return elements.isEmpty();
    }
}