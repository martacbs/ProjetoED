package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterator<T> {

    private LinearNode<T> current;

    public StackIterator(LinearNode<T> list) {
        this.current = list;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T result = this.current.getElement();
        this.current = this.current.getNext();
        return result;
    }

}
