import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class SkipListSet<E extends Comparable<E>> extends AbstractSet<E> {

    public int numElement;
    public SkipNode<E> firstNode = new SkipNode<E>(null);
    public int numLevel;

    public SkipListSet() {
    }

    public SkipListSet(Collection<? extends E> c) {

    }

    private Random rand = new Random();

    public boolean add(E o) {
        SkipNode<E> skipNode = new SkipNode<>(o);

        for (int i = 0; i < numLevel; i++) {
            if (rand.nextInt((int) Math.pow(2, i)) == 0) {
                add(skipNode, i);
            }
        }

        return true;
    }

    public void add(SkipNode<E> skipNode, int level) {
        firstNode.add(skipNode, level);
    }

    public void print() {
        for (int i = numLevel - 1; i >= 0; i--) {
            firstNode.printLevel(i);
            System.out.println("\n");
        }

    }

    public SkipNode<E> search(Object obj) {
        SkipNode<E> result = null;

        for (int i = numLevel - 1; i >= 0; i--) {
            result = firstNode.search(obj, i);
            if (result != null) {
                break;
            }
        }

        return result;
    }

    public boolean remove(Object obj) {
        SkipNode<E> deleteNode = search(obj);
        if (deleteNode == null) {
            return false;
        } else {
            deleteNode.element = null;
        }

        for (int i = 0; i < numLevel; i++) {
            firstNode.refreshAfterDelete(i);
        }

        // System.out.println();
        return true;
    }

    @Override
    public boolean contains(Object obj) {
        SkipNode<E> findNode = search(obj);
        if (findNode != null) {
            return true;
        }

        return false;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<E> iterator() {
        return new SkipListIterator(this, 0);
    }

    @Override
    public int size() {
        return numElement;
    }

}