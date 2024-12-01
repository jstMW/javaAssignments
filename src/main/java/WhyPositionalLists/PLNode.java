package WhyPositionalLists;

public class PLNode<E> {
    private PLNode<E> next;
    private PLNode<E> prev;
    private E element;

    public PLNode(PLNode<E> next, PLNode<E> prev, E element) {
        this.next = next;
        this.prev = prev;
        this.element = element;
    }

    public void setNext(PLNode<E> next) {
        this.next = next;
    }

    public void setPrev(PLNode<E> prev) {
        this.prev = prev;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public PLNode<E> getNext() {
        return this.next;
    }

    public PLNode<E> getPrev() {
        return this.prev;
    }

    public E getElement() {
        return this.element;
    }

}
