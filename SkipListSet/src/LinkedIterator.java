import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<E extends Comparable<E>> implements Iterator<E> {
    private SkipNode<E> nextNode;

    public LinkedIterator(SkipNode<E> firstNode) {
        nextNode = firstNode;
    }

    public boolean hasNext() {
        return (nextNode != null);
    }

    public E next() throws NoSuchElementException {
        return null;
        
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}