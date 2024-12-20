package Ass3.q2;



public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<Entry<K, V>>();

    public HeapPriorityQueue() {super();}

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected  int parent(int j) {return (j-1)/2;}
    protected  int left(int j) {return (2*j+1);}
    protected  int right(int j) {return (2*j+2);}
    protected boolean hasLeft(int j) { return left(j) < heap.size();}
    protected boolean hasRight(int j) { return right(j) < heap.size();}

    protected void swap(int i, int j) {
        Entry<K, V> tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
    public  Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(heap.size()-1, newest);
        unHeap(heap.size()-1);
        return newest;
    }
    protected void unHeap(int i) {
        while (i>0) {
            int p = parent(i);
            if (compare(heap.get(i), heap.get(p)) > 0 ) { break;}
            swap(i, p);
            i = p;
        }
    }

    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {return null;}
        Entry<K, V> toReturn = heap.get(0);
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        downHeap(0);
        return toReturn;
    }
    protected void downHeap(int i) {
        while (hasLeft(i)) {
            int leftChild = left(i);
            int smallestChildIndex = leftChild;

            if (hasRight(i)) {
                int rightChild = right(i);
                if (compare(heap.get(rightChild), heap.get(leftChild)) > 0) {
                    smallestChildIndex = rightChild;
                }
            }

            if (compare(heap.get(smallestChildIndex), heap.get(i)) >= 0) {
                break;
            }
            swap(smallestChildIndex, i);
            i = smallestChildIndex;
        }
    }
        

    public int size() {return heap.size();}

    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }


}
