
package Lab6;

public class LinkedBinaryTree<E> extends AbstractBinarytree<E> {
    private int size = 0;
    protected Position<E> root = null;

    protected static class Node<E> implements Position<E> {
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private E element;

        public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() {
            return this.element;
        }

        public Node<E> getParent() {
            return this.parent;
        }

        public Node<E> getRight() {
            return this.right;
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public void setElement(E e) {
            this.element = e;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }
    }

    public int size() {
        return size;
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    public LinkedBinaryTree() {
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("not a valide position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("not in the tree");
        }
        return node;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).getParent();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return validate(p).getRight();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return validate(p).getLeft();
    }

    // public Iterable<Position<E>> children(Position<E> p) throws
    // IllegalArgumentException {}
    // int numChildren(Position<E> p) throws IllegalArgumentException {}
    // boolean isExternal(Position<E> p) throws IllegalArgumentException {}
    // boolean isInternal(Position<E> p) throws IllegalArgumentException {}
    // boolean isRoot(Position<E> p) throws IllegalArgumentException {}//public
    // Position<E> sibling(Position<E> p) throws IllegalArgumentException {}
    // boolean isEmpty() {}

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        if (node.getLeft() != null) {
            throw new IllegalStateException("p has a left child");
        }
        Node<E> newNode = createNode(e, node, null, null);
        node.setLeft(newNode);
        size++;
        return newNode;

    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalStateException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalStateException("p has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E setElement(Position<E> p, E e) throws IllegalStateException {
        Node<E> node = validate(p);
        E oldElement = node.getElement();
        node.setElement(e);
        return oldElement;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(node) == 2) {
            throw new IllegalArgumentException("p has 2 children");
        }
        // now p either has 1 or none child
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(child);
            } else {
                node.getParent().setRight(child);
            }
        }
        E removed = p.getElement();
        node.setLeft(null);
        node.setRight(null);
        node.setElement(null);
        node.setParent(node);
        size--;
        return removed;

    }

    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }
}
