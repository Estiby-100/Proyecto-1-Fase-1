/**
 * Interface that defines a stack-like collection.
 *
 * @param <T> type of stored elements
 */
public interface Collection<T> {

    /** Pushes an element onto the collection */
    void push(T element);

    /** Removes and returns the top element */
    T pop();

    /** Returns the top element without removing it */
    T peek();

    /** @return true if the collection is empty */
    boolean isEmpty();
}
