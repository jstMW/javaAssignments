package WhyPositionalLists;

public class UnsafePositionalList<E> {

    private PLNode<E> header;
    private PLNode<E> trailer;
    private int size = 0;

    public UnsafePositionalList() {
        this.header = new PLNode<E>(null, null, null);
        this.trailer = new PLNode<E>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public PLNode<E> first() {
        return header.getNext();
    }

    public PLNode<E> last() {
        return trailer.getPrev();
    }

    public PLNode<E> after(PLNode<E> plnode) {
        return plnode.getNext();
    }

    public PLNode<E> before(PLNode<E> plnode) {
        return plnode.getPrev();
    }

    public PLNode<E> addBetween(E element, PLNode<E> pred, PLNode<E> succ) {
        PLNode<E> newNode = new PLNode<E>(succ, pred, element);

        pred.setNext(newNode);
        succ.setPrev(newNode);

        size++;

        return newNode;
    }

    public PLNode<E> addFirst(E element) {
        return addBetween(element, header, header.getNext());
    }

    public PLNode<E> addLast(E element) {
        return addBetween(element, trailer.getPrev(), trailer);
    }

    public PLNode<E> addAfter(E element, PLNode<E> pred) {
        return addBetween(element, pred, pred.getNext());
    }

    public PLNode<E> addBefore(E element, PLNode<E> succ) {
        return addBetween(element, succ.getPrev(), succ);
    }

    public E set(PLNode<E> plnode, E element) {
        E tmp = plnode.getElement();
        plnode.setElement(element);
        return tmp;
    }

    public E remove(PLNode<E> plnode) {
        E tmp = plnode.getElement();

        plnode.getPrev().setNext(plnode.getNext());
        plnode.getNext().setPrev(plnode.getPrev());
        size--;

        plnode.setPrev(null);
        plnode.setNext(null);
        plnode.setElement(null);

        return tmp;
    }
}
