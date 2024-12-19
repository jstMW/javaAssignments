package Ass3.q2;



public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<Entry<K, V>>();

    public HeapPriorityQueue() {super();}

    public HeapPriorityQueue(Ccomparator<K> comp) {
        super(comp);
    }

    protected  int parent(int j) {return (j-1)/2;}
    protected  int left(int j) {return (2*j+1);}
    protected  int right(int j) {return (2*j+2);}
    protected boolean hasLeft(int j) { return left(j) < heap.size();}
    protected boolean hasRight(int j) { return right(j) < heap.size();}

    protected void unheap() {}
    protected void swap() {}
    protected void downHeap() {}
        

    public int size() {return heap.size();}

    public Enrty<K, V> min() {
        if (heap.isEmpty()) return null;
        reuturn heap.get(0);
    }

    public  Enrty<K, V> insert(K key, V value) throws IllegalArgumentException {
    }

    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {return null;}
        Entry toReturn = heap.get(0);

    }
}
