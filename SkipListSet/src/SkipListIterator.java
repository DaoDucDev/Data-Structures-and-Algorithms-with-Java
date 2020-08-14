import java.util.Iterator;

class SkipListIterator<E extends Comparable<E>> implements Iterator<E> {
    SkipListSet<E> list;
    SkipNode<E> current;
    int level;

    public SkipListIterator(SkipListSet<E> list, int level) {
        this.list = list;
        this.current = list.firstNode;
        this.level = level;
    }

    public boolean hasNext() {
        return current.getNext(level) != null;
    }

    public E next() {
        current = current.getNext(level);
        return current.getValue();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}