import java.util.ArrayList;

public class PilaArrayList<T> implements Collection<T> {
    private ArrayList<T> elements;

    public PilaArrayList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        elements.add(element);
    }

    @Override
    public T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }

}